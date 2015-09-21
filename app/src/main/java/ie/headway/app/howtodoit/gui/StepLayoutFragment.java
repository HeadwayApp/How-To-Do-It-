package ie.headway.app.howtodoit.gui;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ie.headway.app.xml.Step;

public class StepLayoutFragment extends Fragment {

	private static final String STEP_KEY = "STEP";

	private Step mStep;
	
	private LinearLayout mView;
	private TextView mText;
	private ImageView mImage;

	public static final StepLayoutFragment newInstance(Step step) {
		final StepLayoutFragment stepLayoutFragment = new StepLayoutFragment();
		final Bundle argsBundle = new Bundle(1);
		argsBundle.putParcelable(STEP_KEY, step);
		stepLayoutFragment.setArguments(argsBundle);
		
		return stepLayoutFragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mStep = getArguments().getParcelable(STEP_KEY);
		
		mView = new LinearLayout(getActivity().getBaseContext());
		mView.setOrientation(VERTICAL);

		mText = new TextView(getActivity().getBaseContext());
		mText.setText(mStep.getText());
		mText.setTextSize(COMPLEX_UNIT_SP, 25);
		mText.setGravity(CENTER);
		mText.setLayoutParams(new LayoutParams(MATCH_PARENT, WRAP_CONTENT));
		mView.addView(mText);

		mImage = new ImageView(getActivity().getBaseContext());
		mImage.setLayoutParams(new LayoutParams(MATCH_PARENT, MATCH_PARENT));
		mImage.setPadding(0, 0, 0, px2Dp(getActivity(), 15));
		
		/**
		 * TODO: The sample size should be setable with the advanced options in the companion app.
		 * Perhaps the device RAM or the XML could give an indication of what inSampleSize should be
		 * set to.
		 * */
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 4;
		
		final Bitmap bitmap  = BitmapFactory.decodeFile(mStep.getImagePath(), options);
		mImage.setImageBitmap(bitmap);
		
		mView.addView(mImage);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return mView;
	}
	
	@Override
	public String toString() {
		return "Step = " + mStep;
	}
	
	private int px2Dp(final Activity activity, final int dp) {
		final Resources resources = activity.getResources();
		final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
	    final float scale = displayMetrics.density;
	    int px = (int) (dp * scale + 0.5f);
	    return px;
	}

}
