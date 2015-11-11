package ie.headway.app.util;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class HeadwayExceptionHandler implements Thread.UncaughtExceptionHandler {

  private static final String TAG = "HeadwayExceptionHandler";

  @Override
  public void uncaughtException(final Thread thread, final Throwable ex) {
    logExceptionToFile(ex);
  }

  private void logExceptionToFile(final Throwable ex) {
    final File logFile = AppDir.LOGS.getFile("headway_" + System.currentTimeMillis() + ".log");
    PrintStream ps = null;
    try {
      ps = new PrintStream(logFile);
      ex.printStackTrace(ps);
      ps.flush();
    } catch (FileNotFoundException e) {
      Log.e(TAG, "couldn't write exception to file:  " + ex.toString());
    } finally {
      if(ps != null) ps.close();
    }
  }

}
