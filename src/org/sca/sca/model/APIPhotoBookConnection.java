package org.sca.sca.model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.util.Token;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;


	public class APIPhotoBookConnection {
		
		private static APIPhotoBookConnection sInstance = null;
		private static final String apiURL = "http://sca.siie.co/api?";
		private static final String apiKey = "apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100";

		
		
		public static APIPhotoBookConnection getInstance(String tp, File photo, Context context) {

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
		
		public static APIPhotoBookConnection uploadData(String tp, File photo, Context context)
				throws MalformedURLException, IOException, JSONException { 

			APIPhotoBookConnection apiConnect = new APIPhotoBookConnection();
			
			try {
                HttpClient httpclient = new DefaultHttpClient();
                httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
                HttpPost httppost = new HttpPost(apiURL+tp+apiKey);
               
                MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
                multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("_token_a", new StringBody(Token.getTokenInitial(context).getToken_a()));
                multipartEntity.addPart("_token_b", new StringBody(Token.getTokenInitial(context).getToken_b()));
                multipartEntity.addPart("_session", new StringBody(Token.getTokenInitial(context).getSession()));
                multipartEntity.addPart("id_frame_event", new StringBody("3"));
                multipartEntity.addPart("loc", new StringBody("7.5324235 -45.234232"));
                multipartEntity.addPart("photo", new FileBody(photo));
                
                
                httppost.setEntity((HttpEntity) multipartEntity);
                HttpResponse response = httpclient.execute(httppost);
                
                HttpEntity entity= response.getEntity();
                if(entity!=null){
            		
        			String s = EntityUtils.toString(entity).toString();
        			Log.e("SAFE Return Service", s);
                }
                
                httpclient.getConnectionManager().shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }


			return apiConnect;
		}

		
	}



