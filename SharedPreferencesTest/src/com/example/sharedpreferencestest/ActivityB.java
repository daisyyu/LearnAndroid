package com.example.sharedpreferencestest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityB extends Activity {
	EditText et_name;
	EditText et_password;
	public static final String DEFAULT = "N/A";
	SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		et_password = (EditText) findViewById(R.id.et_password);
		et_name = (EditText) findViewById(R.id.et_username);
	}

	public void previous(View v) {
		Toast.makeText(this, "Go To Previous Activity", Toast.LENGTH_SHORT)
				.show();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void load(View v) {
		sp = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
		// The 2nd parameter is the default value, incase that you did not set
		// the pair in the first time or there is problem with loading
		String name = sp.getString("name", DEFAULT);
		String password = sp.getString("password", DEFAULT);
		if (name.equals(DEFAULT) || password.equals(DEFAULT)) {
			Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT)
					.show();
			et_name.setText(name);
			et_password.setText(password);
			// when app data is cleared, sharedPreferences xml file will be
			// deleted
			// when app is uninstalled, the folder under data/ associated with
			// this app will be gone.

		}

	}

}
