package ie.headway.app.howtodoit;

import static ie.headway.app.howtodoit.disk.AppDir.makeAppDirs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	@Override
	public void onCreate(final Bundle savedInstanceBundle) {
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.activity_splash_screen);
		makeAppDirs();
		exitSplashScreen(5000);
	}
	
	/**
	 * TODO Inspect this method to see if it can be improved,
	 * or if a more efficient approarch can be taken. This code
	 * was copy-pasta from stackOverflow and I don't know how it works.
	 * */
	private void exitSplashScreen(final long delay) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				final Intent i = new Intent(getApplicationContext(), TaskSelectionActivity.class);
				startActivity(i);
			}
		}, delay);
	}

}
