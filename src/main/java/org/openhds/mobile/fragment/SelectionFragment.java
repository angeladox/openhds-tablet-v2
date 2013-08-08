package org.openhds.mobile.fragment;

import org.openhds.mobile.R;
import org.openhds.mobile.activity.LocationHierarchyActivity;
import org.openhds.mobile.model.Individual;
import org.openhds.mobile.model.Location;
import org.openhds.mobile.model.LocationHierarchy;
import org.openhds.mobile.model.LocationVisit;
import org.openhds.mobile.model.Round;
import org.openhds.mobile.model.StateMachine;
import org.openhds.mobile.model.StateMachine.State;
import org.openhds.mobile.model.StateMachine.StateListener;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import static android.view.View.GONE;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SelectionFragment extends Fragment implements OnClickListener {

	private ContentResolver resolver;
	private static final String START_HIERARCHY_LEVEL_NAME = "Country";

	public static interface Listener {
		void onHierarchy1();

		void onHierarchy2();

		void onHierarchy3();

		void onHierarchy4();

		void onHierarchy5();

		void onHierarchy6();

		void onHierarchy7();

		void onHierarchy8();

		void onHierarchy9();

		void onLocation();

		void onRound();

		void onIndividual();
	}

	private Listener listener;
	private LocationVisit locationVisit;

	private Button hierarchy1Btn, hierarchy2Btn, hierarchy3Btn, hierarchy4Btn, hierarchy5Btn, hierarchy6Btn, hierarchy7Btn, hierarchy8Btn,
			hierarchy9Btn, locationBtn, roundBtn, individualBtn;

	private TextView loginGreetingText, 
	hierarchy1NameText, hierarchy1ExtIdText, hierarchy1Header, 
	hierarchy2NameText, hierarchy2ExtIdText, hierarchy2Header, 
	hierarchy3NameText, hierarchy3ExtIdText, hierarchy3Header, 
	hierarchy4NameText, hierarchy4ExtIdText, hierarchy4Header, 
	hierarchy5NameText, hierarchy5ExtIdText, hierarchy5Header, 
	hierarchy6NameText, hierarchy6ExtIdText, hierarchy6Header, 
	hierarchy7NameText, hierarchy7ExtIdText, hierarchy7Header, 
	hierarchy8NameText, hierarchy8ExtIdText, hierarchy8Header, 
	hierarchy9NameText, hierarchy9ExtIdText, hierarchy9Header, 
	roundNumberText, roundStartDateText, roundEndDateText, 
	locationNameText, locationExtIdText, locationLatitudeText, 
	locationLongitudeText, individualFirstNameText,
	individualLastNameText, individualExtIdText, individualDobText;

	String numHierarchies, hierarchy1, hierarchy2, hierarchy3, hierarchy4, hierarchy5, hierarchy6, hierarchy7, hierarchy8, hierarchy9;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Listener) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getBaseContext());
		numHierarchies = sp.getString(LocationHierarchyActivity.NUM_HIERARCHIES, getString(R.id.numHierarchies));
		int numHierarchiesInt = Integer.parseInt(numHierarchies);
		loadHierarchyValues(sp, numHierarchiesInt);
		View view = inflater.inflate(R.layout.selection, container, false);
		bindViews(view, numHierarchiesInt);
		return view;
	}

	private void loadHierarchyValues(SharedPreferences sp, int numHierarchies) {
		switch (numHierarchies) {
		case 1:
			numHierarchies = 1;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			break;
		case 2:
			numHierarchies = 2;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			break;
		case 3:
			numHierarchies = 3;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			break;
		case 4:
			numHierarchies = 4;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			hierarchy4 = sp.getString(LocationHierarchyActivity.HIERARCHY_4, getString(R.id.hierarchy4));
			break;
		case 5:
			numHierarchies = 5;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			hierarchy4 = sp.getString(LocationHierarchyActivity.HIERARCHY_4, getString(R.id.hierarchy4));
			hierarchy5 = sp.getString(LocationHierarchyActivity.HIERARCHY_5, getString(R.id.hierarchy5));
			break;
		case 6:
			numHierarchies = 6;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			hierarchy4 = sp.getString(LocationHierarchyActivity.HIERARCHY_4, getString(R.id.hierarchy4));
			hierarchy5 = sp.getString(LocationHierarchyActivity.HIERARCHY_5, getString(R.id.hierarchy5));
			hierarchy6 = sp.getString(LocationHierarchyActivity.HIERARCHY_6, getString(R.id.hierarchy6));
			break;
		case 7:
			numHierarchies = 7;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			hierarchy4 = sp.getString(LocationHierarchyActivity.HIERARCHY_4, getString(R.id.hierarchy4));
			hierarchy5 = sp.getString(LocationHierarchyActivity.HIERARCHY_5, getString(R.id.hierarchy5));
			hierarchy6 = sp.getString(LocationHierarchyActivity.HIERARCHY_6, getString(R.id.hierarchy6));
			hierarchy7 = sp.getString(LocationHierarchyActivity.HIERARCHY_7, getString(R.id.hierarchy7));
			break;
		case 8:
			numHierarchies = 8;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			hierarchy4 = sp.getString(LocationHierarchyActivity.HIERARCHY_4, getString(R.id.hierarchy4));
			hierarchy5 = sp.getString(LocationHierarchyActivity.HIERARCHY_5, getString(R.id.hierarchy5));
			hierarchy6 = sp.getString(LocationHierarchyActivity.HIERARCHY_6, getString(R.id.hierarchy6));
			hierarchy7 = sp.getString(LocationHierarchyActivity.HIERARCHY_7, getString(R.id.hierarchy7));
			hierarchy8 = sp.getString(LocationHierarchyActivity.HIERARCHY_8, getString(R.id.hierarchy8));
			break;
		case 9:
			numHierarchies = 9;
			hierarchy1 = sp.getString(LocationHierarchyActivity.HIERARCHY_1, getString(R.id.hierarchy1));
			hierarchy2 = sp.getString(LocationHierarchyActivity.HIERARCHY_2, getString(R.id.hierarchy2));
			hierarchy3 = sp.getString(LocationHierarchyActivity.HIERARCHY_3, getString(R.id.hierarchy3));
			hierarchy4 = sp.getString(LocationHierarchyActivity.HIERARCHY_4, getString(R.id.hierarchy4));
			hierarchy5 = sp.getString(LocationHierarchyActivity.HIERARCHY_5, getString(R.id.hierarchy5));
			hierarchy6 = sp.getString(LocationHierarchyActivity.HIERARCHY_6, getString(R.id.hierarchy6));
			hierarchy7 = sp.getString(LocationHierarchyActivity.HIERARCHY_7, getString(R.id.hierarchy7));
			hierarchy8 = sp.getString(LocationHierarchyActivity.HIERARCHY_8, getString(R.id.hierarchy8));
			hierarchy9 = sp.getString(LocationHierarchyActivity.HIERARCHY_9, getString(R.id.hierarchy9));
			break;
		}
	}

	private void bindViews(View view, int numHierarchies) {
		loginGreetingText = (TextView) view.findViewById(R.id.loginGreetingText);
		switch (numHierarchies) {
		case 1:
			bindHierarchy1(view);
			setWidgetsInvisible(view, 2);
			break;
		case 2:
			bindHierarchy1(view);
			bindHierarchy2(view);
			setWidgetsInvisible(view, 3);
			break;
		case 3:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			setWidgetsInvisible(view, 4);
			break;
		case 4:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			bindHierarchy4(view);
			setWidgetsInvisible(view, 5);
			break;
		case 5:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			bindHierarchy4(view);
			bindHierarchy5(view);
			setWidgetsInvisible(view, 6);
			break;
		case 6:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			bindHierarchy4(view);
			bindHierarchy5(view);
			bindHierarchy6(view);
			setWidgetsInvisible(view, 7);
			break;
		case 7:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			bindHierarchy4(view);
			bindHierarchy5(view);
			bindHierarchy6(view);
			bindHierarchy7(view);
			setWidgetsInvisible(view, 8);
			break;
		case 8:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			bindHierarchy4(view);
			bindHierarchy5(view);
			bindHierarchy6(view);
			bindHierarchy7(view);
			bindHierarchy8(view);
			setWidgetsInvisible(view, 9);
			break;
		case 9:
			bindHierarchy1(view);
			bindHierarchy2(view);
			bindHierarchy3(view);
			bindHierarchy4(view);
			bindHierarchy5(view);
			bindHierarchy6(view);
			bindHierarchy7(view);
			bindHierarchy8(view);
			bindHierarchy9(view);
			break;
		}
		locationBtn = (Button) view.findViewById(R.id.locationBtn);
		locationBtn.setOnClickListener(this);
		locationNameText = (TextView) view.findViewById(R.id.locationNameText);
		locationExtIdText = (TextView) view.findViewById(R.id.locationExtIdText);
		locationLatitudeText = (TextView) view.findViewById(R.id.locationLatitudeText);
		locationLongitudeText = (TextView) view.findViewById(R.id.locationLongitudeText);

		roundBtn = (Button) view.findViewById(R.id.roundBtn);
		roundBtn.setOnClickListener(this);
		roundNumberText = (TextView) view.findViewById(R.id.roundNumberText);
		roundStartDateText = (TextView) view.findViewById(R.id.roundStartDateText);
		roundEndDateText = (TextView) view.findViewById(R.id.roundEndDateText);

		individualBtn = (Button) view.findViewById(R.id.individualBtn);
		individualBtn.setOnClickListener(this);
		individualExtIdText = (TextView) view.findViewById(R.id.individualExtIdText);
		individualFirstNameText = (TextView) view.findViewById(R.id.individualFirstNameText);
		individualLastNameText = (TextView) view.findViewById(R.id.individualLastNameText);
		individualDobText = (TextView) view.findViewById(R.id.individualDobText);
	}

	private void bindHierarchy1(View view) {
		hierarchy1Btn = (Button) view.findViewById(R.id.hierarchy1Btn);
		hierarchy1Btn.setText("Select " + hierarchy1);
		hierarchy1Btn.setOnClickListener(this);
		hierarchy1Header = (TextView) view.findViewById(R.id.hierarchy1Header);
		hierarchy1Header.setText(hierarchy1 + ":");
		hierarchy1NameText = (TextView) view.findViewById(R.id.hierarchy1Name);
		hierarchy1ExtIdText = (TextView) view.findViewById(R.id.hierarchy1ExtId);
	}

	private void bindHierarchy2(View view) {
		hierarchy2Btn = (Button) view.findViewById(R.id.hierarchy2Btn);
		hierarchy2Btn.setText("Select " + hierarchy2);
		hierarchy2Btn.setOnClickListener(this);
		hierarchy2Header = (TextView) view.findViewById(R.id.hierarchy2Header);
		hierarchy2Header.setText(hierarchy2 + ":");
		hierarchy2NameText = (TextView) view.findViewById(R.id.hierarchy2Name);
		hierarchy2ExtIdText = (TextView) view.findViewById(R.id.hierarchy2ExtId);
	}

	private void bindHierarchy3(View view) {
		hierarchy3Btn = (Button) view.findViewById(R.id.hierarchy3Btn);
		hierarchy3Btn.setText("Select " + hierarchy3);
		hierarchy3Btn.setOnClickListener(this);
		hierarchy3NameText = (TextView) view.findViewById(R.id.hierarchy3Name);
		hierarchy3ExtIdText = (TextView) view.findViewById(R.id.hierarchy3ExtId);
		hierarchy3Header = (TextView) view.findViewById(R.id.hierarchy3Header);
		hierarchy3Header.setText(hierarchy3 + ":");
	}

	private void bindHierarchy4(View view) {
		hierarchy4Btn = (Button) view.findViewById(R.id.hierarchy4Btn);
		hierarchy4Btn.setText("Select " + hierarchy4);
		hierarchy4Btn.setOnClickListener(this);
		hierarchy4NameText = (TextView) view.findViewById(R.id.hierarchy4Name);
		hierarchy4ExtIdText = (TextView) view.findViewById(R.id.hierarchy4ExtId);
		hierarchy4Header = (TextView) view.findViewById(R.id.hierarchy4Header);
		hierarchy4Header.setText(hierarchy4 + ":");
	}

	private void bindHierarchy5(View view) {
		hierarchy5Btn = (Button) view.findViewById(R.id.hierarchy5Btn);
		hierarchy5Btn.setText("Select " + hierarchy5);
		hierarchy5Btn.setOnClickListener(this);
		hierarchy5Header = (TextView) view.findViewById(R.id.hierarchy5Header);
		hierarchy5Header.setText(hierarchy5 + ":");
		hierarchy5NameText = (TextView) view.findViewById(R.id.hierarchy5Name);
		hierarchy5ExtIdText = (TextView) view.findViewById(R.id.hierarchy5ExtId);
	}

	private void bindHierarchy6(View view) {
		hierarchy6Btn = (Button) view.findViewById(R.id.hierarchy6Btn);
		hierarchy6Btn.setText("Select " + hierarchy6);
		hierarchy6Btn.setOnClickListener(this);
		hierarchy6Header = (TextView) view.findViewById(R.id.hierarchy6Header);
		hierarchy6Header.setText(hierarchy6 + ":");
		hierarchy6NameText = (TextView) view.findViewById(R.id.hierarchy6Name);
		hierarchy6ExtIdText = (TextView) view.findViewById(R.id.hierarchy6ExtId);
	}

	private void bindHierarchy7(View view) {
		hierarchy7Btn = (Button) view.findViewById(R.id.hierarchy7Btn);
		hierarchy7Btn.setText("Select " + hierarchy7);
		hierarchy7Btn.setOnClickListener(this);
		hierarchy7Header = (TextView) view.findViewById(R.id.hierarchy7Header);
		hierarchy7Header.setText(hierarchy7 + ":");
		hierarchy7NameText = (TextView) view.findViewById(R.id.hierarchy7Name);
		hierarchy7ExtIdText = (TextView) view.findViewById(R.id.hierarchy7ExtId);
	}

	private void bindHierarchy8(View view) {
		hierarchy8Btn = (Button) view.findViewById(R.id.hierarchy8Btn);
		hierarchy8Btn.setText("Select " + hierarchy8);
		hierarchy8Btn.setOnClickListener(this);
		hierarchy8Header = (TextView) view.findViewById(R.id.hierarchy8Header);
		hierarchy8Header.setText(hierarchy8 + ":");
		hierarchy8NameText = (TextView) view.findViewById(R.id.hierarchy8Name);
		hierarchy8ExtIdText = (TextView) view.findViewById(R.id.hierarchy8ExtId);
	}

	private void bindHierarchy9(View view) {
		hierarchy9Btn = (Button) view.findViewById(R.id.hierarchy9Btn);
		hierarchy9Btn.setText("Select " + hierarchy9);
		hierarchy9Btn.setOnClickListener(this);
		hierarchy9Header = (TextView) view.findViewById(R.id.hierarchy9Header);
		hierarchy9Header.setText(hierarchy9 + ":");
		hierarchy9NameText = (TextView) view.findViewById(R.id.hierarchy9Name);
		hierarchy9ExtIdText = (TextView) view.findViewById(R.id.hierarchy9ExtId);
	}

	private void setWidgetsInvisible(View view, int low) {
		switch (low) {
		case 2:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy2Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy2Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy2Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy2ExtId));
			// 3
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy3Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy3Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy3Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy3ExtId));
			// 4
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy4Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4ExtId));
			// 5
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy5Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5ExtId));
			// 6
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy6Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6ExtId));
			// 7
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy7Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7ExtId));
			// 8
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 3:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy3Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy3Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy3Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy3ExtId));
			// 4
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy4Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4ExtId));
			// 5
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy5Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5ExtId));
			// 6
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy6Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6ExtId));
			// 7
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy7Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7ExtId));
			// 8
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 4:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy4Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy4ExtId));
			// 5
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy5Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5ExtId));
			// 6
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy6Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6ExtId));
			// 7
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy7Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7ExtId));
			// 8
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 5:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy5Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy5ExtId));
			// 6
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy6Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6ExtId));
			// 7
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy7Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7ExtId));
			// 8
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 6:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy6Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy6ExtId));
			// 7
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy7Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7ExtId));
			// 8
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 7:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy7Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy7ExtId));
			// 8
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 8:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy8Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy8ExtId));
			// 9
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
		case 9:
			setButtonInvisible((Button) view.findViewById(R.id.hierarchy9Btn));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Header));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9Name));
			setTextViewInvisible((TextView) view.findViewById(R.id.hierarchy9ExtId));
			break;
			
		}
	}
	private void setButtonInvisible(Button button) {
		button.setVisibility(GONE);
	}

	private void setTextViewInvisible(TextView tv) {
		tv.setVisibility(GONE);
	}

	private void setHierarchy1() {
		LocationHierarchy hierarchy1 = locationVisit.getHierarchy1();
		if (hierarchy1 == null) {
			hierarchy1 = LocationHierarchy.emptyHierarchy();
		}

		hierarchy1NameText.setText(hierarchy1.getName());
		hierarchy1ExtIdText.setText(hierarchy1.getExtId());
	}

	private void setHierarchy2() {
		LocationHierarchy hierarchy2 = locationVisit.getHierarchy2();
		if (hierarchy2 == null) {
			hierarchy2 = LocationHierarchy.emptyHierarchy();
		}

		hierarchy2NameText.setText(hierarchy2.getName());
		hierarchy2ExtIdText.setText(hierarchy2.getExtId());
	}

	private void setHierarchy3() {
		LocationHierarchy hierarchy3 = locationVisit.getHierarchy3();
		if (hierarchy3 == null) {
			hierarchy3 = LocationHierarchy.emptyHierarchy();
		}

		hierarchy3NameText.setText(hierarchy3.getName());
		hierarchy3ExtIdText.setText(hierarchy3.getExtId());
	}

	private void setHierarchy4() {
		LocationHierarchy hierarchy4 = locationVisit.getHierarchy4();
		if (hierarchy4 == null) {
			hierarchy4 = LocationHierarchy.emptyHierarchy();
		}

		hierarchy4NameText.setText(hierarchy4.getName());
		hierarchy4ExtIdText.setText(hierarchy4.getExtId());
	}
	
	private void setHierarchy5() {
		LocationHierarchy hierarchy5 = locationVisit.getHierarchy5();
		if (hierarchy5 == null) {
			hierarchy5 = LocationHierarchy.emptyHierarchy();
		}
		hierarchy5NameText.setText(hierarchy5.getName());
		hierarchy5ExtIdText.setText(hierarchy5.getExtId());
	}
	
	private void setHierarchy6() {
		LocationHierarchy hierarchy6 = locationVisit.getHierarchy6();
		if (hierarchy6 == null) {
			hierarchy6 = LocationHierarchy.emptyHierarchy();
		}
		hierarchy6NameText.setText(hierarchy6.getName());
		hierarchy6ExtIdText.setText(hierarchy6.getExtId());
	}
	
	private void setHierarchy7() {
		LocationHierarchy hierarchy7 = locationVisit.getHierarchy7();
		if (hierarchy7 == null) {
			hierarchy7 = LocationHierarchy.emptyHierarchy();
		}
		hierarchy7NameText.setText(hierarchy7.getName());
		hierarchy7ExtIdText.setText(hierarchy7.getExtId());
	}
	
	private void setHierarchy8() {
		LocationHierarchy hierarchy8 = locationVisit.getHierarchy8();
		if (hierarchy8 == null) {
			hierarchy8 = LocationHierarchy.emptyHierarchy();
		}
		hierarchy8NameText.setText(hierarchy8.getName());
		hierarchy8ExtIdText.setText(hierarchy8.getExtId());
	}
	
	private void setHierarchy9() {
		LocationHierarchy hierarchy9 = locationVisit.getHierarchy9();
		if (hierarchy9 == null) {
			hierarchy9 = LocationHierarchy.emptyHierarchy();
		}
		hierarchy9NameText.setText(hierarchy9.getName());
		hierarchy9ExtIdText.setText(hierarchy9.getExtId());
	}

	private void setRound() {
		Round round = locationVisit.getRound();
		if (round == null) {
			round = Round.getEmptyRound();
		}
		roundNumberText.setText(round.getRoundNumber());
		roundStartDateText.setText(round.getStartDate());
		roundEndDateText.setText(round.getEndDate());
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.hierarchy1Btn:
			listener.onHierarchy1();
			break;
		case R.id.hierarchy2Btn:
			listener.onHierarchy2();
			break;
		case R.id.hierarchy3Btn:
			listener.onHierarchy3();
			break;
		case R.id.hierarchy4Btn:
			listener.onHierarchy4();
			break;
		case R.id.hierarchy5Btn:
			listener.onHierarchy5();
			break;
		case R.id.hierarchy6Btn:
			listener.onHierarchy6();
			break;
		case R.id.hierarchy7Btn:
			listener.onHierarchy7();
			break;
		case R.id.hierarchy8Btn:
			listener.onHierarchy8();
			break;
		case R.id.hierarchy9Btn:
			listener.onHierarchy9();
			break;
		case R.id.locationBtn:
			listener.onLocation();
			break;
		case R.id.roundBtn:
			listener.onRound();
			break;
		case R.id.individualBtn:
			listener.onIndividual();
			break;
		}
	}

	public void setLocationVisit(LocationVisit locationVisit) {
		this.locationVisit = locationVisit;
		loginGreetingText.setText("Hello, " + locationVisit.getFieldWorker().getFirstName() + " "
				+ locationVisit.getFieldWorker().getLastName());
	}

	public void registerTransitions(StateMachine stateMachine) {
		registerHierarchy1Listener(stateMachine);
		registerHierarchy2Listener(stateMachine);
		registerHierarchy3Listener(stateMachine);
		registerHierarchy4Listener(stateMachine);
		registerHierarchy5Listener(stateMachine);
		registerHierarchy6Listener(stateMachine);
		registerHierarchy7Listener(stateMachine);
		registerHierarchy8Listener(stateMachine);
		registerHierarchy9Listener(stateMachine);
		registerRoundListener(stateMachine);
		registerLocationListener(stateMachine);
		registerVisitListener(stateMachine);
		registerIndividualListener(stateMachine);
		registerEventListener(stateMachine);
		registerFinishVisitListener(stateMachine);
	}

	private void registerFinishVisitListener(StateMachine stateMachine) {
		stateMachine.registerListener(State.FINISH_VISIT, new StateListener() {
			public void onEnterState() {
			}

			public void onLeaveState() {
				hierarchy1Btn.setEnabled(true);
				hierarchy2Btn.setEnabled(true);
				hierarchy3Btn.setEnabled(true);
				hierarchy4Btn.setEnabled(true);
				hierarchy5Btn.setEnabled(true);
				hierarchy6Btn.setEnabled(true);
				hierarchy7Btn.setEnabled(true);
				hierarchy8Btn.setEnabled(true);
				hierarchy9Btn.setEnabled(true);
				roundBtn.setEnabled(true);
			}
		});
	}

	private void registerEventListener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_EVENT, new StateListener() {
			public void onEnterState() {
				setIndividual();
			}

			public void onLeaveState() {
			}
		});
	}

	private void registerVisitListener(StateMachine stateMachine) {
		stateMachine.registerListener(State.CREATE_VISIT, new StateListener() {
			public void onEnterState() {
			}

			public void onLeaveState() {
				hierarchy1Btn.setEnabled(false);
				hierarchy2Btn.setEnabled(false);
				hierarchy3Btn.setEnabled(false);
				hierarchy4Btn.setEnabled(false);
				hierarchy5Btn.setEnabled(false);
				hierarchy6Btn.setEnabled(false);
				hierarchy7Btn.setEnabled(false);
				hierarchy8Btn.setEnabled(false);
				hierarchy9Btn.setEnabled(false);
				roundBtn.setEnabled(false);
				locationBtn.setEnabled(false);
			}
		});
	}

	private void registerIndividualListener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_INDIVIDUAL, new StateListener() {
			public void onEnterState() {
				setIndividual();
				individualBtn.setEnabled(true);
			}

			public void onLeaveState() {
				individualBtn.setEnabled(false);
			}
		});
	}

	private void registerLocationListener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_LOCATION, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(10, false);
				locationBtn.setEnabled(true);
			}

			public void onLeaveState() {
				setLocation();
			}
		});
	}

	private void registerRoundListener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_ROUND, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(9, false);
				roundBtn.setEnabled(true);
			}
			public void onLeaveState() {
				setRound();
			}
		});
	}
	
	private void registerHierarchy1Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_1, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(0, false);
				hierarchy1Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy1();
			}
		});
	}
	
	private void registerHierarchy2Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_2, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(1, false);
				hierarchy2Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy2();
			}
		});
	}

	private void registerHierarchy3Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_3, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(2, false);
				hierarchy3Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy3();
			}
		});
	}

	private void registerHierarchy4Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_4, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(3, false);
				hierarchy4Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy4();
			}
		});
	}
	
	private void registerHierarchy5Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_5, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(4, false);
				hierarchy5Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy5();
			}
		});
	}
	
	private void registerHierarchy6Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_6, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(5, false);
				hierarchy6Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy6();
			}
		});
	}
	
	private void registerHierarchy7Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_7, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(6, false);
				hierarchy7Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy7();
			}
		});
	}
	
	private void registerHierarchy8Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_8, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(7, false);
				hierarchy8Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy8();
			}
		});
	}
	
	private void registerHierarchy9Listener(StateMachine stateMachine) {
		stateMachine.registerListener(State.SELECT_HIERARCHY_9, new StateListener() {
			public void onEnterState() {
				resetToDefaultState(8, false);
				hierarchy4Btn.setEnabled(true);
			}
			public void onLeaveState() {
				setHierarchy9();
			}
		});
	}

	private void resetToDefaultState(int level, boolean enabled) {
		switch (level) {
		case 0:
			hierarchy1Btn.setEnabled(enabled);
			setHierarchy1();
		case 1:
			hierarchy2Btn.setEnabled(enabled);
			setHierarchy2();
		case 2:
			hierarchy3Btn.setEnabled(enabled);
			setHierarchy3();
		case 3:
			hierarchy4Btn.setEnabled(enabled);
			setHierarchy4();
		case 4:
			hierarchy5Btn.setEnabled(enabled);
			setHierarchy5();
		case 5:
			hierarchy6Btn.setEnabled(enabled);
			setHierarchy6();
		case 6:
			hierarchy7Btn.setEnabled(enabled);
			setHierarchy7();
		case 7:
			hierarchy8Btn.setEnabled(enabled);
			setHierarchy8();
		case 8:
			hierarchy9Btn.setEnabled(enabled);
			setHierarchy9();
		case 9:
			roundBtn.setEnabled(enabled);
			setRound();
		case 10:
			locationBtn.setEnabled(enabled);
			setLocation();
		case 11:
			individualBtn.setEnabled(enabled);
			setIndividual();
		}
	}

	private void setIndividual() {
		Individual selectedIndividual = locationVisit.getSelectedIndividual();
		if (selectedIndividual == null) {
			selectedIndividual = Individual.emptyIndividual();
		}

		individualFirstNameText.setText(selectedIndividual.getFirstName());
		individualLastNameText.setText(selectedIndividual.getLastName());
		individualExtIdText.setText(selectedIndividual.getExtId());
		individualDobText.setText(selectedIndividual.getDob());
	}

	private void setLocation() {
		Location location = locationVisit.getLocation();
		if (location == null) {
			location = Location.emptyLocation();
		}

		locationNameText.setText(location.getName());
		locationExtIdText.setText(location.getExtId());
		locationLatitudeText.setText(location.getLatitude());
		locationLongitudeText.setText(location.getLongitude());
	}
}
