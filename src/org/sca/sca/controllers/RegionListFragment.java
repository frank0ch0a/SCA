package org.sca.sca.controllers;

import org.sca.sca.R;
import org.sca.sca.model.ApiRegionConnection;
import org.sca.sca.model.Regions;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RegionListFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		 super.onCreateView(inflater, container, savedInstanceState);
		 
		 
		 View root = inflater.inflate(R.layout.fragment_list_regions, container, false);
		 
		 
		 AsyncTask<Object, Integer, ApiRegionConnection> downloadRegions = new AsyncTask<Object, Integer, ApiRegionConnection>(){

			@Override
			protected ApiRegionConnection doInBackground(Object... params) {
				
				
				return ApiRegionConnection.getInstance("tp=4&");
			}

			@Override
			protected void onPostExecute(ApiRegionConnection apiregionconnection) {
				
				ListView listView = (ListView)getView().findViewById(android.R.id.list);
				ArrayAdapter<Regions> adapter = new ArrayAdapter<Regions>(getActivity(), android.R.layout.simple_list_item_1, apiregionconnection.getRegionsList());
				listView.setAdapter(adapter);
				//listView.setOnItemClickListener((OnItemClickListener)getActivity());
				
			}
			 
			 };
		 
		 downloadRegions.execute();
		 
		 
		 return root;
		 
		 
	}
	
	

}




