package com.example.termproject;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class VolunteerFrag extends Fragment {
	private ListView listView;
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	SimpleAdapter adapter;
	private myDB dbhelper = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_vol, container, false);
		listView = (ListView) view.findViewById(R.id.listView1);
		dbhelper = new myDB(getActivity(), null, null, 0);

		final String[] arr = new String[] { getString(R.string.vol0),
				getString(R.string.vol1), getString(R.string.vol2),
				getString(R.string.vol3) };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, arr);

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					showAlertDialog(0, arr[0]);
					break;
				case 1:
					showAlertDialog(1, arr[1]);
					break;
				case 2:
					showAlertDialog(2, arr[2]);
					break;
				case 3:
					showAlertDialog(3, arr[3]);
					break;
				}
			}
		});
		return view;
	}

	public void showAlertDialog(final int pos, String str) {
		AlertDialog alert = null;
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setTitle(str);

		switch (pos) {
		case 0:
			builder.setMessage(getString(R.string.msg0));
			break;
		case 1:
			builder.setMessage(getString(R.string.msg1));
			break;
		case 2:
			builder.setMessage(getString(R.string.msg2));
			break;
		case 3:
			builder.setMessage(getString(R.string.msg3));
			break;
		}
		dbhelper = new myDB(getActivity(), null, null, 0);

		builder.setPositiveButton("我要報名",
				new DialogInterface.OnClickListener() {
					SQLiteDatabase db = dbhelper.getWritableDatabase();
					final ContentValues values = new ContentValues();

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						values.put("TYPE", 1);
						// Fragment me =
						// VolunteerFrag.this.getFragmentManager().findFragmentByTag("meFrag");
						switch (pos) {
						case 0:
							db.update("TASKS", values, "TITLE = ?",
									new String[] { getString(R.string.vol0) });
							break;
						case 1:
							db.update("TASKS", values, "TITLE = ?",
									new String[] { getString(R.string.vol1) });
							break;
						case 2:
							db.update("TASKS", values, "TITLE = ?",
									new String[] { getString(R.string.vol2) });
							break;
						case 3:
							db.update("TASKS", values, "TITLE = ?",
									new String[] { getString(R.string.vol3) });
							break;
						}
					}
				});
		builder.setNegativeButton("下次再說",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});

		alert = builder.create();
		alert.show();
	}
}
