package org.sca.sca.controllers;

import org.sca.sca.R;
import org.sca.sca.fragments.EventDetailFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class EventDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		Fragment fragment = null;
		
		fragment = new EventDetailFragment();
		
if (fragment != null) {
			
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			
		}
	}
	
	
	

}
