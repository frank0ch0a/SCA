package org.sca.sca.fragments;

import org.sca.sca.R;
import org.sca.sca.controllers.CameraActivity;
import org.sca.sca.controllers.GalleryActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PhotoBoothFragment extends Fragment {
	private static final String TAG = "PhotoBooth";
	private static final int REQUEST_PHOTO =1;
	private static final int LOAD_PHOTO =2;
	private ImageButton mCameraButton;
	private ImageButton mGalleryButton;
	private ImageView mImageTaked;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_photobooth, container, false);
		
		mCameraButton =(ImageButton)v.findViewById(R.id.cameraButton);
		mGalleryButton =(ImageButton)v.findViewById(R.id.galleryButton);
		
		mImageTaked =(ImageView)v.findViewById(R.id.imageTaked);
		
		
		mCameraButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getActivity(),CameraActivity.class);
				//startActivity(i);
				startActivityForResult(i, REQUEST_PHOTO);
				
			}
		});
		
		mGalleryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i= new Intent(getActivity(),GalleryActivity.class);
				startActivityForResult(i, LOAD_PHOTO);
				
				
			}
		});
		
		//If Camera is not available, disable camera funcionality
		PackageManager pm= getActivity().getPackageManager();
		boolean hasACamera = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA) || 
				pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT) || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD 
				&& Camera.getNumberOfCameras() >0);
		
		if (!hasACamera) {
			mCameraButton.setEnabled(false);
		}
		
		
		return v;
		
		
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode != Activity.RESULT_OK)return; 
		
		if (requestCode == REQUEST_PHOTO) {
			
			String filename = data
					.getStringExtra(CameraFragment.EXTRA_PHOTO_FILENAME);
			
			if (filename !=null) {
				Log.i(TAG, "filename" + filename);
				
			}
			
		}
		
		
	}
	
	

}
