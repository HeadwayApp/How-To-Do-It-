package ie.headway.app.howtodoit;

import android.util.Log;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e("headway", "exception occurred", ex);
    }

}
