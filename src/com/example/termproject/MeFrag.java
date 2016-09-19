package com.example.termproject;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MeFrag extends Fragment {

	private ListView listView;

	// private ArrayAdapter<String> listAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		SimpleAdapter adapter = null;
		myDB dbhelper = null;
		View view = inflater.inflate(R.layout.frag_me, container, false);

		listView = (ListView) view.findViewById(R.id.listView1);
		// String[] arr = new String[] { "A", "B", "C", "D", "E", "F", "G" };
		// String[] arr = null;

		ArrayList<HashMap<String, String>> listData = null;

		dbhelper = new myDB(getActivity(), null, null, 0);
		SQLiteDatabase db = dbhelper.getReadableDatabase();

		String[] columns = { "_id", "TITLE", "DUE", "DATE", "LOCATION", "NEED",
				"TASK", "TYPE" };
		Cursor cursor = db
				.query("TASKS", columns, null, null, null, null, null);

		listData = new ArrayList<HashMap<String, String>>();
		Log.i("dbtag", "num= " + Integer.toString(cursor.getCount()));
		int i = 0;
		HashMap<String, String> temp = new HashMap<String, String>();

		while (cursor.moveToNext()) {
			Log.i("dbtag", "no." + Integer.toString(i));
			if (cursor.getInt(7) == 1) {
				temp.put("title", cursor.getString(1));
				temp.put("date", cursor.getString(3));
				listData.add(temp);
			}
			i++;
		}

		adapter = new SimpleAdapter(getActivity(), listData,
				R.layout.simple_adapter, new String[] { "title", "date" },
				new int[] { R.id.text_title, R.id.text_date });
		listView.setAdapter(adapter);
		cursor.close();
		return view;
	}
}
