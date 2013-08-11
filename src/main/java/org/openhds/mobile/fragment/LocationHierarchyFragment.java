package org.openhds.mobile.fragment;

import android.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class LocationHierarchyFragment extends PreferenceFragment implements OnClickListener {

	public static String HIERARCHY_1 = "hierarchy1";
	public static String HIERARCHY_2 = "hierarchy2";
	public static String HIERARCHY_3 = "hierarchy3";
	public static String HIERARCHY_4 = "hierarchy4";
	public static String HIERARCHY_5 = "hierarchy5";
	public static String HIERARCHY_6 = "hierarchy6";
	public static String HIERARCHY_7 = "hierarchy7";
	public static String HIERARCHY_8 = "hierarchy8";
	public static String HIERARCHY_9 = "hierarchy9";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getBaseContext());
		addPreferencesFromResource(R.layout.location_hierarchies);
		View view = inflater.inflate(R.layout.location_hierarchies, container, false);

		return view;
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.HIERARCHY_1:
		}
	}
}
