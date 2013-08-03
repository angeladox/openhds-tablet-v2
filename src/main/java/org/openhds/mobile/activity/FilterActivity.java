package org.openhds.mobile.activity;

import android.widget.Toast;
import org.openhds.mobile.R;
import org.openhds.mobile.fragment.SelectionFilterFragment;
import org.openhds.mobile.fragment.ValueFragment;
import org.openhds.mobile.fragment.ValueFragment.ValueListener;
import org.openhds.mobile.model.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * This activity is only used in searching for an Individual. This activity is
 * launched before creating Relationship and Internal In Migration events. It's
 * also launched before creating a new Location.
 */
public class FilterActivity extends Activity implements ValueListener, SelectionFilterFragment.Listener {

    private SelectionFilterFragment selectionFilterFragment;
    private ValueFragment valueFragment;
    private String requireGender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        selectionFilterFragment = (SelectionFilterFragment) getFragmentManager().findFragmentById(
                R.id.selectionFilterFragment);
        valueFragment = (ValueFragment) getFragmentManager().findFragmentById(R.id.valueFragment);

        processExtras();
    }

    private void processExtras() {
        LocationHierarchy hierarchy1 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy1");
        LocationHierarchy hierarchy2 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy2");
        LocationHierarchy hierarchy3 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy3");
        LocationHierarchy hierarchy4 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy4");
        LocationHierarchy hierarchy5 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy5");
        LocationHierarchy hierarchy6 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy6");
        LocationHierarchy hierarchy7 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy7");
        LocationHierarchy hierarchy8 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy8");
        LocationHierarchy hierarchy9 = (LocationHierarchy) getIntent().getExtras().getSerializable("hierarchy9");
        Location location = (Location) getIntent().getExtras().getSerializable("location");
        requireGender = getIntent().getExtras().getString("requireGender");

        selectionFilterFragment.setHierarchy1(hierarchy1.getExtId());
        selectionFilterFragment.setHierarchy2(hierarchy2.getExtId());
        selectionFilterFragment.setHierarchy3(hierarchy3.getExtId());
        selectionFilterFragment.setHierarchy4(hierarchy4.getExtId());
        selectionFilterFragment.setHierarchy5(hierarchy5.getExtId());
        selectionFilterFragment.setHierarchy6(hierarchy6.getExtId());
        selectionFilterFragment.setHierarchy7(hierarchy7.getExtId());
        selectionFilterFragment.setHierarchy8(hierarchy8.getExtId());
        selectionFilterFragment.setHierarchy9(hierarchy9.getExtId());
        selectionFilterFragment.setLocation(location.getExtId());
    }

    public void onIndividualSelected(Individual individual) {
        if (requireGender != null && !requireGender.equals(individual.getGender())) {
            Toast.makeText(getApplicationContext(), "Please choose " + requireGender, Toast.LENGTH_LONG).show();
            return;
        }

        Intent i = new Intent();
        i.putExtra("individual", individual);
        setResult(Activity.RESULT_OK, i);
        finish();
    }

    public void onHierarchy1Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy1Text(hierarchy.getExtId());
    }

    public void onHierarchy2Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy2Text(hierarchy.getExtId());
    }
    
    public void onHierarchy3Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy3Text(hierarchy.getExtId());
    }

    public void onHierarchy4Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy4Text(hierarchy.getExtId());
    }
    
    public void onHierarchy5Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy5Text(hierarchy.getExtId());
    }
    
    public void onHierarchy6Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy6Text(hierarchy.getExtId());
    }
    
    public void onHierarchy7Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy7Text(hierarchy.getExtId());
    }
    
    public void onHierarchy8Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy8Text(hierarchy.getExtId());
    }
    
    public void onHierarchy9Selected(LocationHierarchy hierarchy) {
        selectionFilterFragment.updateHierarchy9Text(hierarchy.getExtId());
    }

    public void onRoundSelected(Round round) {
        // not implemented
    }

    public void onLocationSelected(Location location) {
        selectionFilterFragment.updateLocationText(location.getExtId());
    }

    public void onSeeListHierarchy1() {
        valueFragment.loadLocationHierarchy();
    }

    public void onSeeListHierarchy2(String locHierarchy) {
        valueFragment.loadHierarchy2(locHierarchy);
    }
    
    public void onSeeListHierarchy3(String locHierarchy) {
        valueFragment.loadHierarchy3(locHierarchy);
    }

    public void onSeeListHierarchy4(String locHierarchy) {
        valueFragment.loadHierarchy4(locHierarchy);
    }
    
    public void onSeeListHierarchy5(String locHierarchy) {
        valueFragment.loadHierarchy5(locHierarchy);
    }
    
    public void onSeeListHierarchy6(String locHierarchy) {
        valueFragment.loadHierarchy6(locHierarchy);
    }
    
    public void onSeeListHierarchy7(String locHierarchy) {
        valueFragment.loadHierarchy7(locHierarchy);
    }
    
    public void onSeeListHierarchy8(String locHierarchy) {
        valueFragment.loadHierarchy8(locHierarchy);
    }
    
    public void onSeeListHierarchy9(String locHierarchy) {
        valueFragment.loadHierarchy9(locHierarchy);
    }

    public void onSeeListLocation(String village) {
        valueFragment.loadLocations(village);
    }

    public void onSearch(String location, String firstName, String lastName, String gender) {
        valueFragment.loadFilteredIndividuals(location, firstName, lastName, gender);
    }

}
