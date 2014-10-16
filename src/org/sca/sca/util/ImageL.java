package org.sca.sca.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.bienal2014.app.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class ImageL {
	
	ImageView image;
	String url;
	Context context;
	String name;

	public ImageL(String url, ImageView view, Context context)
	{
		this.image = view;
		this.url = url;
		this.context= context;
		
		String []names= url.split("/");
		Log.e("SAFE-IMAGEL", names[names.length-1]);
		this.name= names[names.length-1];
		new loadImage().execute(this.url);
	}
	
	private Bitmap descargarImagen (String imageHttpAddress){
	    URL imageUrl = null;
	    Bitmap imagen = null;
	    
	    File imageFile = new File(context.getCacheDir(), name);
	    
	    if(imageFile.exists())
	    {
	    	imagen = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
	    	return imagen;
	    }
	    
	    try{
	        imageUrl = new URL(imageHttpAddress);
	        HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
	        conn.setDoInput(true);
	        conn.connect();
	        
	        InputStream input = conn.getInputStream();
	        if(input != null) Log.e("SAFE tAG", "Input - Diferente de null");
	        imagen = BitmapFactory.decodeStream(input);
	        
	        if(imagen != null) Log.e("SAFE tAG", "Imagen Diferente de null");
	        
	        if(imagen!=null){
	        	FileOutputStream file = new FileOutputStream(imageFile);
		        imagen.compress(CompressFormat.PNG, 70, file);
		        file.close();
	        }
	        
	        
	        
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
	     
	    return imagen;
	}
	
	class loadImage extends AsyncTask<String, Void, Bitmap>{

		ProgressDialog progressDialog;
		
		@Override
		protected Bitmap doInBackground(String... params) {
			
			return descargarImagen(params[0]);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			//progressDialog.dismiss();
			super.onPostExecute(result);
			image.setImageBitmap(result);
		}

		@Override
		protected void onPreExecute() {
			/*
			progressDialog = new ProgressDialog(context);
	        progressDialog.show();        
	        progressDialog.setContentView(R.layout.dialog);
	        //se ppdr‡ cerrar simplemente pulsando back
	        progressDialog.setCancelable(true);*/
			super.onPreExecute();
		}
		
	}
	
}
