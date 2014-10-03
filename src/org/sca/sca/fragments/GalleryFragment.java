package org.sca.sca.fragments;

import org.sca.sca.R;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class GalleryFragment extends Fragment {
	public static int RESULT_LOAD_IMAGE = 1;
	
	private ImageView mImageGallery;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v =inflater.inflate(R.layout.fragment_gallery, container,false);
		mImageGallery =(ImageView)v.findViewById(R.id.imageGallery);
		Button mLoadImageBtn =(Button)v.findViewById(R.id.galleryButton);
		mLoadImageBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent i = new Intent(
	                        Intent.ACTION_PICK,
	                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	                 
	                startActivityForResult(i, RESULT_LOAD_IMAGE);
				    
			
	               
				
			}
		});
		
		
		return v;
		
	}

	
			
	

}
