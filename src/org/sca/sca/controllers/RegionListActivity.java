package org.sca.sca.controllers;


import org.sca.sca.R;
import org.sca.sca.fragments.RegionListFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;


public class RegionListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_region_list);
		
		boolean haslist = findViewById(R.id.regions_list) != null;
		
		FragmentManager fm =  getFragmentManager();
		
		if (haslist) {
			
			Fragment lisFragment = fm.findFragmentById(android.R.id.list);
			
			if (lisFragment == null) {
				lisFragment = new RegionListFragment();
				fm.beginTransaction().add(android.R.id.list, lisFragment).commit();
				
			}
			
		}
		
	}
	
	

}
