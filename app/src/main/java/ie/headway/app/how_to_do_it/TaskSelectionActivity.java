package ie.headway.app.how_to_do_it;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;

import ie.headway.app.util.AppDir;
import ie.headway.app.util.HiddenFileNameFilter;
import ie.headway.app.xml.task.Task;

public class TaskSelectionActivity extends ListActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_selection);
	}

	@Override
  protected void onResume() {
    super.onResume();
    final ListAdapter adapter = getAdapter();
    setListAdapter(adapter);
  }

	@Override
	protected void onListItemClick (final ListView l, final View v, final int pos, final long id) {
		final Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
		if(v instanceof TextView) {
      final String taskName = ((TextView)v).getText().toString();
      final Task task = new Task(taskName, null);
      if(task.doesTaskExist()) {
        intent.putExtra("task", taskName);
        startActivity(intent);
      }else {
        final Toast toast = Toast.makeText(this, "Not a valid task", Toast.LENGTH_LONG);
        toast.show();
      }
		}else {
			Toast.makeText(getApplicationContext(), R.string.cant_start_task, Toast.LENGTH_LONG).show();
		}
	}

	private ListAdapter getAdapter() {
		final ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), R.layout.task_list_item);
		final File rootDir = AppDir.ROOT.getFile();
		final FilenameFilter hiddenFileFilter = new HiddenFileNameFilter();
		final String[] fileNameLst = rootDir.list(hiddenFileFilter);
		adapter.addAll(fileNameLst);
		return adapter;
	}

}
