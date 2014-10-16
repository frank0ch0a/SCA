package org.sca.sca.controllers;

import org.sca.sca.fragments.ArchitectDetailFragment;
import org.sca.sca.fragments.RegionsDetailFragment;
import org.sca.sca.model.Architect;
import org.sca.sca.model.RegionModel;

import com.bienal2014.app.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class RegionDetailActivity extends Activity {
	private static RegionModel mRegion =null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		Bundle getBundle =this.getIntent().getExtras();
		mRegion=(RegionModel) getBundle.getSerializable("region");
		
		Fragment fragment = null;

		fragment = new RegionsDetailFragment(mRegion);

		if (fragment != null) {

			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

		}
		
		
		
	}
	
	

}
