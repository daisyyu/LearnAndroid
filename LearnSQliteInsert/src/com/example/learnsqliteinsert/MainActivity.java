package com.example.learnsqliteinsert;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// https://www.youtube.com/watch?v=-7yDXaW6C9U&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT&index=15
// https://www.youtube.com/watch?v=0JNP7El2kHs&index=15&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT

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
}
