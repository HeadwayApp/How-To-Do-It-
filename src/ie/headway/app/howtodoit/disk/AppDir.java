package ie.headway.app.howtodoit.disk;

import java.io.File;

import android.os.Environment;

public enum AppDir {

	ROOT(Environment.getExternalStorageDirectory() + File.separator + "Headway");
	
	private final String mPath;
	private final File mFile;
	
	private AppDir(String path) {
		mPath = path;
		mFile = new File(path);
	}
	
	public String getPath() {
		return mPath;
	}
	
	public String getPath(String child) {
		return mPath + File.separator + child;
	}
	
	public String getPath(String... children) {
		final StringBuilder pathBuilder = new StringBuilder(mPath);
		for(String child: children) {
			pathBuilder.append(File.separator + child);
		}
		return pathBuilder.toString();
	}
	
	public File getFile() {
		return mFile;
	}
	
	public File getFile(CharSequence... children) {
		File returnFile = mFile;
		for(CharSequence child: children) {
			returnFile = new File(returnFile, child.toString());
		}
		return returnFile;
	}
	
	public static void makeAppDirs() {
		for(AppDir appDir: values()) {
			if(!appDir.getFile().exists()) {
				if(!appDir.getFile().mkdirs()) {
					throw new RuntimeException("Couldn't create " + appDir.getFile());
				}
			}
		}
	}
	
}
