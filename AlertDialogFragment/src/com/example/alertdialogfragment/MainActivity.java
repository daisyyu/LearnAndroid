package com.example.alertdialogfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showDialog(View v) {
		// MyAlert myAlert = new MyAlert();
		// myAlert.show(getFragmentManager(), "My Alert");
		MyDiaglogCustom mAlert = new MyDiaglogCustom();
		mAlert.show(getFragmentManager(), "My Alert");
	}

	public void showDialogFragment(View view) {
		// used to display dialog alert as normal fragment embedded in activity
		// Do operations just as normal fragment
		MyDiaglogCustom mAlert = new MyDiaglogCustom();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction trasaction = manager.beginTransaction();
		trasaction.add(R.id.dialog_parent, mAlert, "My Fragment Alert");
		trasaction.addToBackStack("dialog");
		trasaction.commit();

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
