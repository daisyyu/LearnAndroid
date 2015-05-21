package com.example.sharedapp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//https://www.youtube.com/watch?v=IcIFJ5V3Ibg&index=1&list=PLonJJ3BVjZW6hmkEaYIvLLm5IEGM0kpwU
//https://www.youtube.com/watch?v=4u-xpB1RFfs&index=2&list=PLonJJ3BVjZW6hmkEaYIvLLm5IEGM0kpwU
//https://www.youtube.com/watch?v=7WqMHehWI98&index=3&list=PLonJJ3BVjZW6hmkEaYIvLLm5IEGM0kpwU

public class MainActivity extends Activity {
	EditText messageBox;
	TextView status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		messageBox = (EditText) findViewById(R.id.editText1);
		status = (TextView) findViewById(R.id.textView2);
	}

	public void saveFile(View v) {
		File file = null;
		String text1 = messageBox.getText().toString();
		FileOutputStream fileOutputStream = null;
		file = getFilesDir();
		try {
			fileOutputStream = openFileOutput("Daisy.txt", Context.MODE_PRIVATE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOutputStream.write(text1.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status.setTextColor(Color.GREEN);
		status.setText(text1 + " \nwrittento\n " + file.getAbsolutePath());
	}
}
