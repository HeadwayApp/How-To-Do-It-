package ie.headway.app.howtodoit.audio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

public class TaskAudioPlayer extends Service {

	private MediaPlayer mMediaPlayer;
	private CharSequence mAudioFilePath;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onDestroy() {       
		mMediaPlayer.stop();
	}
	
	@Override
	public void onStart(Intent intent,int startid){
		mAudioFilePath = intent.getCharSequenceExtra("AUDIO_PATH");
		mMediaPlayer = MediaPlayer.create(this, 
				new Uri.Builder().path(mAudioFilePath.toString()).build());
		mMediaPlayer.setLooping(false);
		mMediaPlayer.start();
	}

}
