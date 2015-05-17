package com.example.playwithcache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends Activity {
	EditText et;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		tv = (TextView) findViewById(R.id.textView1);
		et = (EditText) findViewById(R.id.editText1);
	}

	public void goToPrevious(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void internalCacheRetrieve(View v) {
		File folder = getCacheDir();
		File myFile = new File(folder, "mydata1.txt");
		String s = readData(myFile);
		if (s != null) {
			et.setText(s);
		} else {
			et.setText("no data was found");
		}

	}

	public void externalCacheRetrieve(View v) {
		File folder = getExternalCacheDir();
		File myFile = new File(folder, "mydata2.txt");
		String s = readData(myFile);
		if (s != null) {
			et.setText(s);
		} else {
			et.setText("no data was found");
		}
	}

	public void externalPrivateRetrieve(View v) {
		File folder = getExternalFilesDir("Daisy");
		File myFile = new File(folder, "mydata3.txt");
		String s = readData(myFile);
		if (s != null) {
			et.setText(s);
		} else {
			et.setText("no data was found");
		}

	}

	public void externalPublicRetrieve(View v) {
		File folder = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		File myFile = new File(folder, "mydata4.txt");
		String s = readData(myFile);
		if (s != null) {
			et.setText(s);
		} else {
			et.setText("no data was found");
		}

	}

	private String readData(File myFile) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(myFile);
			StringBuffer stringBuffer = new StringBuffer();
			// keep reading while there is something more to be read
			int read = -1;
			while ((read = fileInputStream.read()) != -1) {
				stringBuffer.append((char) read);
			}
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;

	}
}
