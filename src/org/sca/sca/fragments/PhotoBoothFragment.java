package org.sca.sca.fragments;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.sca.sca.MainActivity;
import org.sca.sca.R;
import org.sca.sca.controllers.CameraActivity;
import org.sca.sca.controllers.GalleryActivity;
import org.sca.sca.model.APIPhotoBookConnection;
import org.sca.sca.model.Photo;
import org.sca.sca.model.RegionModel;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoBoothFragment extends Fragment {
	private static final String TAG = "PhotoBooth";
	private static final int REQUEST_PHOTO =1;
	private static final int LOAD_PHOTO =2;

	private ImageButton mCameraButton;
	private ImageButton mGalleryButton;
	private ImageView mImageTaked;
	private RegionModel mRegion;
	private String photoUrl;

	

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
				
				/*
				Intent i = new Intent(getActivity(),CameraActivity.class);
				//startActivity(i);
				startActivityForResult(i, REQUEST_PHOTO);*/
				
				takePhoto();

				
			}
		});
		
		mGalleryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				Intent i= new Intent(getActivity(),GalleryActivity.class);
				startActivityForResult(i, LOAD_PHOTO);
				*/
				
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
	
	private void takePhoto() {
//		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
//		startActivityForResult(intent, 0);
		dispatchTakePictureIntent();
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		Log.i(TAG, "onActivityResult: " + this);
		if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
			setPic();
//			Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//			if (bitmap != null) {
//				mImageView.setImageBitmap(bitmap);
//				try {
//					sendPhoto(bitmap);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
	}
		/*Log.e("SAFE PHOTO", requestCode+" - "+REQUEST_PHOTO+data);
		if (requestCode != Activity.RESULT_OK)
			return; 
		
		if (requestCode == REQUEST_PHOTO) {
			

			String filename = data
					.getStringExtra(CameraFragment.EXTRA_PHOTO_FILENAME);

			
			Log.e("SAFE PHOTO", filename);
			 
			if (filename != null) {
				Log.i(TAG, "filename" + filename);
				Photo p = new Photo (filename);
				mRegion.setPhoto(p);
				photoUrl= mRegion.getPhoto().getFilename();
				Log.e("SAFE PHOTO", "Task");
				new Task().execute();
				Log.e("SAFE PHOTO", "DespuesTask");
				
			}
			
		}
		
		
	}
	

	class Task extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog pd;
		@Override
		protected Void doInBackground(Void... params) {
			Log.e("SAFE PHOTO", "Dobackgroud");
			APIPhotoBookConnection.getInstance("tp=9&", photoUrl, getActivity());
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			pd.dismiss();
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(getActivity());
			pd.setCancelable(true);
			pd.setMessage("Esta Subiendo");
			pd.show();
			super.onPreExecute();
		}
		
	}*/
	private void sendPhoto(Bitmap bitmap) throws Exception {
		new UploadTask().execute(bitmap);
	}

	private class UploadTask extends AsyncTask<Bitmap, Void, Void> {
		
		protected Void doInBackground(Bitmap... bitmaps) {
			if (bitmaps[0] == null)
				return null;
		//	setProgress(0);
			
			Bitmap bitmap = bitmaps[0];
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream); // convert Bitmap to ByteArrayOutputStream
			InputStream in = new ByteArrayInputStream(stream.toByteArray()); // convert ByteArrayOutputStream to ByteArrayInputStream

			DefaultHttpClient httpclient = new DefaultHttpClient();
			try {
				HttpPost httppost = new HttpPost(
						"http://sca.siie.co/api"); // server

				org.sca.sca.controllers.MultipartEntity reqEntity = new org.sca.sca.controllers.MultipartEntity();
				reqEntity.addPart("photo",
						System.currentTimeMillis() + ".jpg", in);
				reqEntity.addPart("_token_a", "adafadfasdfasssdfasdff");
				reqEntity.addPart("_token_b", "adddddas44fffsdfasdfasdff");
				reqEntity.addPart("tp", "9");
				reqEntity.addPart("apikey", "2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");
				reqEntity.addPart("loc", "7.5324235 -45.234232");
				reqEntity.addPart("id_frame_event", "3");
				
			
				
				httppost.setEntity(reqEntity);

				Log.i(TAG, "request " + httppost.getRequestLine());
				HttpResponse response = null;
				try {
					response = httpclient.execute(httppost);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (response != null)
						Log.i(TAG, "response " + response.getStatusLine().toString());
				} finally {

				}
			} finally {

			}

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return null;
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			//Toast.makeText(this,"Uploaded", Toast.LENGTH_LONG).show();
			Log.i(TAG, "uploaded");
		}
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "onResume: " + this);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState");
	}
	
	
	
	String mCurrentPhotoPath;
	
	static final int REQUEST_TAKE_PHOTO = 1;
	File photoFile = null;

	private void dispatchTakePictureIntent() {
	    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    // Ensure that there's a camera activity to handle the intent
	    if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
	        // Create the File where the photo should go
	        File photoFile = null;
	        try {
	            photoFile = createImageFile();
	        } catch (IOException ex) {
	            // Error occurred while creating the File

	        }
	        // Continue only if the File was successfully created
	        if (photoFile != null) {
	            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
	            		Uri.fromFile(photoFile));
	            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
	        }
	    }
	}

	/**
	 * http://developer.android.com/training/camera/photobasics.html
	 */
	private File createImageFile() throws IOException {
	    // Create an image file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String imageFileName = "photo";
	    String storageDir = Environment.getExternalStorageDirectory() + "/SCA";
	    File dir = new File(storageDir);
	    if (!dir.exists())
	    	dir.mkdir();
	    
	    File image = new File(storageDir + "/" + imageFileName + ".jpg");

	    // Save a file: path for use with ACTION_VIEW intents
	    mCurrentPhotoPath = image.getAbsolutePath();
	    Log.i(TAG, "photo path = " + mCurrentPhotoPath);
	    return image;
	}
	
	private void setPic() {
		// Get the dimensions of the View
	    int targetW = mImageTaked.getWidth();
	    int targetH = mImageTaked.getHeight();

	    // Get the dimensions of the bitmap
	    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	    bmOptions.inJustDecodeBounds = true;
	    BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
	    int photoW = bmOptions.outWidth;
	    int photoH = bmOptions.outHeight;

	    // Determine how much to scale down the image
	    int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

	    // Decode the image file into a Bitmap sized to fill the View
	    bmOptions.inJustDecodeBounds = false;
	    bmOptions.inSampleSize = scaleFactor << 1;
	    bmOptions.inPurgeable = true;

	    Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
	    
	    Matrix mtx = new Matrix();
	    mtx.postRotate(90);
	    // Rotating Bitmap
	    Bitmap rotatedBMP = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), mtx, true);

	    if (rotatedBMP != bitmap)
	    	bitmap.recycle();
	    
	    mImageTaked.setImageBitmap(rotatedBMP);
	    
	    try {
			sendPhoto(rotatedBMP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
