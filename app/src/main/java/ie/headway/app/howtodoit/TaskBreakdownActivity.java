package ie.headway.app.howtodoit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import ie.headway.app.howtodoit.gui.StepLayoutFragment;
import ie.headway.app.xml.Task;

import static ie.headway.app.disk.AppDir.ROOT;

public class TaskBreakdownActivity extends FragmentActivity {
    
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(final Bundle savedInstanceBundle) {
		super.onCreate(savedInstanceBundle);		
		setContentView(R.layout.activity_task_breakdown);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new TaskBreakdownAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
	}

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class TaskBreakdownAdapter extends FragmentStatePagerAdapter {
    	
    	final File taskDir = ROOT.getFile(getIntent().getCharSequenceExtra("TASK"));
    	final File taskFile = new File(taskDir, "task.xml");
    	
        public TaskBreakdownAdapter(final FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(final int position) {
    		final Serializer serializer = new Persister();
    
    		Task makeTeaTask;
    		try {
    			makeTeaTask = serializer.read(Task.class, taskFile);
    		}catch(Exception e) {
    			throw new RuntimeException("Deserialization failed!", e);
    		}
    		
    		return StepLayoutFragment.newInstance(makeTeaTask.getStep(position));
        }

        /**
         * TODO This can cause crashes if there are unused images in the imgs directory.
         * */
        @Override
        public int getCount() {
            return new File(taskDir, "imgs").list().length;
        }
    }

}
