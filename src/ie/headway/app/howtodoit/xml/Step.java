package ie.headway.app.howtodoit.xml;

import java.io.File;

import org.simpleframework.xml.Attribute;

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

	public String getAudioPath() {
		return audioPath;
	}

	@Override
	public String toString() {
		return text + " : " + new File(imagePath).getName() + " : " + new File(audioPath).getName();
	}

	public PortableStep getPortableStep() {
		return new PortableStep(this);
	}

}
