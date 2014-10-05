package org.sca.sca.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ApiRegionConnection {

	private static ApiRegionConnection sInstance = null;
	private static final String apiURL = "http://sca.siie.co/api?";
	private static final String apiKey = "apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100";
	private List<Regions> mRegions = null;

	public static ApiRegionConnection getInstance(String tp) {

		if (sInstance == null) {

			try {
				sInstance = downloadData(tp);

			} catch (Exception e) {

				Log.e("SCA", "Error downloading data", e);
				return null;
			}
		}

		return sInstance;

	}

	public static ApiRegionConnection downloadData(String tp)
			throws MalformedURLException, IOException, JSONException {

		ApiRegionConnection apiConnect = new ApiRegionConnection();

		URLConnection conn = new URL(apiURL + tp + apiKey).openConnection();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StringBuilder response = new StringBuilder();
		String line = null;

		while ((line = reader.readLine()) != null) {
			response.append(line);
		}

		reader.close();

		// Recorremos el array
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
					image = "http://sca-events.s3.amazonaws.com"+jsonImage.getString("t03");
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

		return apiConnect;
	}

	private ApiRegionConnection() {

		mRegions = new LinkedList<Regions>();
	}

	public List<Regions> getRegionsList() {
		return mRegions;
	}

}
