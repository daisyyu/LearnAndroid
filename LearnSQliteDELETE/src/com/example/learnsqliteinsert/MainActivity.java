package com.example.learnsqliteinsert;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// https://www.youtube.com/watch?v=pzrcC97rjKI&index=20&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT
// https://www.youtube.com/watch?v=HioR0tIfuY8&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT&index=20

/*
 * This is the aggregated application for Android SQLite DB
 */

public class MainActivity extends Activity {
	EditText userName, password;
	DaisyDatabaseAdapter helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		userName = (EditText) findViewById(R.id.user_name);
		password = (EditText) findViewById(R.id.password);
		helper = new DaisyDatabaseAdapter(this);
	}

	private void displayUsingListFragment(String[] data, String TAG) {
		FragmentManager manager = getFragmentManager();
		// clean up the backstack to make it clean
		manager.popBackStack();
		FragmentTransaction ft = manager.beginTransaction();
		MyListFragment listFragment = new MyListFragment(data);
		ft.replace(R.id.group, listFragment, "LIST");
		// adding to backstack so I can click on back button to go back to
		// previous state
		ft.addToBackStack("MyFragmentList Screen");
		// Trasaction commit, just like DB
		ft.commit();
	}

	public void addUser(View v) {
		String user = userName.getText().toString();
		String pass = password.getText().toString();

		long id = helper.insertData(user, pass);
		if (id < 0) {
			Message.message(this, "Some thing is wrong with inserting");
		} else {
			Message.message(this, "Succesfully inserted a row");
		}
		viewAllDetails(findViewById(R.id.button2));
	}

	public void viewWithConditionUser(View v) {
		// get name and pass with name as condition
		String[] data = helper.getData(userName.getText().toString());
		displayUsingListFragment(data, "viewWithConditionUser");

		viewAllDetails(findViewById(R.id.button2));
	}

	public void viewWithConditionUserAndPass(View v) {
		// get uid with {name,pass} as combined condition
		String[] data = helper.getData(userName.getText().toString(), password
				.getText().toString());
		displayUsingListFragment(data, "viewWithConditionUserAndPass");
		viewAllDetails(findViewById(R.id.button2));

	}

	public void viewAllDetails(View v) {
		// get all data
		String[] data = helper.getAllData();
		displayUsingListFragment(data, "viewAllDetails");

	}

	public void cleanUp(View v) {
		Message.message(this, "clean up status: " + helper.deleteEmpty());
		viewAllDetails(findViewById(R.id.button2));
	}

	public void update(View v) {
		Message.message(this, "Updating status: " + helper.updateName("Daisy"));
		viewAllDetails(findViewById(R.id.button2));
	}

	public void delete(View v) {
		Message.message(this, "deleting stataus: " + helper.deleteRow());
		viewAllDetails(findViewById(R.id.button2));
	}
}