package org.openhds.mobile.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openhds.mobile.Converter;
import org.openhds.mobile.OpenHDS;
import org.openhds.mobile.PreferenceContainer;
import org.openhds.mobile.Queries;
import org.openhds.mobile.R;
import org.openhds.mobile.activity.LocationHierarchyActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;

/**
 * A LocationVisit represents a single visit to a specific location. This class
 * is built incrementally, meaning first the user constructs the location
 * hierarchy selection (region, sub-region, village, and round), one item at a
 * time. Then they must either set or create a location. After a location is
 * set, they can proceed to create a visit. Once a visit is created, the
 * LocationVisit cannot be changed, that is, a visit is considered started. Only
 * new events can be added to the location visit at this point. Once the user
 * completes a visit, a new LocationVisit is returned that contains pre-filled
 * location hierarchy selection (region, sub-region, village and round) assuming
 * the field worker will work in the same area.
 */
public class LocationVisit implements Serializable {

    private static final long serialVersionUID = -36602612353821830L;
    //private Context context;
    private FieldWorker fieldWorker;
    private LocationHierarchy hierarchy1;
    private LocationHierarchy hierarchy2;
    private LocationHierarchy hierarchy3;
    private LocationHierarchy hierarchy4;
    private LocationHierarchy hierarchy5;
    private LocationHierarchy hierarchy6;
    private LocationHierarchy hierarchy7;
    private LocationHierarchy hierarchy8;
    private LocationHierarchy hierarchy9;
    private Round round;
    private int numHierarchies;

	private Location location;
    private Visit visit;

    private Individual selectedIndividual;
    
    public LocationVisit(){
    	
    }
    
  /*  public LocationVisit(Context context){
    	this.context = context;
    }*/
    
    public int getNumHierarchies() {
		return numHierarchies;
	}

	public void setNumHierarchies(int numHierarchies) {
		this.numHierarchies = numHierarchies;
	}

    public LocationVisit completeVisit(Context context) {
        LocationVisit visit = new LocationVisit();//context);
		visit.fieldWorker = fieldWorker;
        visit.hierarchy1 = hierarchy1;
        visit.hierarchy2 = hierarchy2;
        visit.hierarchy3 = hierarchy3;
        visit.hierarchy4 = hierarchy4;
        visit.hierarchy5 = hierarchy5;
        visit.hierarchy6 = hierarchy6;
        visit.hierarchy7 = hierarchy7;
        visit.hierarchy8 = hierarchy8;
        visit.hierarchy9 = hierarchy9;
        visit.round = round;

        return visit;
    }

    public FieldWorker getFieldWorker() {
        return fieldWorker;
    }

    public void setFieldWorker(FieldWorker fieldWorker) {
        this.fieldWorker = fieldWorker;
    }

    public LocationHierarchy getHierarchy1() {
        return hierarchy1;
    }

    public LocationHierarchy getHierarchy2() {
        return hierarchy2;
    }
    
    public LocationHierarchy getHierarchy3() {
        return hierarchy3;
    }

    public LocationHierarchy getHierarchy4() {
        return hierarchy4;
    }
    
    public LocationHierarchy getHierarchy5() {
        return hierarchy5;
    }
    public LocationHierarchy getHierarchy6() {
        return hierarchy6;
    }
    public LocationHierarchy getHierarchy7() {
        return hierarchy7;
    }
    public LocationHierarchy getHierarchy8() {
        return hierarchy8;
    }
    public LocationHierarchy getHierarchy9() {
        return hierarchy9;
    }

    public Round getRound() {
        return round;
    }

    public Individual getSelectedIndividual() {
        return selectedIndividual;
    }

    public void setSelectedIndividual(Individual selectedIndividual) {
        this.selectedIndividual = selectedIndividual;
    }

    public void setHierarchy1(LocationHierarchy hierarchy) {
        this.hierarchy1 = hierarchy;
        clearLevelsBelow(1);
    }

    public void setHierarchy2(LocationHierarchy hierarchy) {
        this.hierarchy2 = hierarchy;
        clearLevelsBelow(2);
    }
    
    public void setHierarchy3(LocationHierarchy hierarchy3) {
        this.hierarchy3 = hierarchy3;
        clearLevelsBelow(3);
    }

    public void setHierarchy4(LocationHierarchy hierarchy) {
        this.hierarchy4 = hierarchy;
        clearLevelsBelow(4);
    }
    
    public void setHierarchy5(LocationHierarchy hierarchy) {
        this.hierarchy5 = hierarchy;
        clearLevelsBelow(5);
    }
    
    public void setHierarchy6(LocationHierarchy hierarchy) {
        this.hierarchy6 = hierarchy;
        clearLevelsBelow(6);
    }
    
    public void setHierarchy7(LocationHierarchy hierarchy) {
        this.hierarchy7 = hierarchy;
        clearLevelsBelow(7);
    }
    
    public void setHierarchy8(LocationHierarchy hierarchy) {
        this.hierarchy8 = hierarchy;
        clearLevelsBelow(8);
    }
    
