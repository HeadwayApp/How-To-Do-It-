package ie.headway.app.howtodoit;

import static ie.headway.app.howtodoit.disk.AppDir.ROOT;
import ie.headway.app.howtodoit.gui.StepLayout;
import ie.headway.app.howtodoit.xml.Task;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class TaskBreakdownActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 21;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceBundle) {
		super.onCreate(savedInstanceBundle);

//		final List<Step> steps = new ArrayList<Step>();
//		
//		final Task task = new Task("Make Coffee", steps);
//		task.addStep(new Step("Go the kitchen.", ROOT.getPath("MakeCoffee", "imgs", "1.jpg"), ""));
//		task.addStep(new Step("Go to the press under the microwave.", ROOT.getPath("MakeCoffee", "imgs", "2.jpg"), ""));
//		task.addStep(new Step("Open the press.", ROOT.getPath("MakeCoffee", "imgs", "3.jpg"), ""));
//		task.addStep(new Step("Take a mug.", ROOT.getPath("MakeCoffee", "imgs", "4.jpg"), ""));
//		task.addStep(new Step("Put it on the counter behind you.", ROOT.getPath("MakeCoffee", "imgs", "5.jpg"), ""));
//		task.addStep(new Step("Go back to the press for the coffee.", ROOT.getPath("MakeCoffee", "imgs", "6.jpg"), ""));
//		task.addStep(new Step("Put the coffee on the counter behind you next to the cup.", ROOT.getPath("MakeCoffee", "imgs", "7.jpg"), ""));
//		task.addStep(new Step("Take the lid off the coffee jar.", ROOT.getPath("MakeCoffee", "imgs", "8.jpg"), ""));
//		task.addStep(new Step("Go over to the sink.", ROOT.getPath("MakeCoffee", "imgs", "9.jpg"), ""));
//		task.addStep(new Step("Go to the drawer on the top right under the sink.", ROOT.getPath("MakeCoffee", "imgs", "10.jpg"), ""));
//		task.addStep(new Step("Open the drawer.", ROOT.getPath("MakeCoffee", "imgs", "11.jpg"), ""));
//		task.addStep(new Step("Take a spoon.", ROOT.getPath("MakeCoffee", "imgs", "12.jpg"), ""));
//		task.addStep(new Step("Put a spoon of coffee in to the mug.", ROOT.getPath("MakeCoffee", "imgs", "13.jpg"), ""));
//		task.addStep(new Step("", ROOT.getPath("MakeCoffee", "imgs", "14.jpg"), ""));
//		task.addStep(new Step("Put the mug under the hot water tap.", ROOT.getPath("MakeCoffee", "imgs", "16.jpg"), ""));
//		task.addStep(new Step("Put your hand on the lever and pull it towards you until the cup is three quarters full.", ROOT.getPath("MakeCoffee", "imgs", "17.jpg"), ""));
//		task.addStep(new Step("Stir the coffee with the spoon.", ROOT.getPath("MakeCoffee", "imgs", "19.jpg"), ""));
//		task.addStep(new Step("Add milk from the milk machine.", ROOT.getPath("MakeCoffee", "imgs", "20.jpg"), ""));
//		task.addStep(new Step("Stri the coffee again.", ROOT.getPath("MakeCoffee", "imgs", "21.jpg"), ""));
//		task.addStep(new Step("Put the lid back on the coffee.", ROOT.getPath("MakeCoffee", "imgs", "22.jpg"), ""));
//		task.addStep(new Step("Drink the coffee!", ROOT.getPath("MakeCoffee", "imgs", "23.jpg"), ""));
//		
//		final Serializer serializer = new Persister();
//		final File result = ROOT.getFile("MakeCoffee", "task.xml");
//		try {
//			serializer.write(task, result);
//		} catch (Exception e) {
//			throw new RuntimeException("Serialization failed!", e);
//		}
		
		setContentView(R.layout.activity_task_breakdown);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
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

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	
    		final Serializer serializer = new Persister();
    		final File source = ROOT.getFile(getIntent().getCharSequenceExtra("TASK"), "task.xml");
    
    		Task makeTeaTask;
    		try {
    			makeTeaTask = serializer.read(Task.class, source);
    		}catch(Exception e) {
    			throw new RuntimeException("Deserialization failed!", e);
    		}
    		
    		return new StepLayout(getApplicationContext(), makeTeaTask.getStep(position));
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
