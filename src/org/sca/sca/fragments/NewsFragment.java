package org.sca.sca.fragments;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.sca.sca.R;
import org.sca.sca.model.ApiNewsConnection;
import org.sca.sca.model.News;
import org.sca.sca.util.ImageL;

@SuppressLint("NewApi")
public class NewsFragment extends Fragment {
	
	public NewsFragment(){}
	
	ListView listNews;
	 
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        listNews = (ListView) rootView.findViewById(R.id.listViewNews);
        
        AsyncTask<Object, Integer, ApiNewsConnection> downloadNews = new AsyncTask<Object, Integer, ApiNewsConnection>()
        {

			@Override
			protected ApiNewsConnection doInBackground(Object... params) {
				
				return ApiNewsConnection.getInstance("tp=6&");
			}
			
			@Override
			protected void onPostExecute(ApiNewsConnection apinewsconnection) {
				
				NewsListAdapter adapter = new NewsListAdapter(getActivity(), apinewsconnection.getNewsList());
				listNews.setAdapter(adapter);
				
				
			}
        	
        };
        
        downloadNews.execute();
         
        
        return rootView;
    }
	
	class NewsListAdapter extends ArrayAdapter<News>{

		TextView title;
		TextView content_news;
		ImageView image;
		
		public NewsListAdapter(Context context, List<News> newsList) {
			super(context,R.layout.news_layout,newsList);
			
		}
		public View getView(int position, View newsRow, ViewGroup parent) {
				
				final HolderAdapter holder;
				
				// Usamos el inflater para sacar nuestro layout
				LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				
				
				if(newsRow == null)
				{
					holder = new HolderAdapter();
					newsRow = inflater.inflate(R.layout.news_layout, null);
					holder.title = (TextView) newsRow.findViewById(R.id.textViewTitleNews);
					holder.content_news =(TextView) newsRow.findViewById(R.id.textViewNews);
					holder.image = (ImageView) newsRow.findViewById(R.id.imageViewNews);
					
					newsRow.setTag(holder);
				}
				else
				{
					holder = (HolderAdapter) newsRow.getTag();
				}
				
				
				 // Obtenemos nuestro modelo para rellenar con la información de esta fila
			    News currentNews = getItem(position);
			   
			    holder.title.setText(currentNews.getTitle_news());
			    holder.content_news.setText(currentNews.getContent_news());
			    if(currentNews.getImg().get(0)!= null)
			    	Log.e("SAFE", currentNews.getImg().get(0));
			    	new ImageL(currentNews.getImage(), holder.image, getContext());
				return newsRow;
				
		}
			
		
		
			
	}
	
	private static class HolderAdapter
	{
		public TextView title;
		public TextView content_news;
		public ImageView image;

	}
	
	
}
