package com.example.alertdialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MyAlert extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("This is the title");

		// ============================================================
		// check box style
		builder.setMultiChoiceItems(R.array.planets_array, null,
				new DialogInterface.OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						Toast.makeText(getActivity(),
								"item " + which + "is selected",
								Toast.LENGTH_SHORT).show();

					}
				});
		// ============================================================
		// select one item at a time
		// builder.setItems(R.array.planets_array,
		// new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// Toast.makeText(getActivity(),
		// "item " + which + "is selected",
		// Toast.LENGTH_SHORT).show();
		//
		// }
		// });
		// ============================================================
		// setMessage and setitem cannot co-exist.
		// builder.setMessage("This is the message");
		builder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getActivity(), "cancel is clicked",
								Toast.LENGTH_SHORT).show();

					}

				});
		builder.setPositiveButton("Submit",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getActivity(), "submit is clicked",
								Toast.LENGTH_SHORT).show();

					}

				});
		Dialog dialog = builder.create();
		return dialog;
	}
}
