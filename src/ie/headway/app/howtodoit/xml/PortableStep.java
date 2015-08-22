package ie.headway.app.howtodoit.xml;

import java.io.File;

import android.os.Environment;

public class PortableStep extends Step {

	/**
	 * This constant represents the system dependant path element which PortableStep will resolve.
	 * */
	public static final String PORTABLE_PATH_PARENT = "EXTERNAL_STORAGE_DIRECTORY";
	
	public PortableStep() {
		
	}
	
	/**
	 * @debug remove
	 * */
	public PortableStep(String text, String imagePath, String audioPath) {
		super(text, imagePath, audioPath);
	}
	
	/**
	 * @debug Changle impl to release quality.
	 * */
	@Override
	public String getImagePath() {
		return Environment.getExternalStorageDirectory() + File.separator + 
				"Headway" + File.separator + super.getImagePath().split("Headway")[1];
	}
	
}
