package org.sca.sca.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class ImageL {
	
	ImageView image;
	String url;

	public ImageL(String url, ImageView view)
	{
		this.image = view;
		this.url = url;
		new loadImage().execute(this.url);
	}
	
	private Bitmap descargarImagen (String imageHttpAddress){
	    URL imageUrl = null;
	    Bitmap imagen = null;
	    try{
	        imageUrl = new URL(imageHttpAddress);
	        HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
	        conn.connect();
	        imagen = BitmapFactory.decodeStream(conn.getInputStream());
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
	     
	    return imagen;
	}
	
	class loadImage extends AsyncTask<String, Void, Bitmap>{

		@Override
		protected Bitmap doInBackground(String... params) {
			
			return descargarImagen(params[0]);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			image.setImageBitmap(result);
		}
		
	}
	
}
