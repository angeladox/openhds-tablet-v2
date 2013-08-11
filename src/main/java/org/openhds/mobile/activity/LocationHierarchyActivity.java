package org.openhds.mobile.activity;

import org.openhds.mobile.R;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.widget.Toast;

public class LocationHierarchyActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	public static String NUM_HIERARCHIES = "numHierarchies";
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.location_hierarchies);
		setPreferencesInvisible(1);
		setTitle(getString(R.string.app_name) + " > " + getString(R.string.configureHierarchies));
		EditTextPreference numHierarchies = (EditTextPreference) this.getPreferenceScreen().findPreference(NUM_HIERARCHIES);
		updateNumHierarchiesText(numHierarchies);
	}
	
	/*@Override
	protected void onResume() {
		super.onResume();
		EditTextPreference numHierarchies = (EditTextPreference) this.getPreferenceScreen().findPreference(NUM_HIERARCHIES);
		updateNumHierarchiesText(numHierarchies);
	}*/
	
	private void setPreferencesInvisible(int num){
		PreferenceScreen screen = getPreferenceScreen();
		Preference hierarchy;
		switch (num) {
		case 1:
			hierarchy = findPreference(HIERARCHY_1);
			screen.removePreference(hierarchy);
		case 2:			
			hierarchy = findPreference(HIERARCHY_2);
			screen.removePreference(hierarchy);
		case 3:			
			hierarchy = findPreference(HIERARCHY_3);
			screen.removePreference(hierarchy);
		case 4:			
			hierarchy = findPreference(HIERARCHY_4);
			screen.removePreference(hierarchy);
		case 5:			
			hierarchy = findPreference(HIERARCHY_5);
			screen.removePreference(hierarchy);
		case 6:			
			hierarchy = findPreference(HIERARCHY_6);
			screen.removePreference(hierarchy);
		case 7:			
			hierarchy = findPreference(HIERARCHY_7);
			screen.removePreference(hierarchy);
		case 8:
			hierarchy = findPreference(HIERARCHY_8);
			screen.removePreference(hierarchy);
		case 9:			
			hierarchy = findPreference(HIERARCHY_9);
			screen.removePreference(hierarchy);
		}		
	}
	
	private void setPreferencesVisible(int num){
		PreferenceScreen screen = getPreferenceScreen();
		Preference hierarchy;
		switch (num) {
		case 9:
			hierarchy = findPreference(HIERARCHY_9);
			screen.addPreference(hierarchy);
		case 8:			
			hierarchy = findPreference(HIERARCHY_8);
			screen.addPreference(hierarchy);
		case 7:			
			hierarchy = findPreference(HIERARCHY_7);
			screen.addPreference(hierarchy);
		case 6:			
			hierarchy = findPreference(HIERARCHY_6);
			screen.addPreference(hierarchy);
		case 5:			
			hierarchy = findPreference(HIERARCHY_5);
			screen.addPreference(hierarchy);
		case 4:			
			hierarchy = findPreference(HIERARCHY_4);
			screen.addPreference(hierarchy);
		case 3:			
			hierarchy = findPreference(HIERARCHY_3);
			screen.addPreference(hierarchy);
		case 2:
			hierarchy = findPreference(HIERARCHY_2);
			screen.addPreference(hierarchy);
		case 1:			
			hierarchy = findPreference(HIERARCHY_1);
			screen.addPreference(hierarchy);
		}		
	}
	
	private void updateNumHierarchiesText(EditTextPreference etp) {
		String s = etp.getText().trim();
		if (!s.isEmpty()) {
			etp.setText(s);
			etp.setSummary(s);
			//if ()
			//setHierarchyListings();
		} else {
			etp.setText((String) etp.getSummary());
			Toast.makeText(getApplicationContext(), getString(R.string.num_hierarchy_error), Toast.LENGTH_SHORT).show();
		}
	}
	
	private void setHierarchyListings(){		
		if (getNumHierarchies() == 1)
			setPreferencesVisible(1);
		if (getNumHierarchies() == 2) {
			setPreferencesVisible(2);
		}
		if (getNumHierarchies() == 3) {
			setPreferencesVisible(3);
		}
		if (getNumHierarchies() == 4) {
			setPreferencesVisible(4);
		}
		if (getNumHierarchies() == 5) {
			setPreferencesInvisible(5);
		}
		if (getNumHierarchies() == 6) {
			setPreferencesVisible(6);
		}
		if (getNumHierarchies() == 7) {
			setPreferencesVisible(7);
		}
		if (getNumHierarchies() == 8) {
			setPreferencesVisible(8);
		}
		if (getNumHierarchies() == 9) {
			setPreferencesVisible(9);
		}
	}

	private void updateHierarchy(String hierarchy) {
		EditTextPreference etp = (EditTextPreference) this.getPreferenceScreen().findPreference(hierarchy);
		String s = etp.getText().trim();
		if (!s.isEmpty()) {
			etp.setText(s);
			etp.setSummary(s);
		} else {
			etp.setText((String) etp.getSummary());
			Toast.makeText(getApplicationContext(), getString(R.string.hierarchy_error), Toast.LENGTH_SHORT).show();
		}
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		if (key.equals(HIERARCHY_1)) {
			updateHierarchy(HIERARCHY_1);

		} else if (key.equals(HIERARCHY_2))
			updateHierarchy(HIERARCHY_2);
		else if (key.equals(HIERARCHY_3))
			updateHierarchy(HIERARCHY_3);
		else if (key.equals(HIERARCHY_4))
			updateHierarchy(HIERARCHY_4);
		else if (key.equals(HIERARCHY_5))
			updateHierarchy(HIERARCHY_5);
		else if (key.equals(HIERARCHY_6))
			updateHierarchy(HIERARCHY_6);
		else if (key.equals(HIERARCHY_7))
			updateHierarchy(HIERARCHY_7);
		else if (key.equals(HIERARCHY_8))
			updateHierarchy(HIERARCHY_8);
		else if (key.equals(HIERARCHY_9))
			updateHierarchy(HIERARCHY_9);
	}

	private int getNumHierarchies() {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
		String numHierarchies = sp.getString(LocationHierarchyActivity.NUM_HIERARCHIES, getString(R.id.numHierarchies));
		return Integer.parseInt(numHierarchies);
	}
}
