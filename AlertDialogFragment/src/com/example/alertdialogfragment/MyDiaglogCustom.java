package com.example.alertdialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MyDiaglogCustom extends DialogFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, null);
	}

	// @Override
	// public Dialog onCreateDialog(Bundle savedInstanceState) {
	// AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	//
	// // display custom view
	// LayoutInflater inflator = getActivity().getLayoutInflater();
	// View v = inflator.inflate(R.layout.fragment_main, null);
	// builder.setView(v);
	//
	// builder.setNegativeButton("Cancel",
	// new DialogInterface.OnClickListener() {
	//
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// Toast.makeText(getActivity(), "cancel is clicked",
	// Toast.LENGTH_SHORT).show();
	//
	// }
	//
	// });
	// builder.setPositiveButton("Submit",
	// new DialogInterface.OnClickListener() {
	//
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// Toast.makeText(getActivity(), "submit is clicked",
	// Toast.LENGTH_SHORT).show();
	//
	// }
	//
	// });
	//
	// Dialog dialog = builder.create();
	//
	// return dialog;
	// }

}
