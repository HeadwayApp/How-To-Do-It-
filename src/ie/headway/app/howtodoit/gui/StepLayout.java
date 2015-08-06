package ie.headway.app.howtodoit.gui;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;
import ie.headway.app.howtodoit.xml.Step;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class StepLayout extends Fragment implements Layoutable<LinearLayout> {

	private final LinearLayout mLayout;

	public StepLayout(Context context, Step step) {
		mLayout = new LinearLayout(context);
		mLayout.setOrientation(VERTICAL);

		final TextView text = new TextView(context);
		text.setText(step.getText());
		text.setTextSize(COMPLEX_UNIT_SP, 65);
		text.setGravity(CENTER);
		text.setLayoutParams(new LayoutParams(MATCH_PARENT, WRAP_CONTENT));
		mLayout.addView(text);

		final ImageView image = new ImageView(context);
		image.setLayoutParams(new LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
		image.setPadding(0, 0, 0, 15);
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