    public void setHierarchy9(LocationHierarchy hierarchy) {
        this.hierarchy9 = hierarchy;
        clearLevelsBelow(9);
    }

    public void setRound(Round round) {
        this.round = round;
        clearLevelsBelow(10);
    }


    public void clearLevelsBelow(int i) {
        switch (i) {
        case 0:
            hierarchy1 = null;
        case 1:
            hierarchy2 = null;
        case 2:
            hierarchy3 = null;
        case 3:
            hierarchy4 = null;
        case 4:
        	hierarchy5 = null;
        case 5:
        	hierarchy6 = null;
        case 6:
        	hierarchy7 = null;
        case 7:
        	hierarchy8 = null;
        case 8:
        	hierarchy9 = null;
        case 9:
            round = null;
        case 10:
            location = null;
        case 11:
            selectedIndividual = null;
        }
    }
    
    public Location getLocation() {
        return location;
    }

    public int getLevelOfHierarchySelected() {
        if (hierarchy1 == null) {
            return 0;
        }

        if (hierarchy2 == null) {
            return 1;
        }
        
        if (hierarchy3 == null) {
            return 2;
        }

        if (hierarchy4 == null) {
            return 3;
        }
        
        if (hierarchy5 == null) {
            return 4;
        }
        
        if (hierarchy6 == null) {
            return 5;
        }
        
        if (hierarchy7 == null) {
            return 6;
        }
        
        if (hierarchy8 == null) {
            return 7;
        }
        
        if (hierarchy9 == null) {
            return 8;
        }

        if (round == null) {
            return 9;
        }

        return 10;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void createLocation(ContentResolver resolver) {
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.context);
		//String numHierarchies = sp.getString(LocationHierarchyActivity.NUM_HIERARCHIES, "4");
		//int numHierarchiesInt = Integer.parseInt(numHierarchies);
    //	pc = PreferenceContainer.getInstance();
    //	int numHierarchiesInt = pc.getNumHierarchies();
    	int numHierarchiesInt = getNumHierarchies();
        LocationHierarchy topHierarchy = hierarchy4;
        switch (numHierarchiesInt){
        	case 1: 
        		topHierarchy=hierarchy1;
        		break;
        	case 2:
        		topHierarchy=hierarchy2;
        		break;
        	case 3:
        		topHierarchy=hierarchy3;
        		break;
        	case 4:
        		topHierarchy=hierarchy4;
        		break;
        	case 5:
        		topHierarchy=hierarchy5;
        		break;
        	case 6:
        		topHierarchy=hierarchy6;
        		break;
        	case 7:
        		topHierarchy=hierarchy7;
        		break;
        	case 8:
        		topHierarchy=hierarchy8;
        		break;
        	case 9:
        		topHierarchy=hierarchy9;
        		break;
        }
        location = new Location();
        String locationId = generateLocationId(resolver, topHierarchy);
        location.setExtId(locationId);
        location.setHierarchy(topHierarchy.getExtId());
    }

    private String generateLocationId(ContentResolver resolver, LocationHierarchy topHierarchy) {
        Cursor cursor = resolver.query(OpenHDS.Locations.CONTENT_ID_URI_BASE,
                new String[] { OpenHDS.Locations.COLUMN_LOCATION_EXTID }, OpenHDS.Locations.COLUMN_LOCATION_EXTID
                        + " LIKE ?", new String[] { topHierarchy.getExtId() + "%" }, OpenHDS.Locations.COLUMN_LOCATION_EXTID
                        + " DESC");

        String generatedId = null;
        if (cursor.moveToFirst()) {
            generatedId = generateLocationIdFrom(cursor.getString(0), topHierarchy);
        } else {
            generatedId = topHierarchy.getExtId() + "01";
        }

        cursor.close();
        return generatedId;
    }

    private String generateLocationIdFrom(String lastGeneratedId, LocationHierarchy topHierarchy) {
        try {
            int increment = Integer.parseInt(lastGeneratedId.substring(3, 5));
            int nextIncrement = increment + 1;
            return String.format(topHierarchy.getExtId() + "%02d", nextIncrement);
        } catch (NumberFormatException e) {
            return topHierarchy.getExtId() + "01";
        }
    }

    // this logic is specific for Cross River
    public void createVisit(ContentResolver resolver) {
        String visitPrefix = "V" + location.getExtId() + round.getRoundNumber();

        Cursor cursor = resolver.query(OpenHDS.Visits.CONTENT_ID_URI_BASE,
                new String[] { OpenHDS.Visits.COLUMN_VISIT_EXTID }, OpenHDS.Visits.COLUMN_VISIT_EXTID + " LIKE ?",
                new String[] { visitPrefix + "%" }, OpenHDS.Visits.COLUMN_VISIT_EXTID + " DESC");
        String visitGeneratedId;
        if (cursor.moveToFirst()) {
            try {
                int lastVisitCount = Integer.parseInt(cursor.getString(0).substring(7, 8));
                int nextVisitCount = lastVisitCount + 1;
                visitGeneratedId = visitPrefix + nextVisitCount;
            } catch (NumberFormatException e) {
                visitGeneratedId = visitPrefix + "1";
            }
        } else {
            visitGeneratedId = visitPrefix + "1";
        }

        cursor.close();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());

