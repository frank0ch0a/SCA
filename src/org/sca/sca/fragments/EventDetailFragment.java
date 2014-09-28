package org.sca.sca.fragments;

import org.sca.sca.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class EventDetailFragment extends Fragment {
	
	private ImageView mImageEventBG = null;
	private ListView mEventList = null;
	private Button mEventDay1Btn = null;
	private Button mEventDay2Btn = null;
			
	
public EventDetailFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_detail_events, container, false);
        
        mImageEventBG =(ImageView)rootView.findViewById(R.id.imageView1);
        mEventList =(ListView)rootView.findViewById(R.id.listView1);
        mEventDay1Btn =(Button)rootView.findViewById(R.id.event_day1);
        mEventDay2Btn=(Button)rootView.findViewById(R.id.event_day2);
         
        return rootView;
    }

}
