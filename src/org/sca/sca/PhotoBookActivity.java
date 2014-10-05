package org.sca.sca;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.sca.sca.fragments.CameraFragment;
import org.sca.sca.model.APIPhotoBookConnection;
import org.sca.sca.model.Photo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoBookActivity extends Activity {

	Button btnTakePhoto;
	ImageView ivPhoto;
	
	String foto;
	String mCurrentPhotoPath;
	
	Bitmap imageBitmap;
	File photoFile = null;
	double aleatorio=0;
	static final int REQUEST_IMAGE_CAPTURE = 1;
	static final int REQUEST_TAKE_PHOTO = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_book);
		
		ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
		btnTakePhoto = (Button) findViewById(R.id.btnTakePhoto);
		
		btnTakePhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				 if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
				        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
				    }		
				    
				//dispatchTakePictureIntent();
			}
		});
	}

	private File createImageFile() throws IOException {
	    // Create an image file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String imageFileName = "JPEG_" + timeStamp + "_";
	    File storageDir = Environment.getExternalStoragePublicDirectory(
	            Environment.DIRECTORY_PICTURES);
	    File image = File.createTempFile(
	        imageFileName,  /* prefix */
	        ".jpg",         /* suffix */
	        storageDir      /* directory */
	    );

	    // Save a file: path for use with ACTION_VIEW intents
	    mCurrentPhotoPath = "file:" + image.getAbsolutePath();
	    return image;
	}
	
	private void dispatchTakePictureIntent() {
	    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    // Ensure that there's a camera activity to handle the intent
	    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
	        // Create the File where the photo should go
	        
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
	private void setPic() {
	    // Get the dimensions of the View
	    int targetW = ivPhoto.getWidth();
	    int targetH = ivPhoto.getHeight();
	 
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
	    bmOptions.inSampleSize = scaleFactor;
	    bmOptions.inPurgeable = true;
	 
	    Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
	    ivPhoto.setImageBitmap(bitmap);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			setPic();
			
	        /*Bundle extras = data.getExtras();
	        imageBitmap = (Bitmap) extras.get("data");
	        
	        ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        imageBitmap.compress(Bitmap.CompressFormat.PNG, 70, stream); //compress to which format you want.
	        ivPhoto.setImageBitmap(imageBitmap);
	        
	       /*
		        
		    try {
		    	photoFile = createImageFile();
		    } catch (IOException ex) {
		            // Error occurred while creating the File

		    }
		        // Continue only if the File was successfully created
		    if (photoFile != null) {
		    	new Task().execute();
		    	
		    }
		*/
	        
	        //ivPhoto.setImageBitmap(imageBitmap);
	        
	        //
	    }
	}
	
	class Task extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog pd;
		@Override
		protected Void doInBackground(Void... params) {
			Log.e("SAFE PHOTO", "Dobackgroud");
			APIPhotoBookConnection.getInstance("tp=9&", photoFile, getApplicationContext());
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			//pd.dismiss();
			super.onPostExecute(result);
			pd.dismiss();
		}

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(getApplicationContext());
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.setCancelable(true);
			pd.setMessage("Esta Subiendo");
			pd.show();
			super.onPreExecute();
		}
		
	}
}
