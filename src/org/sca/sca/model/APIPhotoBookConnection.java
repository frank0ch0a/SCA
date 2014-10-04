package org.sca.sca.model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.util.Token;

import android.content.Context;
import android.util.Log;


	public class APIPhotoBookConnection {
		
		private static APIPhotoBookConnection sInstance = null;
		private static final String apiURL = "http://sca.siie.co/api?";
		private static final String apiKey = "apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100";

		
		
		public static APIPhotoBookConnection getInstance(String tp, String photo, Context context) {

			//if (sInstance == null) {

				try {
					sInstance = uploadData(tp, photo, context);

				} catch (Exception e) {

					Log.e("SCA", "Error downloading data"+ e.getMessage());
					return null;
				}
			//}

			return sInstance;

		}
		
		public static APIPhotoBookConnection uploadData(String tp, String photo, Context context)
				throws MalformedURLException, IOException, JSONException {

			APIPhotoBookConnection apiConnect = new APIPhotoBookConnection();
			HttpClient client = new DefaultHttpClient();
			
			//URLConnection conn = new URL(apiURL + tp + apiKey).openConnection();

			/* objeto que permite enviar datos POST */
			HttpPost post = new HttpPost(apiURL + tp + apiKey);
			post.setHeader("Accept", "application/json");
			
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setCharset(MIME.UTF8_CHARSET);
			FileBody bin = new FileBody(new File(photo));
			
			
		
			//A–ade los parametros 
		
			builder.addTextBody("_token_a", Token.getTokenInitial(context).getToken_a(), ContentType.create("text/plain", MIME.UTF8_CHARSET));
			builder.addTextBody("_token_b", Token.getTokenInitial(context).getToken_b(), ContentType.create("text/plain", MIME.UTF8_CHARSET));
			builder.addTextBody("_session", Token.getTokenInitial(context).getSession(), ContentType.create("text/plain", MIME.UTF8_CHARSET));
			builder.addTextBody("id_frame_event", "3", ContentType.create("text/plain", MIME.UTF8_CHARSET));
			builder.addTextBody("loc", "7.5324235 -45.234232", ContentType.create("text/plain", MIME.UTF8_CHARSET));
			builder.addPart("photo", bin);
			/*
			List<NameValuePair> params= new ArrayList<NameValuePair>();
		
			params.add(new BasicNameValuePair("_token_a",Token.getTokenInitial(context).getToken_a()));
			params.add(new BasicNameValuePair("_token_b",Token.getTokenInitial(context).getToken_b()));
			params.add(new BasicNameValuePair("_session",Token.getTokenInitial(context).getSession()));
			params.add(new BasicNameValuePair("id_frame_event", "3"));
			params.add(new BasicNameValuePair("loc","7.5324235 -45.234232"));
			params.add(new BasicNameValuePair("photo",passwd));
*/
			post.setEntity(builder.build());
			
			HttpResponse response = client.execute(post);
			HttpEntity entity= response.getEntity();
			if(entity!=null){
			
				String s = EntityUtils.toString(entity).toString();
				JSONObject json = new JSONObject(s);
				Log.e("SAFE-APILOGIN", json.toString());
				if(json.has("err")){
					Token.getTokenInitial(context).update("", "", "");
				}else{
					JSONObject json1 = json.getJSONObject("_user");
					
					if(json1.has("_token_a") && json1.has("_token_b")  && json1.has("_session"))
					{
						String token_a = json1.getString("_token_a");
						String token_b = json1.getString("_token_b");
						String session = json1.getString("_session");
						Log.e("SAFE OK Login", json1.getString("_token_a")+" - "+json1.getString("_token_b")+" - "+json1.getString("_session"));
						Token.getTokenInitial(context).update(token_a, token_b, session);
					}
				}
				
			} 


			return apiConnect;
		}

		
	}



