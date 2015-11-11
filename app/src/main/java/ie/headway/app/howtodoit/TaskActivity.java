package ie.headway.app.howtodoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class TaskActivity extends FragmentActivity {
    
  private ViewPager mPager;
  private PagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(final Bundle savedInstanceBundle) {
		super.onCreate(savedInstanceBundle);		
		setContentView(R.layout.activity_task_breakdown);
    setViewPager();
	}

  private void setViewPager() {
    mPager = (ViewPager) findViewById(R.id.task_pager);
    mPagerAdapter = new TaskPagerAdapter(getSupportFragmentManager(), getIntent());
    mPager.setAdapter(mPagerAdapter);
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(this, TaskSelectionActivity.class));
  }

}
