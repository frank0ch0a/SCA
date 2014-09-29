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

public class ApiNewsConnection {
	
	private static ApiNewsConnection sInstance = null;
	private static final String apiURL = "http://sca.siie.co/api?";
	private static final String apiKey = "apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100";
	private List<News> mNews = null;
	public static ApiNewsConnection getInstance(String tp){
		
		
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


	public static ApiNewsConnection downloadData(String tp) throws MalformedURLException, IOException, JSONException {

			ApiNewsConnection apiConnect = new ApiNewsConnection();
			
			
			
			URLConnection conn = new URL(apiURL+tp+apiKey).openConnection();
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    StringBuilder response = new StringBuilder();
		    String line = null;
	        
	        while ((line = reader.readLine()) != null) {
	            response.append(line);
	        }

	        reader.close();

	        
	        
	        
	        
	        // Recorremos el array 
	        JSONObject jsonData = new JSONObject(response.toString());
	        
	        // Recorremos el array de regionales
	        JSONArray news = jsonData.getJSONArray("news");
	        
	        for (int i = 0; i < news.length(); i++) {
	        	
	        	String id_news= null;
	        	String title_news = null;
	        	String content_news = null;
	        	String date_news = null;
	        	String id_user_news = null;
	        	String name_user_news = null;
	        	String lastname_user_news= null;
	        	String hasimg_news= null;
	        	String extimg_news = null;
	        	String image = null;
	        	List<String> images = new LinkedList<String>();
	        	
	        	JSONObject jsonNews= news.getJSONObject(i);
	        	id_news= jsonNews.getString("id_news");
	        	title_news =  jsonNews.getString("title_news");
	        	content_news =  jsonNews.getString("content_news");
	        	date_news =  jsonNews.getString("date_news");
	        	id_user_news =  jsonNews.getString("id_user_news");
	        	name_user_news =  jsonNews.getString("name_user_news");
	        	lastname_user_news=  jsonNews.getString("lastname_user_news");
	        	hasimg_news=  jsonNews.getString("hasimg_news");
	        	extimg_news =  jsonNews.getString("extimg_news");
	        	
	        	if (jsonNews.has("img")) {
	        		images.add(jsonNews.getString("img"));
	        		JSONObject jsonImage= jsonNews.getJSONObject("img");
	        		if(jsonImage.has("t03"))
	        		{
	        			image = jsonImage.getString("t03");
	        		}
	        		
				}
	        			
	           
	        	apiConnect.mNews.add(new News(id_news,title_news ,content_news ,date_news ,id_user_news,name_user_news ,lastname_user_news,hasimg_news,extimg_news, images, image));
	        
			}
	        
	        
	        
	        Log.i("SCA", news.toString());
	        
	        
			
			
			
		
		return apiConnect;
	}
	
	private  ApiNewsConnection() {
		
	
		mNews = new LinkedList<News>();
	}
	
	
	
	public List<News> getNewsList() {
		return mNews;
	}
	
}
