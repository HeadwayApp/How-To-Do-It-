package ie.headway.app.howtodoit.gui;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ie.headway.app.howtodoit.xml.Step;

public class StepLayout extends Fragment implements Viewable {

	private final Step mStep;
	
	private final LinearLayout mView;
	private final TextView mText;
	private final ImageView mImage;

	public StepLayout(Context context, Step step) {
		mStep = step;
		
		mView = new LinearLayout(context);
		mView.setOrientation(VERTICAL);

		mText = new TextView(context);
		mText.setText(step.getText());
		mText.setTextSize(COMPLEX_UNIT_SP, 25);
		mText.setGravity(CENTER);
		mText.setLayoutParams(new LayoutParams(MATCH_PARENT, WRAP_CONTENT));
		mView.addView(mText);

		mImage = new ImageView(context);
		mImage.setLayoutParams(new LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
//		mImage.setImageURI(
//				new Uri.Builder().path(step.getPortableImagePath()).build());
		
		/**
		 * TODO: The sample size should be setable with the advanced options in the companion app.
		 * Perhaps the device RAM or the XML could give an indication of what inSampleSize should be
		 * set to.
		 * */
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 4;
		
		final Bitmap bitmap  = BitmapFactory.decodeFile(step.getPortableImagePath(), options);
		mImage.setImageBitmap(bitmap);
		
		mView.addView(mImage);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mImage.setPadding(0, 0, 0, px2Dp(15));
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return getView();
	}

	@Override
	public View getView() {
		return mView;
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
