package org.sca.sca;

import java.io.File;

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
	double aleatorio=0;
	final int TAKE_PICTURE=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_book);
		
		ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
		btnTakePhoto = (Button) findViewById(R.id.btnTakePhoto);
		
		btnTakePhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				aleatorio = new Double(Math.random() * 100).intValue();
				foto = Environment.getExternalStorageDirectory() + "/imagen"+ aleatorio +".jpg";
				
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		        Uri output = Uri.fromFile(new File(foto));
		        intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
		        startActivityForResult(intent, TAKE_PICTURE);				
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (resultCode != Activity.RESULT_CANCELED) {
		
		//ivPhoto.setImageBitmap(BitmapFactory.decodeFile(foto));
		File file = new File(foto);
		
		if (file.exists()) {
			Task nuevaTarea = new Task();
            nuevaTarea.execute();
        }
        else
            Toast.makeText(getApplicationContext(), "No se ha realizado la foto", Toast.LENGTH_SHORT).show();
		
		}
		else
		{
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
	
	class Task extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog pd;
		@Override
		protected Void doInBackground(Void... params) {
			Log.e("SAFE PHOTO", "Dobackgroud");
			APIPhotoBookConnection.getInstance("tp=9&", foto, getApplicationContext());
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