        visit = new Visit();
        visit.setExtId(visitGeneratedId);
        visit.setDate(date);
    }

    public PregnancyOutcome createPregnancyOutcome(ContentResolver resolver, int liveBirthCount) {
        PregnancyOutcome outcome = new PregnancyOutcome();
        outcome.setMother(selectedIndividual);

        if (liveBirthCount > 0) {
            String[] ids = generateIndividualIds(resolver, liveBirthCount);
            for (String id : ids) {
                outcome.addChildId(id);
            }
        }

        return outcome;
    }

    private String[] generateIndividualIds(ContentResolver resolver, int liveBirthCount) {
        Cursor cursor = resolver.query(OpenHDS.Individuals.CONTENT_ID_URI_BASE,
                new String[] { OpenHDS.Individuals.COLUMN_INDIVIDUAL_EXTID },
                OpenHDS.Individuals.COLUMN_INDIVIDUAL_EXTID + " LIKE ?", new String[] { location.getExtId() + "%" },
                OpenHDS.Individuals.COLUMN_INDIVIDUAL_EXTID + " DESC");

        int lastIndividualCount = 0;
        if (cursor.moveToFirst()) {
            try {
                lastIndividualCount = Integer.parseInt(cursor.getString(0).substring(5, 8));
            } catch (NumberFormatException e) {
            }
        }

        int nextIndividualCount = lastIndividualCount + 1;
        String[] ids = new String[liveBirthCount];
        for (int i = 0; i < liveBirthCount; i++) {
            ids[i] = location.getExtId() + String.format("%03d", nextIndividualCount);
            nextIndividualCount += 1;
        }

        cursor.close();

        return ids;
    }

    // an option to create a new social group rather than to reference an
    // existing one
    public SocialGroup createSocialGroup(ContentResolver resolver) {
        SocialGroup sg = new SocialGroup();

        String socialGroupPrefix = location.getExtId();

        Cursor cursor = resolver.query(OpenHDS.SocialGroups.CONTENT_ID_URI_BASE,
                new String[] { OpenHDS.SocialGroups.COLUMN_SOCIALGROUP_EXTID },
                OpenHDS.SocialGroups.COLUMN_SOCIALGROUP_EXTID + " LIKE ?", new String[] { socialGroupPrefix + "%" },
                OpenHDS.SocialGroups.COLUMN_SOCIALGROUP_EXTID + " DESC");

        if (cursor.moveToNext()) {
            int lastIncrement = Integer.parseInt(cursor.getString(0).substring(5, 7));
            int nextIncrement = lastIncrement + 1;
            sg.setExtId(socialGroupPrefix + String.format("%02d", nextIncrement));
        } else {
            sg.setExtId(socialGroupPrefix + "01");
        }

        cursor.close();

        return sg;
    }

    public Individual determinePregnancyOutcomeFather(ContentResolver resolver) {
        Cursor cursor = Queries.getRelationshipByIndividualA(resolver, selectedIndividual.getExtId());
        List<Relationship> rels = Converter.toRelationshipList(cursor);
        // the selected individual will always be the 'individualA' in the
        // relationship
        cursor = Queries.getRelationshipByIndividualB(resolver, selectedIndividual.getExtId());
        rels.addAll(Converter.toRelationshipListSwapped(cursor));

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Relationship currentHusband = null;
        // must find the most current relationship
        for (Relationship rel : rels) {

            if (currentHusband == null) {
                currentHusband = rel;
            } else {
                try {
                    Date currentDate = formatter.parse(currentHusband.getStartDate());
                    Date relDate = formatter.parse(rel.getStartDate());
                    if (currentDate.before(relDate))
                        currentHusband = rel;

                } catch (ParseException e) {
                    return null;
                }
            }
        }

        if (currentHusband == null) {
            return null;
        } else {
            String fatherId = currentHusband.getIndividualB();
            cursor = Queries.getIndividualByExtId(resolver, fatherId);
            return Converter.toIndividual(cursor);
        }
    }

    public Visit getVisit() {
        return visit;
    }

    public boolean isVisitStarted() {
        return visit != null;
    }

    public String generateIndividualId(ContentResolver resolver) {
        Cursor cursor = resolver.query(OpenHDS.Individuals.CONTENT_ID_URI_BASE,
                new String[] { OpenHDS.Individuals.COLUMN_INDIVIDUAL_EXTID },
                OpenHDS.Individuals.COLUMN_INDIVIDUAL_RESIDENCE + " = ?", new String[] { location.getExtId() },
                OpenHDS.Individuals.COLUMN_INDIVIDUAL_EXTID + " DESC");

        String id = null;
        if (cursor.moveToNext()) {
            int lastIncrement = Integer.parseInt(cursor.getString(0).substring(5, 8));
            int nextIncrement = lastIncrement + 1;
            id = location.getExtId() + String.format("%03d", nextIncrement);
        } else {
            id = location.getExtId() + "001";
        }

        cursor.close();

        return id;
    }
}
