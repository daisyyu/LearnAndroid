package com.example.learndatabaseschema;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
// https://www.youtube.com/watch?v=0BUljVIgnoE&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT&index=12
// https://www.youtube.com/watch?v=tsNgtAdlof8&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT&index=13
// https://www.youtube.com/watch?v=ge7m4nWmggs&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT&index=14

public class MainActivity extends Activity {
	DaisyHelper daisyHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// at this point, constructor is called
		daisyHelper = new DaisyHelper(this);
		// at this point, onCreate is called
		SQLiteDatabase sqLiteDatabase = daisyHelper.getWritableDatabase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
