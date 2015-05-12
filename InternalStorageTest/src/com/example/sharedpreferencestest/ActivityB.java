package com.example.sharedpreferencestest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
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
		// What you see when you open this file?
		// vivz 123
		// what is actuall contained in the file? <strings>
		// 118 105 118 122 32 50 51 <byte>
		// if file is complete empty, file.read will return -1
		// keep reading stuff while it dosn't return -1
		try {
			FileInputStream inputStream = openFileInput(MainActivity.FILE_NAME);
			int read = -1;
			StringBuffer buffer = new StringBuffer();
			while ((read = inputStream.read()) != -1) {
				// read will read in 118 at the first time, when we type cast
				// int to char, 118 becomes v
				buffer.append((char) read);
			}
			// spit username and password
			String text1 = buffer.substring(0, buffer.indexOf(" ", 0));
			String text2 = buffer.substring(buffer.indexOf(" ") + 1);
			et_password.setText(text2);
			et_name.setText(text1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
