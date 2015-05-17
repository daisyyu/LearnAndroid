package com.example.playwithcache;

import android.content.Context;
import android.widget.Toast;

public class Helper {
	private final Context context;

	public Helper(Context context) {
		this.context = context;
	}

	public void message(String data) {
		Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
	}

}
