package org.sca.sca.fragments;

import java.util.List;

import org.sca.sca.R;
import org.sca.sca.adapters.RegionArchitectAdapter;
import org.sca.sca.fragments.RegionListFragment.RegionListAdapter;
import org.sca.sca.model.RegionModel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RegionsDetailFragment extends Fragment {

	private static RegionModel region;
	private Activity mActivity;

	public RegionsDetailFragment(RegionModel region) {
		RegionsDetailFragment.region = region;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);

		View root = inflater.inflate(R.layout.region_detail, container, false);
		
		

		((TextView) root.findViewById(R.id.city_textView)).setText(region
				.getName_reg());
		
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Regular.otf");
	((TextView) root.findViewById(R.id.city_textView)).setTypeface(tf);
		
		if (region.getName_person_reg() != null
				&& !region.getName_person_reg().equalsIgnoreCase("null")
				&& region.getLastname_person_reg() != null
				&& !region.getLastname_person_reg().equalsIgnoreCase("null")) {
			((TextView) root.findViewById(R.id.president_region_textView))
					.setText(region.getName_person_reg() + " "
							+ region.getLastname_person_reg());
		}
		((TextView) root.findViewById(R.id.address_textView)).setText(region
				.getDir_reg());

		ListView mListView = (ListView) root
				.findViewById(R.id.regions_list_viewArchitects);
		mListView.setAdapter(new RegionArchitectAdapter(mActivity, region
				.getPersons()));
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager
						.beginTransaction()
						.replace(
								R.id.frame_container,
								new ArchitectDetailFragment(region.getPersons()
										.get(arg2))).commit();
			}
		});

		return root;

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}
	
	
	
}
