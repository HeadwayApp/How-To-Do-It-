package ie.headway.app.how_to_do_it;

import android.content.Intent;
/**
 * TODO: Using support library is not necessary. Use up to date api.
 *
 * TODO: Shouldn't be paging through fragments at all! Very inefficient, should extend a parent on CreateStepView.
 * */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ie.headway.app.xml.Task;
import ie.headway.app.xml.TaskNotFoundException;
import ie.headway.app.xml.TaskPersister;

public class TaskPagerAdapter extends FragmentStatePagerAdapter {

  final Task mTask;

  public TaskPagerAdapter(final FragmentManager fm, final Intent intent) {
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
    final TaskPersister taskDeserialiser = new TaskPersister(taskName);

    try {
      return taskDeserialiser.read();
    } catch (TaskNotFoundException e) {
      throw new RuntimeException("task persister couldn't read task " + taskName, e);
    }
  }

}
