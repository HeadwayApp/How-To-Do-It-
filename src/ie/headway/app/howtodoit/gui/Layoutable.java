package ie.headway.app.howtodoit.gui;

import android.view.ViewGroup;

public interface Layoutable<T extends ViewGroup> {
	
	T getLayout();
	
}
