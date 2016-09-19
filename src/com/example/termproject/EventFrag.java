package com.example.termproject;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Intent;
import android.net.Uri;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class EventFrag extends Fragment {

	private ListView listView;
	ArrayList<String> news;
	private String[] text, web, date;
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	SimpleAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_newnew);
		Information in = new Information();

		try {
			news = in.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		text = news.get(0).split("\t");
		web = news.get(1).split("\t");
		date = news.get(2).split("\t");
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_event, container, false);

		listView = (ListView) view.findViewById(R.id.listView);

		for (int i = 0; i < 10; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("t", text[i]);
			item.put("d", date[i]);
			list.add(item);
		}
		adapter = new SimpleAdapter(getActivity(), list,
				android.R.layout.simple_list_item_2, new String[] { "t", "d" },
				new int[] { android.R.id.text1, android.R.id.text2 });

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				OpenBrowser(position);
			}
		});

		return view;
	}

	private void OpenBrowser(int position) {
		// open corresponding website by browser
		Uri uri = Uri.parse(web[position]);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
}
