package org.sca.sca.fragments;

import org.sca.sca.LoginActivity;
import com.bienal2014.app.R;
import org.sca.sca.util.Token;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		Button btnCloseSession;
		
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
         
        btnCloseSession = (Button) rootView.findViewById(R.id.btnCloseSession);
        
        btnCloseSession.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Token.getTokenInitial(getActivity()).update("None", "None", "None");
				Intent i = new Intent(getActivity(), LoginActivity.class);
				startActivity(i);
				getActivity().finish();
			}
		});
        
        return rootView;
    }
}
