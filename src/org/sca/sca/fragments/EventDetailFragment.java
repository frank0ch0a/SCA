package org.sca.sca.fragments;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.adapters.EventDetailAdapter;
import org.sca.sca.model.ActivitiesModel;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

public class EventDetailFragment extends Fragment {

	private ImageView mImageEventBG = null;
	private ListView mEventList;
	private RadioButton mEventDay1Btn = null;
	private RadioButton mEventDay2Btn = null;
	private ArrayList<ActivitiesModel> day1;
	private ArrayList<ActivitiesModel> day2;
	private Activity mActivity;

	public EventDetailFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_detail_events,
				container, false);

		mImageEventBG = (ImageView) rootView.findViewById(R.id.imageViewNews);
		mEventList = (ListView) rootView.findViewById(R.id.listViewDays);
		mEventDay1Btn = (RadioButton) rootView.findViewById(R.id.event_day1);
		mEventDay2Btn = (RadioButton) rootView.findViewById(R.id.event_day2);
		day1 = new ArrayList<ActivitiesModel>();
		day2 = new ArrayList<ActivitiesModel>();
		System.out.println(EventsFragment.jsonO);

		loadData();

		mEventList.setAdapter(new EventDetailAdapter(mActivity, day1));
		mEventList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Se realiza la accion cuando se oprime un objeto de la
				// lista
			}

		});
		mEventDay1Btn.setChecked(true);

		mEventDay1Btn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					mEventList.setAdapter(new EventDetailAdapter(mActivity,
							day1));
				}
			}
		});

		mEventDay2Btn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					mEventList.setAdapter(new EventDetailAdapter(mActivity,
							day2));
				}
			}
		});

		return rootView;
	}

	private void loadData() {
		try {
			JSONArray events = EventsFragment.jsonO.getJSONArray("event");
			JSONObject event = events.getJSONObject(0);
			JSONArray activities = event.getJSONArray("activities");
			for (int i = 0; i < activities.length(); i++) {
				JSONObject temp = activities.getJSONObject(i);
				ActivitiesModel activity = new ActivitiesModel();
				activity.setId_activity(temp.getString("id_activity"));
				activity.setTitle_activity(temp.getString("title_activity"));
				activity.setHour_i_activity(temp.getString("hour_i_activity"));
				activity.setHour_f_activity(temp.getString("hour_f_activity"));
				activity.setDate_n_activity(temp.getString("date_n_activity"));
				activity.setLocation_activity(temp
						.getString("location_activity"));
				activity.setLat_activity(temp.getString("lat_activity"));
				activity.setLon_activity(temp.getString("lon_activity"));
				activity.setZoom_activity(temp.getString("zoom_activity"));
				activity.setDesc_activity(temp.getString("desc_activity"));
				activity.setId_person_activity(temp
						.getString("id_person_activity"));
				activity.setName_person_activity(temp
						.getString("name_person_activity"));
				activity.setLastname_person_activity(temp
						.getString("lastname_person_activity"));
				activity.setId_event_activity(temp
						.getString("id_event_activity"));
				activity.setName_event_activity(temp
						.getString("name_event_activity"));
				activity.setHasimg_activity(temp.getString("hasimg_activity"));
				activity.setExtimg_activity(temp.getString("extimg_activity"));
				activity.setInx_day(temp.getString("inx_day"));
				activity.setHour_i_activity_format(temp
						.getString("hour_i_activity_format"));
				activity.setHour_f_activity_format(temp
						.getString("hour_f_activity_format"));
				JSONObject img = temp.getJSONObject("img");
				activity.setmBig(img.getString("big"));
				activity.setmT01(img.getString("t01"));
				activity.setmT02(img.getString("t02"));
				activity.setmT03(img.getString("t03"));
				if (temp.getString("inx_day").equalsIgnoreCase("26/09")) {
					day1.add(activity);
				} else if (temp.getString("inx_day").equalsIgnoreCase("27/09")) {
					day2.add(activity);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mActivity = activity;
	}
}
