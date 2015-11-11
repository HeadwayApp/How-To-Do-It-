package ie.headway.app.howtodoit;

import android.content.Intent;
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

import ie.headway.app.xml.Task;

import static ie.headway.app.util.AppDir.ROOT;

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
        startActivity(new Intent(this, TaskSelectionActivity.class));
    }

}
