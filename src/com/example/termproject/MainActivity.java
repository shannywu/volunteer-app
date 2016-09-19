package com.example.termproject;

import java.lang.reflect.Method;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.Window;

public class MainActivity extends Activity {

	private static final String TAG = "tabTag";
	private myDB dbhelper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		insertDB();
		
		ActionBar bar = this.getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab volTab, eventTab, knowTab, meTab;
		volTab = bar.newTab().setText(R.string.vol)
				.setTabListener(myTabListener);
		eventTab = bar.newTab().setText(R.string.event)
				.setTabListener(myTabListener);
		knowTab = bar.newTab().setText(R.string.know)
				.setTabListener(myTabListener);
		meTab = bar.newTab().setText(R.string.me).setTabListener(myTabListener);

		bar.addTab(meTab);
		bar.addTab(volTab);
		bar.addTab(eventTab);
		bar.addTab(knowTab);
		
		
		
	}

	private TabListener myTabListener = new TabListener() {

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			Log.d(TAG, tab.getText() + " is onTabUnselected");
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			Fragment fragment;
			if (tab.getText() == getString(R.string.me))
				fragment = new MeFrag();
			else if(tab.getText() == getString(R.string.vol))
				fragment = new VolunteerFrag();
			else if (tab.getText() == getString(R.string.event))
				fragment = new EventFrag();
			else
				fragment = new KnowFrag();

			ft.replace(R.id.layout_fragment, fragment);
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			Log.d(TAG, tab.getText() + " is onTabReselected");
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		/*
		 * MenuInflater inflater = getMenuInflater();
		 * inflater.inflate(R.menu.main, menu); return true;
		 */
		SubMenu submenu = menu.addSubMenu("");
		submenu.setIcon(R.drawable.settings);

		submenu.add(1, 0, 1, "編輯");
		submenu.add(1, 1, 2, "登出");
		submenu.getItem().setShowAsAction(
				MenuItem.SHOW_AS_ACTION_ALWAYS
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String myMenuitem = null;
		switch (item.getItemId()) {
		case 0:
			myMenuitem = "Menu 1";
			break;
		case 1:
			myMenuitem = "Sub Menu 1 1";
			break;
		}

		return true;
	}

	public void insertDB() {
		dbhelper = new myDB(this, null, null, 0);
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		ContentValues values = new ContentValues();

		String[] title = { getString(R.string.vol0), getString(R.string.vol1),
				getString(R.string.vol2), getString(R.string.vol3) };
		String[] due = { getString(R.string.due0), getString(R.string.due1),
				getString(R.string.due2), getString(R.string.due3) };
		String[] date = { getString(R.string.date0), getString(R.string.date1),
				getString(R.string.date2), getString(R.string.date3) };
		String[] location = { getString(R.string.loc0),
				getString(R.string.loc1), getString(R.string.loc2),
				getString(R.string.loc3) };
		Integer[] need = { 2, 3, 5, 8 };
		String[] task = { getString(R.string.task0), getString(R.string.task1),
				getString(R.string.task2), getString(R.string.task3) };

		for (int i = 0; i < 4; i++) {
			values.put("TITLE", title[i]);
			values.put("DUE", due[i]);
			values.put("DATE", date[i]);
			values.put("LOCATION", location[i]);
			values.put("NEED", need[i]);
			values.put("TASK", task[i]);
			values.put("TYPE", 0);
			
			db.insert("TASKS", null, values);
		}
	}
}
