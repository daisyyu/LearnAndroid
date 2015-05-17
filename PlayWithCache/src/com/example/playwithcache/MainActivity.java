package com.example.playwithcache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et;
	static private String TAG = "Daisy";
	Helper helper = new Helper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText1);
	}

	public void goToNext(View v) {
		Intent intent = new Intent(this, ActivityB.class);
		startActivity(intent);
	}

	public void internalCacheInsert(View v) {
		String data = et.getText().toString();
		File folder = getCacheDir();
		File myFile = new File(folder, "mydata1.txt");
		writeData(myFile, data);
	}

	public void externalCacheInsert(View v) {
		String data = et.getText().toString();
		File folder = getExternalCacheDir();
		File myFile = new File(folder, "mydata2.txt");
		writeData(myFile, data);
	}

	public void externalPrivateInsert(View v) {
		String data = et.getText().toString();
		// Daisy will be created as a folder under data dir
		File folder = getExternalFilesDir("Daisy");
		File myFile = new File(folder, "mydata3.txt");
		writeData(myFile, data);
	}

	public void externalPublicInsert(View v) {
		// Need to add permission <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// to manifest or will throw a file not found exception
		String data = et.getText().toString();
		// mydata4 will be created under download directory. It is accessable by
		// user
		File folder = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		File myFile = new File(folder, "mydata4.txt");
		writeData(myFile, data);
	}

	/**
	 * By using this method, we created a general function that handles writing
	 * data to myFile
	 * 
	 * @param myFile
	 *            (could be external cache, private cache, public external
	 *            storage, or private external storage
	 * @param data
	 */
	private void writeData(File myFile, String data) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(myFile);
			fileOutputStream.write(data.getBytes());
			helper.message(data + " was written sucesffuly "
					+ myFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Log.d(TAG,"FileNotFoundException: "+e.getMessage());
		} catch (IOException e) {
			Log.d(TAG,"IOException: "+e.getMessage());
		} finally {
			if (fileOutputStream != null)
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					Log.d(TAG,"IOException on closing fileStream: "+e.getMessage());
				}
		}
	}
}
