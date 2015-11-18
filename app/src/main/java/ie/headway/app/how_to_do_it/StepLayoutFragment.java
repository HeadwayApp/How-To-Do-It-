package ie.headway.app.how_to_do_it;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import ie.headway.app.xml.Step;

public class StepLayoutFragment extends Fragment {

  private Step mStep;
  private MediaPlayer mAudioPlayer;

  @Bind(R.id.step_layout_text_view) TextView mStepTextView;
  @Bind(R.id.step_layout_image_view) ImageView mImageView;

	public static final StepLayoutFragment newInstance(final Step step) {
		final StepLayoutFragment stepLayoutFragment = new StepLayoutFragment();
		final Bundle argsBundle = new Bundle(1);
		argsBundle.putParcelable("step", step);
		stepLayoutFragment.setArguments(argsBundle);
		return stepLayoutFragment;
	}

  @Override
  public void onCreate(final Bundle savedInstanceBundle) {
    super.onCreate(savedInstanceBundle);
    final Bundle args = getArguments();
    mStep = args.getParcelable("step");
  }
	
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.step_layout_fragment, container, false);
    ButterKnife.bind(this, layout);
    setTextViewToStepText();
    setImageViewToStepBitmap();

    return layout;
	}

  @Override
  public void setUserVisibleHint(final boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (isVisibleToUser) {
      startAudioClip();
    }else {
      stopAudioClip();
    }
  }

  private void setTextViewToStepText() {
    final String stepText = mStep.getText();
    mStepTextView.setText(stepText);
  }

  private void setImageViewToStepBitmap() {
    /**
     * TODO: The sample size should be setable with the advanced options in the companion app.
     * Perhaps the device RAM or the XML could give an indication of what inSampleSize should be
     * set to.
     * */
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inSampleSize = 1;

    final String imagePath = mStep.getImagePath();

    final Bitmap bitmap  = BitmapFactory.decodeFile(imagePath, options);

    mImageView.setImageBitmap(bitmap);
  }

  private void startAudioClip() {
    final MediaPlayer audioPlayer = new MediaPlayer();
    final String audioPath = mStep.getAudioPath();
    try {
      audioPlayer.setDataSource(audioPath);
      audioPlayer.prepare();
      audioPlayer.start();
    } catch (IOException ioe) {
      throw new RuntimeException("couldn't start audio " + audioPath, ioe);
    }

    mAudioPlayer = audioPlayer;
  }

  private void stopAudioClip() {
    if(mAudioPlayer != null) mAudioPlayer.release();
    mAudioPlayer = null;
  }

}
