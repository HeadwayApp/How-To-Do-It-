package ie.headway.app.howtodoit.gui;

import static android.widget.LinearLayout.VERTICAL;
import ie.headway.app.howtodoit.xml.Step;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StepLayout extends Fragment implements Layoutable<LinearLayout> {

	private final LinearLayout mLayout;

	public StepLayout(Context context, Step step) {
		mLayout = new LinearLayout(context);
		mLayout.setOrientation(VERTICAL);

		final TextView text = new TextView(context);
		text.setText(step.getText());
		text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 65);
		text.setGravity(Gravity.CENTER);
		mLayout.addView(text);

		final ImageView image = new ImageView(context);
		image.setImageURI(
				new Uri.Builder().path(step.getImagePath()).build());
		mLayout.addView(image);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return getLayout();
	}

	@Override
	public LinearLayout getLayout() {
		return mLayout;
	}

}
