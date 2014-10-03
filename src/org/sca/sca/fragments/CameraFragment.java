package org.sca.sca.fragments;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.sca.sca.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class CameraFragment extends Fragment {
	private static final String TAG = "CameraFragment";
	public static final String EXTRA_PHOTO_FILENAME ="org.sca.sca.photo_filename";
	private Camera mCamera;
	private SurfaceView mSurfaceView;
	private View mProgressContainer;
	
	
	private Camera.ShutterCallback mShutterCallBack = new Camera.ShutterCallback() {
		
		@Override
		public void onShutter() {
			//Display the progress indicator
			mProgressContainer.setVisibility(View.VISIBLE);
			
			
		}
	};
	
	private Camera.PictureCallback mJpegCallBack = new Camera.PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
		
			//Create FileName
			String filename  ="photo.jpg";
			//Save the jpeg data to disk
			FileOutputStream os = null;
			boolean success = true;
			try {
				os = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
				os.write(data);
			} catch (Exception e) {
				Log.e(TAG, "Error writing to file" + filename,e);
				success=false;
			}finally{
				
				try {
					
					if (os !=null) {
						os.close();
					}
				} catch (Exception e) {
					Log.e(TAG, "Error closing file" +filename,e);
					success=false;
					
				}
			}
			
			if (success) {
				Log.i(TAG, "JPEG saved at 	" + filename);
				//Set photo filename on the result intent
				Intent i = new Intent();
				i.putExtra(EXTRA_PHOTO_FILENAME, filename);
				getActivity().setResult(Activity.RESULT_OK, i);
				
			}else{
				getActivity().setResult(Activity.RESULT_CANCELED);
				
			}
			
			getActivity().finish();
		}
	};
	

	@Override
	@SuppressWarnings("deprecation")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		 View v = inflater.inflate(R.layout.fragment_camera, container,false);
		 
		 Button takePictureButton = (Button)v.findViewById(R.id.camera_takeButton);
		 mProgressContainer=v.findViewById(R.id.camera_progressContainer);
		 mProgressContainer.setVisibility(View.INVISIBLE);
		 takePictureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				//getActivity().finish();
				if (mCamera !=null) {
					
					mCamera.takePicture(mShutterCallBack, null, mJpegCallBack);
				}
				
			}
		});
		
		mSurfaceView =(SurfaceView)v.findViewById(R.id.camera_surfaceView);
		//setType() and SURFACE_TYPE_PUSH_BUFFERS are both deprecated,
				//but are required for Camera preview to work on pre 3.0 devices.
		SurfaceHolder holder = mSurfaceView.getHolder();
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		holder.addCallback(new SurfaceHolder.Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				//Tell the camera to use this surface as its preview area
				
				if (mCamera != null) {
					
					mCamera.stopPreview();
				}
			
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				
				try {
					if (mCamera !=null) {
						mCamera.setPreviewDisplay(holder);
					}
					
				} catch (Exception e) {
					
					Log.e(TAG, "Error setting up preview display",e);
				}
				
				
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
				
				if (mCamera == null) return;
					
				
				//The surface has changed size update the camera preview size 
				Camera.Parameters parameters = mCamera.getParameters();
				Size s =getBestSupportedSize(parameters.getSupportedPreviewSizes(), w, h);
				parameters.setPreviewSize(s.width, s.height);
				s= getBestSupportedSize(parameters.getSupportedPictureSizes(), w, h);
				parameters.setPictureSize(s.width, s.height);
				mCamera.setParameters(parameters);
				try {
					mCamera.startPreview();
				} catch (Exception e) {
					
					Log.e(TAG, "Could not start preview");
					mCamera.release();
					mCamera = null;
				}
						
				
						
				
				
			}
		});
		
		
		 return v;
	}


	
	
	
	@TargetApi(9)
	
	@Override
	public void onResume() {
		
		super.onResume();
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			
			mCamera =Camera.open(0);
		}else{
			
			mCamera =Camera.open();
		}
	}


@Override
	public void onPause() {
	
		super.onPause();
		
		if (mCamera !=null) {
			mCamera.release();
			mCamera = null;
		}
	}
	
	
/** a simple algorithm to get the largest size available. For a more 
 * robust version, see CameraPreview.java in the ApiDemos 
 * sample app from Android. */
private Size getBestSupportedSize(List<Size> sizes, int width, int height) {
    Size bestSize = sizes.get(0);
    int largestArea = bestSize.width * bestSize.height;
    for (Size s : sizes) {
        int area = s.width * s.height;
        if (area > largestArea) {
            bestSize = s;
            largestArea = area;
        }
    }
    return bestSize;
}
	

}
