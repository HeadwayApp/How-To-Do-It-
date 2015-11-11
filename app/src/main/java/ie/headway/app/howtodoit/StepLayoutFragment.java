package ie.headway.app.howtodoit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ie.headway.app.xml.Step;

public class StepLayoutFragment extends Fragment {

	public static final StepLayoutFragment newInstance(Step step) {
		final StepLayoutFragment stepLayoutFragment = new StepLayoutFragment();
		final Bundle argsBundle = new Bundle(1);
		argsBundle.putParcelable("step", step);
		stepLayoutFragment.setArguments(argsBundle);
		return stepLayoutFragment;
	}
	
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
    final LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.step_layout_fragment, container, false);

    final Step step = getStep();
    final String stepText = step.getText();

    final TextView stepTextView = (TextView)layout.findViewById(R.id.step_layout_text_view);
    stepTextView.setText(stepText);

    final ImageView imageView = (ImageView)layout.findViewById(R.id.step_layout_image_view);
    final Bitmap imageBitmap = getImageBitmap();
    imageView.setImageBitmap(imageBitmap);

    return layout;
	}

  private Step getStep() {
    final Bundle args = getArguments();
    return args.getParcelable("step");
  }

  private Bitmap getImageBitmap() {
    /**
     * TODO: The sample size should be setable with the advanced options in the companion app.
     * Perhaps the device RAM or the XML could give an indication of what inSampleSize should be
     * set to.
     * */
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inSampleSize = 1;

    final Step step = getStep();
    final String imagePath = step.getImagePath();

    final Bitmap bitmap  = BitmapFactory.decodeFile(imagePath, options);
    return bitmap;
  }

}
