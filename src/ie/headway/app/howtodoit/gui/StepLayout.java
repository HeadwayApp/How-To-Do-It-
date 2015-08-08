package ie.headway.app.howtodoit.gui;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;
import ie.headway.app.howtodoit.xml.Step;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
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

public class StepLayout extends Fragment implements Viewable {

	private final Step mStep;
	
	private final LinearLayout mLayout;
	private final TextView mText;
	private final ImageView mImage;

	public StepLayout(Context context, Step step) {
		mStep = step;
		
		mLayout = new LinearLayout(context);
		mLayout.setOrientation(VERTICAL);

		mText = new TextView(context);
		mText.setText(step.getText());
		mText.setTextSize(COMPLEX_UNIT_SP, 25);
		mText.setGravity(CENTER);
		mText.setLayoutParams(new LayoutParams(MATCH_PARENT, WRAP_CONTENT));
		mLayout.addView(mText);

		mImage = new ImageView(context);
		mImage.setLayoutParams(new LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
		mImage.setImageURI(
				new Uri.Builder().path(step.getImagePath()).build());
		mLayout.addView(mImage);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mImage.setPadding(0, 0, 0, px2Dp(15));
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return getLayout();
	}

	@Override
	public View getLayout() {
		return mLayout;
	}
	
	@Override
	public String toString() {
		return "Step = " + mStep;
	}
	
	private int px2Dp(int dp) {
		final Activity activity = getActivity();
		final Resources resources = activity.getResources();
		final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
	    final float scale = displayMetrics.density;
	    int px = (int) (dp * scale + 0.5f);
	    return px;
	}

}
