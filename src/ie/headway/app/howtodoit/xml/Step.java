package ie.headway.app.howtodoit.xml;

import java.io.File;

import org.simpleframework.xml.Attribute;

import android.os.Environment;

public class Step {

	@Attribute private String text;
	@Attribute private String imagePath;
	@Attribute private String audioPath;

	public Step() {

	}

	public Step(String text, String imagePath, String audioPath) {
		this.text = text;
		this.imagePath = imagePath;
		this.audioPath = audioPath;
	}

	public String getText() {
		return text;
	}

	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @debug Remove
	 * */
	public String getPortableImagePath() {
		return Environment.getExternalStorageDirectory() + File.separator + 
				"Headway" + File.separator + imagePath.split("Headway")[1];
	}

	public String getAudioPath() {
		return audioPath;
	}

	@Override
	public String toString() {
		return text + " : " + new File(imagePath).getName() + " : " + new File(audioPath).getName();
	}

}
