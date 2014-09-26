package org.sca.sca.controllers;

import org.sca.sca.R;
import org.sca.sca.model.ApiRegionConnection;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi") 

public class WhoWeAreFragment extends Fragment {
	
	public WhoWeAreFragment(){}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView= inflater.inflate(R.layout.fragment_whoweare, container, false);
		
		AsyncTask<Object, Integer, ApiRegionConnection> downloadData = new AsyncTask<Object, Integer, ApiRegionConnection>(){

			@Override
			protected ApiRegionConnection doInBackground(Object... params) {
				
				return ApiRegionConnection.getInstance("tp=4&");
			}
			
			
			
		};
		
		downloadData.execute();
		
		return rootView;
	}

}
