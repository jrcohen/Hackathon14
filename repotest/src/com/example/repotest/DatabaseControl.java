package com.example.repotest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

	public class DatabaseControl {
		
		// column names
		private static final String KEY_ROWID = "_id";
		private static final String KEY_DATE = "date";
		private static final String KEY_DAYSCORE = "dayScore";
		private static final String KEY_SEASONSCORE = "seasonScore";
		private static final String KEY_DAILYPR = "dailyPR";
		
		// table name
		private static final String DATABASE_TABLE = "inventory";
		
		private Context context;
		private SQLiteDatabase database;
		private DatabaseHelper dbHelper;
		
		public DatabaseControl(Context context) {
			this.context = context;
		}
		
		public DatabaseControl open() throws SQLiteException {
			dbHelper = new DatabaseHelper(context);
			database = dbHelper.getWritableDatabase();
			return this;
		}
		
		public void close() {
			dbHelper.close();
		}
		
		public long addItem(String date, int dayScore, int seasonScore, int dailyPR) {
			ContentValues setUpVals = createContentValues(date,dayScore,seasonScore,dailyPR);
		
			return database.insert(DATABASE_TABLE, null, setUpVals);
		}
		
		public boolean updateItem(long id, String date, int dayScore, int seasonScore, int dailyPR) {
			ContentValues updateVals = createContentValues(date,dayScore,seasonScore,dailyPR);

			return database.update(DATABASE_TABLE, updateVals, KEY_ROWID + "=" + id, null) > 0;
		}	
		
		public long fetchItemIdByDate(String date) {
			Cursor dbCursor;
			long id = 0;
			
			try {
				dbCursor = database.query(true, DATABASE_TABLE, new String[]{KEY_ROWID}, KEY_DATE + "=" + date + "'", null,null,null,null,null);
				dbCursor.moveToFirst();
				id = dbCursor.getLong(dbCursor.getColumnIndex(KEY_ROWID));
			} catch (SQLiteException e) {
				id = -1;
			}
			
			return id;
		}
		
		public String fetchAllItems() {
			String allData = "";
			
			Cursor dbCursor;
			
			try {
				dbCursor = database.query(DATABASE_TABLE, new String[] {KEY_ROWID,KEY_DATE,KEY_DAYSCORE,KEY_SEASONSCORE,KEY_DAILYPR},null,null,null,null,null);
				
				int iRow = dbCursor.getColumnIndex(KEY_ROWID);
				int iDate = dbCursor.getColumnIndex(KEY_DATE);
				int iDayScore = dbCursor.getColumnIndex(KEY_DAYSCORE);
				int iSeasonScore = dbCursor.getColumnIndex(KEY_SEASONSCORE);	
				int iDailyPR = dbCursor.getColumnIndex(KEY_DAILYPR);
				
				for(dbCursor.moveToFirst(); !dbCursor.isAfterLast(); dbCursor.moveToNext()){
					allData = allData + " " + dbCursor.getString(iRow) + "\t" + dbCursor.getString(iDate) + "\t" + dbCursor.getString(iDayScore) + "\t" + dbCursor.getString(iSeasonScore) + "\t" + dbCursor.getString(iDailyPR) + "\n";
				}
			} catch (Exception e) {
				allData = "";
			}
		
			return allData;
		}
		
		public boolean deleteItem(long id) {
			return database.delete(DATABASE_TABLE, KEY_ROWID + "=" + id, null) > 0;
		}
		
		public ContentValues createContentValues(String date, int dayScore, 
				int seasonScore, int dailyPR) {
			
			ContentValues values = new ContentValues();
			values.put(KEY_DATE, date);
			values.put(KEY_DAYSCORE, dayScore);
			values.put(KEY_SEASONSCORE, seasonScore);
			values.put(KEY_DAILYPR, dailyPR);
			return values; 
		}
		
	}