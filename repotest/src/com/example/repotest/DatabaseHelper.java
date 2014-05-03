	package com.example.repotest;

	import android.content.Context;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteOpenHelper;
	
	public class DatabaseHelper extends SQLiteOpenHelper{
		
		private static final String DATABASE_NAME = "scoreInventorydb"; // name of db
		private static final int DATABASE_VERSION = 1; // version of db
		
		// SQL Create statement for making userScores table
		private static final String DATABASE_CREATE = "CREATE TABLE inventory (" +
				"_id integer PRIMARY KEY AUTOINCREMENT," + 
				"date text NOT NULL,"+
				"dayScore integer NOT NULL,"+
				"seasonScore integer NOT NULL,"+
				"dailyPR integer NOT NULL"+
				");";
		
		public DatabaseHelper(Context context){
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS inventory");
			onCreate(db);
		}
		
	}
	
	
	