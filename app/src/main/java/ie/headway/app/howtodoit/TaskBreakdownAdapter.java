package ie.headway.app.howtodoit;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ie.headway.app.xml.Task;
import ie.headway.app.xml.TaskNotFoundException;
import ie.headway.app.xml.TaskPersister;

public class TaskBreakdownAdapter extends FragmentStatePagerAdapter {

  final Task mTask;

  public TaskBreakdownAdapter(final FragmentManager fm, final Intent intent) {
    super(fm);
    mTask = retrieveTask(intent);
  }

  @Override
  public Fragment getItem(final int position) {
    return StepLayoutFragment.newInstance(mTask.getStep(position));
  }

  @Override
  public int getCount() {
    return mTask.getStepCount();
  }

  private Task retrieveTask(final Intent intent) {
    final String taskName = intent.getCharSequenceExtra("task").toString();
    final TaskPersister taskDeserialiser = new TaskPersister();

    try {
      return taskDeserialiser.read(taskName);
    } catch (TaskNotFoundException e) {
      throw new RuntimeException("task persister couldn't read task " + taskName, e);
    }
  }

}
