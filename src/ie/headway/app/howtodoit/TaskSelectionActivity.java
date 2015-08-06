package ie.headway.app.howtodoit;

import static ie.headway.app.howtodoit.disk.AppDir.ROOT;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TaskSelectionActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_selection);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.task_list_item);
        adapter.addAll(ROOT.getFile().list());
        setListAdapter(adapter);
    }

	@Override
	protected void onListItemClick (ListView l, View v, int position, long id) {
		final Intent intent = new Intent(getApplicationContext(), TaskBreakdownActivity.class);
		intent.putExtra("TASK", ((TextView)v).getText());
		startActivity(intent);
	}

}
