package ie.headway.app.howtodoit;

import android.content.Intent;
import android.os.Handler;

import ie.headway.app.HeadwaySplashScreenActivity;

public class SplashScreenActivity extends HeadwaySplashScreenActivity {

	public SplashScreenActivity() {
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
	}

	/**
	 * TODO Inspect this method to see if it can be improved,
	 * or if a more efficient approarch can be taken. This code
	 * was copy-pasta from stackOverflow and I don't know how it works.
	 * */
	@Override
	protected void exitSplashScreen(final long delay) {
        new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				final Intent i = new Intent(getApplicationContext(), TaskSelectionActivity.class);
				startActivity(i);
			}
		}, delay);
	}

}
