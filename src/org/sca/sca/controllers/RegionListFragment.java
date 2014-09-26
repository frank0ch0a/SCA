package org.sca.sca.controllers;

import java.util.List;

import org.sca.sca.R;
import org.sca.sca.model.ApiRegionConnection;
import org.sca.sca.model.Regions;



import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RegionListFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		 super.onCreateView(inflater, container, savedInstanceState);
		 
		 
		 View root = inflater.inflate(R.layout.fragment_list_regions, container, false);
		 
		 
		 AsyncTask<Object, Integer, ApiRegionConnection> downloadRegions = new AsyncTask<Object, Integer, ApiRegionConnection>(){

			@Override
			protected ApiRegionConnection doInBackground(Object... params) {
				
				
				return ApiRegionConnection.getInstance("tp=4&");
			}

			@Override
			protected void onPostExecute(ApiRegionConnection apiregionconnection) {
				
				ListView listView = (ListView)getView().findViewById(android.R.id.list);
				RegionListAdapter adapter = new RegionListAdapter(getActivity(), apiregionconnection.getRegionsList());
				listView.setAdapter(adapter);
				
				/*
				ArrayAdapter<Regions> adapter = new ArrayAdapter<Regions>(getActivity(), android.R.layout.simple_list_item_1, apiregionconnection.getRegionsList());
				listView.setAdapter(adapter);*/
				//listView.setOnItemClickListener((OnItemClickListener)getActivity());
				
			}
			 
			 };
		 
		 downloadRegions.execute();
		 
		 
		 return root;
		 
		 
	}
	
	
	class RegionListAdapter extends ArrayAdapter<Regions>{

		public RegionListAdapter(Context context, List<Regions> regionList) {
			super(context,R.layout.regions_layout,regionList);
			
		}
			public View getView(int position, View convertView, ViewGroup parent) {
				
				// Usamos el inflater para sacar nuestro layout
				LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				View regionRow = inflater.inflate(R.layout.regions_layout, parent,false);
				
				TextView nameReg =(TextView)regionRow.findViewById(R.id.title_reg_textView);
		
				
				 // Obtenemos nuestro modelo para rellenar con la información de esta fila
			    Regions currentRegion = getItem(position);
				
				
				
				nameReg.setText(currentRegion.getName_rege());
				
				return regionRow;
				
			}
			
			
			
		}
		
		
		
		
		

	

}




