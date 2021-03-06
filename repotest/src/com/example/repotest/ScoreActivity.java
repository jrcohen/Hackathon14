package com.example.repotest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class ScoreActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//String name = mainUser.getName();
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		//textView.setText(mainUser.userName);
		
		setContentView(R.layout.activity_score);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
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
	
	public void goToBonusPoints(View view) {
		Intent BonusPointsActivity = new Intent(this, BonusPointsActivity.class);
		startActivity(BonusPointsActivity);		
	}
	
	public void goToLeaderboard(View view) {
		Intent LeaderboardActivity = new Intent(this, LeaderboardActivity.class);
		startActivity(LeaderboardActivity);		
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
			View rootView = inflater.inflate(R.layout.fragment_score,
					container, false);
			return rootView;
		}
	}
	
	/*
	public void startLeaderboardActivity(View view) {
		Intent LeaderboardActivity = new Intent(this, LeaderboardActivity.class);
		startActivity(LeaderboardActivity);		
	}
	*/
	
	/*
	public void startGPS_Activity(View view) {
		Intent GPS_Activity = new Intent(this, GPS_Activity.class);
		startActivity(GPS_Activity);	
	}
	*/

}