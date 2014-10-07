package org.sca.sca.controllers;

import com.bienal2014.app.R;

import org.sca.sca.fragments.PhotoBoothFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class PhotoBoothActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		Fragment fragment = null;

		fragment = new PhotoBoothFragment();

		if (fragment != null) {

			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

		}
	}
	
	
	

}
