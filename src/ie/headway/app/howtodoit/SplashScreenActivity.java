package ie.headway.app.howtodoit;

import static ie.headway.app.howtodoit.disk.AppDir.makeAppDirs;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceBundle) {
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.activity_splash_screen);
		makeAppDirs();
		exitSplashScreen(5000);
	}
	
	private void exitSplashScreen(long delay) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i=new Intent(getApplicationContext(), TaskSelectionActivity.class);
				startActivity(i);
			}
		}, delay);
	}

}
