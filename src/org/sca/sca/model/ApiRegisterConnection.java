package org.sca.sca.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.util.Token;

import android.content.Context;
import android.util.Log;

public class ApiRegisterConnection {
	
	private static ApiRegisterConnection sInstance = null;
	private static final String apiURL = "http://sca.siie.co/api?";
	private static final String apiKey = "apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100";
	private List<Regions> mRegions = null;
	
	
	public static ApiRegisterConnection getInstance(String tp, String name, String lastName, String passwd, String email, Context context) {

		if (sInstance == null) {

			try {
				sInstance = uploadData(tp, name, lastName, passwd, email, context);

			} catch (Exception e) {

				Log.e("SCA", "Error downloading data"+ e.getMessage());
				return null;
			}
		}

		return sInstance;

	}
	
	public static ApiRegisterConnection uploadData(String tp, String name, String lastName, String passwd, String email, Context context)
			throws MalformedURLException, IOException, JSONException {

		ApiRegisterConnection apiConnect = new ApiRegisterConnection();
		HttpClient client = new DefaultHttpClient();

		//URLConnection conn = new URL(apiURL + tp + apiKey).openConnection();

		/* objeto que permite enviar datos POST */
		HttpPost post = new HttpPost(apiURL + tp + apiKey);
		
		//A–ade los parametros 
		List<NameValuePair> params= new ArrayList<NameValuePair>();
	
		params.add(new BasicNameValuePair("name",name));
		params.add(new BasicNameValuePair("lastname",lastName));
		params.add(new BasicNameValuePair("password",passwd));
		params.add(new BasicNameValuePair("email",email));
		params.add(new BasicNameValuePair("_session", UUID.randomUUID().toString()));

	
		post.setEntity(new UrlEncodedFormEntity(params));
		
		HttpResponse response = client.execute(post);
		HttpEntity entity= response.getEntity();
		if(entity!=null){
		
			String s = EntityUtils.toString(entity).toString();
			JSONObject json = new JSONObject(s);
			
			JSONObject json1 = json.getJSONObject("_user");
			Log.e("SAFE", json.toString());
			if(json1.has("_token_a") && json1.has("_token_b")  && json1.has("_session"))
			{
				String token_a = json1.getString("_token_a");
				String token_b = json1.getString("_token_b");
				String session = json1.getString("_session");
				//Log.e("SAFE OK", json1.getString("_token_a")+" - "+json1.getString("_token_b")+" - "+json1.getString("_session"));
				Token.getTokenInitial(context).update(token_a, token_b, session);
			}
			/*
			if (json.has("access_token"))
			{
				return json.getString("access_token").toString();
			}*/
		} 
		/*else{
			return "";
		}*/

		// Recorremos el array
		/*
		JSONObject jsonData = new JSONObject(response.toString());

		// Recorremos el array de regionales
		JSONArray regions = jsonData.getJSONArray("regional");

		for (int i = 0; i < regions.length(); i++) {

			String id_reg = null;
			String name_reg = null;
			String abr_reg = null;
			String slug_reg = null;
			String dir_reg = null;
			String phone_reg = null;
			String city_reg = null;
			String country_reg = null;
			String district_reg = null;
			String lat_reg = null;
			String lon_reg = null;
			String id_person_reg = null;
			String name_person_reg = null;
			String lastname_person_reg = null;
			String hasimg_reg = null;
			String extimg_reg = null;
			String image = null;
			List<String> images = new LinkedList<String>();

			JSONObject jsonRegions = regions.getJSONObject(i);
			id_reg = jsonRegions.getString("id_reg");
			name_reg = jsonRegions.getString("name_reg");
			abr_reg = jsonRegions.getString("abr_reg");
			slug_reg = jsonRegions.getString("slug_reg");
			dir_reg = jsonRegions.getString("dir_reg");
			phone_reg = jsonRegions.getString("phone_reg");
			city_reg = jsonRegions.getString("city_reg");
			country_reg = jsonRegions.getString("country_reg");
			district_reg = jsonRegions.getString("district_reg");
			lat_reg = jsonRegions.getString("lat_reg");
			lon_reg = jsonRegions.getString("lon_reg");
			id_person_reg = jsonRegions.getString("id_person_reg");
			lastname_person_reg = jsonRegions.getString("lastname_person_reg");
			hasimg_reg = jsonRegions.getString("hasimg_reg");
			extimg_reg = jsonRegions.getString("extimg_reg");

			if (jsonRegions.has("img")) {
				images.add(jsonRegions.getString("img"));
				JSONObject jsonImage = jsonRegions.getJSONObject("img");
				if (jsonImage.has("t03")) {
					image = jsonImage.getString("big");
				}
			}

			apiConnect.mRegions
					.add(new Regions(id_reg, name_reg, abr_reg, slug_reg,
							dir_reg, phone_reg, city_reg, country_reg,
							district_reg, lat_reg, lon_reg, id_person_reg,
							lastname_person_reg, hasimg_reg, extimg_reg,
							images, image));

		}

		Log.i("SCA", regions.toString());
*/
		return apiConnect;
	}

	
}
