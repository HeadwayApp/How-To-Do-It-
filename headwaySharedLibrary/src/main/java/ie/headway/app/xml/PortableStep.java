package ie.headway.app.xml;

import android.os.Environment;

import java.io.File;

/**
 * A {@link Step} which can be serialised/deserialised across different Android devices by use of
 * "artefacts", whereby certain non portable components of the data contained within the step is automatically
 * replaced with an artefact before serialization and resolved at runtime on the user device after deserialization.
 *
 * e.g. The root external storage directory of a device which is retrieved by calling {@link Environment#getExternalStorageDirectory()}
 * differs between Android devices, therefore the literal value returned by this method will not always
 * work if written to XML and used by another device, therefore when a portable step is serialized to XML
 * the portion of any path which corresponds to {@link Environment#getExternalStorageDirectory()} is automatically replaced
 * with the string defined in {@link #EXT_STRG_ARTEFACT}, and equally so when the step is deserialised on
 * another device {@link #EXT_STRG_ARTEFACT} is replaced with the value returned from {@link Environment#getExternalStorageDirectory()}
 * when it is being used at runtime.
 * */
public class PortableStep extends Step {

  /**
   * This constant represents the system dependant path element which PortableStep will resolve.
   */
  public static final String EXT_STRG_ARTEFACT = "EXTERNAL_STORAGE_DIRECTORY";

  public PortableStep() {
  }

  public PortableStep(String text, String imagePath, String audioPath) {
    super(text, artifisePath(imagePath), artifisePath(audioPath));
  }

  @Override
  public String getImagePath() {
    final String artifisedPath = super.getImagePath();
    return normalisePath(artifisedPath);
  }

  @Override
  public String getAudioPath() {
    final String artifisedPath = super.getAudioPath();
    return normalisePath(artifisedPath);
  }

  private static String artifisePath(final String normalisedPath) {
    final File extStorage = Environment.getExternalStorageDirectory();
    final String extStoragePath = extStorage.getAbsolutePath();
    return normalisedPath.replace(extStoragePath, EXT_STRG_ARTEFACT);
  }

  private static String normalisePath(final String artifisedPath) {
    final File extStorage = Environment.getExternalStorageDirectory();
    final String extStoragePath = extStorage.getAbsolutePath();
    return artifisedPath.replace(EXT_STRG_ARTEFACT, extStoragePath);
  }

}
