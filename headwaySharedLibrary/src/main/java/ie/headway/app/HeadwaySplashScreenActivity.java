package ie.headway.app;

import android.app.Activity;
import android.os.Bundle;

import ie.headway.app.util.ExceptionHandler;

import static ie.headway.app.disk.AppDir.makeAppDirs;

public abstract class HeadwaySplashScreenActivity extends Activity {

  private static long SPLASH_SCREEN_TIMEOUT = 5000L;

	@Override
	public void onCreate(final Bundle savedInstanceBundle) {
		super.onCreate(savedInstanceBundle);
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		fixBackStack();
		setContentView(R.layout.activity_splash_screen);
		makeAppDirs();
		exitSplashScreen(SPLASH_SCREEN_TIMEOUT);
	}

	/**
	 * This method is used to circumvent a bug which has existed in Android since API 1 whereby the
   * app appears to restart when it should resume,
   * see: http://stackoverflow.com/questions/18449541/android-application-restarts-when-opened-by-clicking-the-application-icon
   * for more information.
	 * */
	private void fixBackStack() {
		if (!isTaskRoot()) {
			finish();
			return;
		}
	}
	
	/**
	 * This method is called at the end of HeadwaySplashScreenActivity
	 * */
	protected abstract void exitSplashScreen(final long delay);

}
