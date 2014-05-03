package com.example.repotest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class LeaderboardActivity extends ActionBarActivity {
//	Context context = getApplicationContext();
//	//CharSequence text = "Hello toast!";
//	int duration = Toast.LENGTH_SHORT;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaderboard);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		populateTable(1);
	}

	public void buttonHandler(View v)
	{
		
		int id = v.getId();
		int button = 0;
	    switch (id) {
	    case R.id.button1:
	    	button = 1;
	        break;
	    case R.id.button2:
	    	button = 2;
	        break;
	    case R.id.button3:
	    	button = 3;
	        break;
	    case R.id.button4:
	    	button = 4;
	        break;
	    }
	    if (button != 0)
	    {
//	    	Toast toast = Toast.makeText(context, "!!"+button, duration);
//	    	toast.show();5
	    	populateTable(button);
	    }
	}
	
	public void populateTable(int table_id)
	{
		String title = "";
		switch (table_id) {
			case 1: title = "Daily - Individual";
				break;
			case 2: title = "Daily - Team";
				break;
			case 3: title = "All Time - Individual";
				break;
			case 4: title = "All Time - Team";
				break;
		}
		TextView titleBox = (TextView) findViewById(R.id.leaderboard_title);
		titleBox.setText(title);
		destroyTable();
		
		//do database query here, populate 2 Collections
		String [] names = {"first", "second", "third","first", "second", "third","first", "second", "third","first", "second", "third"};
		int [] scores = {1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3};
		
		//retrieve table from xml
		TableLayout table = (TableLayout) findViewById(R.id.table_1);
		
		//create header column and populate
		TableRow tHeader = new TableRow(this);
		//tHeader.setId(42);
		tHeader.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		TextView col1 = new TextView(this);
		TextView col2 = new TextView(this);
		
		col1.setText("Name");
		col2.setText("Score");
		
		tHeader.addView(col1);
		tHeader.addView(col2);
		//add header to the table
		table.addView(tHeader, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
		
		String name;
		int score;
		for (int i = 0; i < 10; i++)
		{
			TableRow rNew = new TableRow(this);
			TextView rName = new TextView(this);
			TextView rScore = new TextView(this);
			
			name = names[i];
			score = scores[i];
			
			rName.setText(name);
			rScore.setText(""+score);
			
			rNew.addView(rName);
			rNew.addView(rScore);
			
			table.addView(rNew);
		}
	}
	
	//obviously not the most efficient way of updating a table
	public void destroyTable()
	{
		TableLayout table = (TableLayout) findViewById(R.id.table_1);
		table.removeAllViews();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaderboard, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_leaderboard,
					container, false);
			return rootView;
		}
	}

}
