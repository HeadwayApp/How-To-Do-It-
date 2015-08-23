package ie.headway.app.howtodoit;

import static ie.headway.app.howtodoit.disk.AppDir.ROOT;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaskSelectionActivity extends ListActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_selection);
		final ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(getBaseContext(), R.layout.task_list_item);
		adapter.addAll(ROOT.getFile().list());
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

}
