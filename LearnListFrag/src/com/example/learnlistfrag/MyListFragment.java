package com.example.learnlistfrag;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyListFragment extends ListFragment {
	static final String TAG ="MyListFragment";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG,"onCreatView is Called");
		return inflater.inflate(R.layout.my_list_fragment, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG,"onActivityCreated is Called");
		super.onActivityCreated(savedInstanceState);
	}   
}
