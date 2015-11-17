package ie.headway.app.how_to_do_it;

import android.content.Intent;

import ie.headway.app.util.HeadwaySplashScreenActivity;

public class SplashScreenActivity extends HeadwaySplashScreenActivity {

	@Override
	protected void exitSplashScreen(final long delay) {
    runAfterDelay(new Runnable() {
      @Override
      public void run() {
        final Intent i = new Intent(getApplicationContext(), TaskSelectionActivity.class);
        startActivity(i);
      }
    }, delay);
	}

}
