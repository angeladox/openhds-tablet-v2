package org.openhds.mobile.activity;

import org.openhds.mobile.R;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
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
		setTitle(getString(R.string.app_name) + " > " + getString(R.string.configureHierarchies));
		EditTextPreference numHierarchies = (EditTextPreference) this.getPreferenceScreen().findPreference(NUM_HIERARCHIES);
		updateNumHierarchiesText(numHierarchies);
		if (getNumHierarchies() == 1)
			updateHierarchy(HIERARCHY_1);
		if (getNumHierarchies() == 2) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
		}
		if (getNumHierarchies() == 3) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
		}
		if (getNumHierarchies() == 4) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
			updateHierarchy(HIERARCHY_4);
		}
		if (getNumHierarchies() == 5) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
			updateHierarchy(HIERARCHY_4);
			updateHierarchy(HIERARCHY_5);
		}
		if (getNumHierarchies() == 6) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
			updateHierarchy(HIERARCHY_4);
			updateHierarchy(HIERARCHY_5);
			updateHierarchy(HIERARCHY_6);
		}
		if (getNumHierarchies() == 7) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
			updateHierarchy(HIERARCHY_4);
			updateHierarchy(HIERARCHY_5);
			updateHierarchy(HIERARCHY_6);
			updateHierarchy(HIERARCHY_7);
		}
		if (getNumHierarchies() == 8) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
			updateHierarchy(HIERARCHY_4);
			updateHierarchy(HIERARCHY_5);
			updateHierarchy(HIERARCHY_6);
			updateHierarchy(HIERARCHY_7);
			updateHierarchy(HIERARCHY_8);
		}
		if (getNumHierarchies() == 9) {
			updateHierarchy(HIERARCHY_1);
			updateHierarchy(HIERARCHY_2);
			updateHierarchy(HIERARCHY_3);
			updateHierarchy(HIERARCHY_4);
			updateHierarchy(HIERARCHY_5);
			updateHierarchy(HIERARCHY_6);
			updateHierarchy(HIERARCHY_7);
			updateHierarchy(HIERARCHY_8);
			updateHierarchy(HIERARCHY_9);
		}
	}

	private void updateNumHierarchiesText(EditTextPreference etp) {
		String s = etp.getText().trim();
		if (!s.isEmpty()) {
			etp.setText(s);
			etp.setSummary(s);
		} else {
			etp.setText((String) etp.getSummary());
			Toast.makeText(getApplicationContext(), getString(R.string.num_hierarchy_error), Toast.LENGTH_SHORT).show();
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
