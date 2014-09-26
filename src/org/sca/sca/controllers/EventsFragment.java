package org.sca.sca.controllers;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.util.ImageL;
import org.sca.sca.util.Network;

public class EventsFragment extends Fragment{
	
	JSONObject jsonO;
	String urlImgBig;
	String jdescription;
	
	ImageView imageBig;
	TextView description;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        
        imageBig = (ImageView) rootView.findViewById(R.id.imageBigEvents);
        description = (TextView) rootView.findViewById(R.id.txtDescription);
        
        
        new Task().execute();
        
        
         
        return rootView;
    }
	
	class Task extends AsyncTask<Void, Void, Void>{

	
		
		@Override
		protected Void doInBackground(Void... params) {
			loadData();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
		
			data(jsonO);
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			
			super.onPreExecute();
		}
		
	}
	
	public void loadData(){
		Network net = new Network();
		jsonO= net.getDataJSONObject("http://sca.siie.co/api?tp=8&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");
		
	}
	
	public void data(JSONObject obj)
	{
		
		try {
			JSONArray array= obj.getJSONArray("event");
			for(int i =0; i<array.length(); i++)
			{
				JSONObject json = array.getJSONObject(i);
				JSONObject jimageBig = json.getJSONObject("img");
				
				urlImgBig= jimageBig.getString("big");
				jdescription = json.getString("desc_event");
			}
			 
			
			new ImageL("http://sca-events.s3.amazonaws.com"+urlImgBig, imageBig, getActivity());
			description.setText(jdescription);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
