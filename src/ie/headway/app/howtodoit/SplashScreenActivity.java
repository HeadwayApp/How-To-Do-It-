package ie.headway.app.howtodoit;

import android.content.Intent;
import android.os.Handler;
import ie.headway.app.HeadwaySplashScreenActivity;

public class SplashScreenActivity extends HeadwaySplashScreenActivity {

	@Override
	protected void exitSplashScreen(long delay) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				final Intent i = new Intent(getApplicationContext(), TaskSelectionActivity.class);
				startActivity(i);
			}
		}, delay);
	}

}
