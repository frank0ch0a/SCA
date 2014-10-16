package org.sca.sca.controllers;

import org.sca.sca.fragments.ArchitectDetailFragment;
import org.sca.sca.model.Architect;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.bienal2014.app.R;

public class ArchitectDetailActivity extends Activity {
	private static Architect architect;
	
	/*
	public ArchitectDetailActivity(Architect architect){
		
		ArchitectDetailActivity.architect=architect;
	}*/
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		Bundle getBundle =this.getIntent().getExtras();
		architect=(Architect) getBundle.getSerializable("architect");
		Fragment fragment = null;

		fragment = new ArchitectDetailFragment(architect);

		if (fragment != null) {

			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

		}
		
		
	}
	
	
	

}
