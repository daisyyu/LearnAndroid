package com.example.sharedapp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText messageFromApp1;
	TextView status;
	private static String packageName = "com.example.sharedapp1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		messageFromApp1 = (EditText) findViewById(R.id.editText1);
		status = (TextView) findViewById(R.id.textView1);
	}

	public void load(View v) {
		PackageManager packageManager = getPackageManager();
		// PackageManager.GET_META_DATA means everything
		try {
			ApplicationInfo applicationInfo = packageManager
					.getApplicationInfo(packageName,
							PackageManager.GET_META_DATA);
			String fullPath = applicationInfo.dataDir + "/files/Daisy.txt";
			readFile(fullPath);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// in case that the package dosn't esist or that both app don't
			// share the same appUserID
			status.setTextColor(Color.RED);
			status.setText(e + "");
		}
	}

	public void readFile(String fullPath) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(fullPath));
			int read = -1;
			StringBuffer buffer = new StringBuffer();
			while ((read = fileInputStream.read()) != -1) {
				buffer.append((char) read);
			}
			messageFromApp1.setText(buffer);
			status.setTextColor(Color.GREEN);
			status.setText(buffer + " \n was read successfully from\n "
					+ fullPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
