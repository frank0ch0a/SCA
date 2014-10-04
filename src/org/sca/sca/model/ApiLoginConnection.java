package org.sca.sca.model;

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
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.util.Token;

import android.content.Context;
import android.util.Log;

public class ApiLoginConnection {
	
	private static ApiRegisterConnection sInstance = null;
	private static final String apiURL = "http://sca.siie.co/api?";
	private static final String apiKey = "apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100";

	
	
	public static ApiRegisterConnection getInstance(String tp, String email, String passwd, Context context) {

		//if (sInstance == null) {

			try {
				sInstance = uploadData(tp, email, passwd, context);

			} catch (Exception e) {

				Log.e("SCA", "Error downloading data"+ e.getMessage());
				return null;
			}
		//}

		return sInstance;

	}
	
	public static ApiRegisterConnection uploadData(String tp, String email, String passwd, Context context)
			throws MalformedURLException, IOException, JSONException {

		ApiRegisterConnection apiConnect = new ApiRegisterConnection();
		HttpClient client = new DefaultHttpClient();

		//URLConnection conn = new URL(apiURL + tp + apiKey).openConnection();

		/* objeto que permite enviar datos POST */
		HttpPost post = new HttpPost(apiURL + tp + apiKey);
		
		//A–ade los parametros 
		List<NameValuePair> params= new ArrayList<NameValuePair>();
	
		params.add(new BasicNameValuePair("_ualias",email));
		params.add(new BasicNameValuePair("_upassw",passwd));
		params.add(new BasicNameValuePair("_session",UUID.randomUUID().toString()));

	
		post.setEntity(new UrlEncodedFormEntity(params));
		
		HttpResponse response = client.execute(post);
		HttpEntity entity= response.getEntity();
		if(entity!=null){
		
			String s = EntityUtils.toString(entity).toString();
			JSONObject json = new JSONObject(s);
			Log.e("SAFE-APILOGIN", json.toString());
			if(json.has("err")){
				Token.getTokenInitial(context).update("None", "None", "None");
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

