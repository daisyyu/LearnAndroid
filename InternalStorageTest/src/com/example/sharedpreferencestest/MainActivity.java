package com.example.sharedpreferencestest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	// https://www.youtube.com/watch?v=Jswr6tkv8ro&index=4&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT
	// https://www.youtube.com/watch?v=cGxHphBjTBk&index=5&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT
	// https://www.youtube.com/watch?v=mMcrj_To18k&index=6&list=PLonJJ3BVjZW5JdoFT0Rlt3ry5Mjp7s8cT
	final static String FILE_NAME = "Mydata";
	FileOutputStream outputStream;
	EditText userName;
	EditText password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		userName = (EditText) findViewById(R.id.ed_userName);
		password = (EditText) findViewById(R.id.ed_password);
	}

	public void save(View v) {
		String out = userName.getText().toString() + " "
				+ password.getText().toString();
		try {
			File file = getFilesDir();
			outputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
			outputStream.write(out.getBytes());
			Toast.makeText(this, "Data was saved successfully in  "+file,
					Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "Problems with file output",
					Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(this, "Problems with file writing",
					Toast.LENGTH_SHORT).show();
		}
		// When exception happens, we still want to be able to close the stream.
		// To forbid flowing water from wasting
		finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				Toast.makeText(this, "Problems with file stream closing",
						Toast.LENGTH_SHORT).show();
			}
		}

	}

	public void goToB(View v) {
		Toast.makeText(this, "Go To Next Activity", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, ActivityB.class);
		startActivity(intent);
	}
}
