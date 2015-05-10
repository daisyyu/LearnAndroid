package com.example.sharedpreferencestest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
SharedPreferences sp;
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
		sp = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=sp.edit();
		editor.putString("name", userName.getText().toString());
		editor.putString("password", password.getText().toString());
		editor.commit();
		
		Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();
		
	}

	public void goToB(View v) {
		Toast.makeText(this, "Go To Next Activity", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, ActivityB.class);
		startActivity(intent);
	}
}
