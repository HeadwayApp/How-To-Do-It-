package ie.headway.app.howtodoit;

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

import ie.headway.app.util.AppDir;
import ie.headway.app.util.HiddenFileNameFilter;

public class TaskSelectionActivity extends ListActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_selection);
		final ListAdapter adapter = getAdapter();
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick (final ListView l, final View v, final int pos, final long id) {
		final Intent intent = new Intent(getApplicationContext(), TaskBreakdownActivity.class);
		if(v instanceof TextView) {
			intent.putExtra("TASK", ((TextView)v).getText());
			startActivity(intent);
		}else {
			Toast.makeText(getApplicationContext(), R.string.cant_start_task, Toast.LENGTH_LONG).show();
		}
	}

	private ListAdapter getAdapter() {
		final ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), R.layout.task_list_item);
		final File rootFile = AppDir.ROOT.getFile();
		final String[] fileNameLst = rootFile.list(new HiddenFileNameFilter());
		adapter.addAll(fileNameLst);
		return adapter;
	}

}
