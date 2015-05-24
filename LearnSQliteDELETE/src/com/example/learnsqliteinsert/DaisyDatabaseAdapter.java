package com.example.learnsqliteinsert;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// The reason for wrapping the helper around the outter class is for encapsulation so that other people cannot even see the helper class along with it's database constants
public class DaisyDatabaseAdapter {
	private DaisyHelper helper;

	public DaisyDatabaseAdapter(Context context) {
		this.helper = new DaisyHelper(context);
	}

	public int updateName(String newName) {
		// update DAISYTABLE, SET name = "Daisy" where Name = 'test'
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(DaisyHelper.NAME, newName);
		// hard code to test
		String[] whereArgs = { "test" };
		int count = db.update(DaisyHelper.TABLE_NAME, contentValues,
				DaisyHelper.NAME + " =? ", whereArgs);
		return count;

	}

	public int deleteRow() {
		// DELETE * From DAISYTABLE where name = "Daisy";
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] whereArgs = { "Daisy" };
		int count = db.delete(DaisyHelper.TABLE_NAME,
				DaisyHelper.NAME + " =? ", whereArgs);
		return count;

	}

	public long insertData(String name, String password) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contextValues = new ContentValues();
		contextValues.put(DaisyHelper.NAME, name);
		contextValues.put(DaisyHelper.PASSWORD, password);
		// negative id means error. else it should return the column being
		// inserted into
		return db.insert(DaisyHelper.TABLE_NAME, null, contextValues);
	}

	public String[] getData(String name, String password) {
		// select name,password from daisytable where name = 'daisy';
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] columns = { DaisyHelper.UID };
		String[] selectionArgs = { name, password };
		Cursor cursor = db.query(DaisyHelper.TABLE_NAME, columns,
				DaisyHelper.NAME + " =? AND " + DaisyHelper.PASSWORD + " =?",
				selectionArgs, null, null, null);
		ArrayList<String> list = new ArrayList<String>();
		while (cursor.moveToNext()) {
			// the index may change when you shuffle the schema of table
			int index1 = cursor.getColumnIndex(DaisyHelper.UID);
			int uid = cursor.getInt(index1);
			list.add(uid+"");
		}
		return list.toArray(new String[list.size()]);

	}

	public String[] getData(String name) {
		// select name,password from daisytable where name = 'daisy';
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] columns = { DaisyHelper.NAME, DaisyHelper.PASSWORD };
		Cursor cursor = db.query(DaisyHelper.TABLE_NAME, columns,
				DaisyHelper.NAME + " = '" + name + "'", null, null, null, null);
		ArrayList<String> list = new ArrayList<String>();
		while (cursor.moveToNext()) {
			// the index may change when you shuffle the schema of table
			int index1 = cursor.getColumnIndex(DaisyHelper.NAME);
			int index2 = cursor.getColumnIndex(DaisyHelper.PASSWORD);
			String password = cursor.getString(index2);
			String personname = cursor.getString(index1);
			list.add(personname + " " + password);
		}
		return list.toArray(new String[list.size()]);

	}

	public int deleteEmpty() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] whereArgs = { "", "" };
		int count = db.delete(DaisyHelper.TABLE_NAME, DaisyHelper.NAME
				+ " =? AND " + DaisyHelper.PASSWORD + " =? ", whereArgs);
		return count;
	}

	public String[] getAllData() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] columns = { DaisyHelper.UID, DaisyHelper.NAME,
				DaisyHelper.PASSWORD };
		Cursor cursor = db.query(DaisyHelper.TABLE_NAME, columns, null, null,
				null, null, null);
		ArrayList<String> list = new ArrayList<String>();
		while (cursor.moveToNext()) {
			// the index may change when you shuffle the schema of table
			int index1 = cursor.getColumnIndex(DaisyHelper.UID);
			int cid = cursor.getInt(index1);
			String password = cursor.getString(2);
			String name = cursor.getString(1);
			list.add(cid + " " + name + " " + password);
		}
		return list.toArray(new String[list.size()]);
	}

	// we can put it static innner class or non static inner class
	// static inner class cannot access none static outter class variales, more
	// secure
	private static class DaisyHelper extends SQLiteOpenHelper {
		// when we change database_version, it can only go up. When change it
		// back
		// down, this will result in a fatal
		private static final int DATABASE_VERSION = 1;
		private static final String DATABASE_NAME = "daisydatabase";
		private static final String TABLE_NAME = "DAISY_TABLE";
		private static final String UID = "_id";
		private static final String NAME = "Name";
		private static final String PASSWORD = "Password";
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME
				+ " VARCHAR(255), " + PASSWORD + " VARCHAR(255));";
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS "
				+ TABLE_NAME;
		private Context context;

		public DaisyHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
			// Message.message(context, "constructor is called");
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(CREATE_TABLE);
			} catch (Exception e) {
				Message.message(context, "" + e);
			}
			// Message.message(context, "onCreate is called");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// if we need onUpgrade to be executed, we need to update the db
			// version
			// It is possible to have an upgraded dbVersion with the same table
			// schema
			try {
				db.execSQL(DROP_TABLE);
				onCreate(db);
			} catch (SQLException e) {
				Message.message(context, "" + e);
			}
			// Message.message(context, "onUpgrade is called");
		}

	}

}