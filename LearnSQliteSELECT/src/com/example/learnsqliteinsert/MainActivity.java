package com.example.learnsqliteinsert;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// https://www.youtube.com/watch?v=Npc8gQMiXiI&index=17&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT
// https://www.youtube.com/watch?v=aOpUmtmG0o0&index=18&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT
// https://www.youtube.com/watch?v=MDdkdsG-Yww&index=19&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT

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

	public void addUser(View v) {
		String user = userName.getText().toString();
		String pass = password.getText().toString();

		long id = helper.insertData(user, pass);
		if (id < 0) {
			Message.message(this, "Some thing is wrong with inserting");
		} else {
			Message.message(this, "Succesfully inserted a row");
		}
	}

	public void viewWithConditionUser(View v) {
		// get name and pass with name as condition
		String data = helper.getData(userName.getText().toString());
		Message.message(this, data);

	}

	public void viewWithConditionUserAndPass(View v) {
		// get uid with {name,pass} as combined condition
		String data = helper.getData(userName.getText().toString(), password
				.getText().toString());
		Message.message(this, data);

	}

	public void viewAllDetails(View v) {
		// get all data
		String data = helper.getAllData();
		Message.message(this, data);

	}
}