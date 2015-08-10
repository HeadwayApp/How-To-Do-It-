package ie.headway.app.howtodoit.gui;

import android.view.View;

/**
 * A visual represenation of the object, analogous to toString().
 * */
public interface Viewable {
	
	/**
	 * Returns a {@link android.view.View} representing this object.
	 * 
	 * @return The view.
	 * */
	View getView();
	
}
