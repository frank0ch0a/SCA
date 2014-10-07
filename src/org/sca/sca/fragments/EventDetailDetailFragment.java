package org.sca.sca.fragments;

import com.bienal2014.app.R;
import org.sca.sca.model.ActivitiesModel;
import org.sca.sca.model.ContestModel;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailDetailFragment extends Fragment {

	private static ActivitiesModel model;
	private Activity mActivity;

	public EventDetailDetailFragment(ActivitiesModel model) {
		EventDetailDetailFragment.model = model;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_event_detail_detail,
				container, false);

		ImageView m = (ImageView) rootView.findViewById(R.id.bg_contest);
		Picasso.with(mActivity).load(model.getmT03()).into(m);
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Regular.otf");
		Typeface tfLight = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Regular.otf");

		((TextView) rootView.findViewById(R.id.textViewTitleContest))
				.setText(model.getmTitle_activity());
		((TextView) rootView.findViewById(R.id.textViewTitleContest)).setTypeface(tf);
		
		((TextView)rootView.findViewById(R.id.textViewLugar)).setText("Lugar: " + model.getLocation_activity());
		
		((TextView)rootView.findViewById(R.id.textViewLugar)).setTypeface(tfLight);
		((TextView) rootView.findViewById(R.id.textViewDescripcion))
		
				.setText("Descripci—n: " + model.getmDesc_activity());
		((TextView)rootView.findViewById(R.id.textViewCiudad)).setText("Ciudad: Bucaramanga");
		((TextView)rootView.findViewById(R.id.textViewCiudad)).setTypeface(tfLight);
		
		((TextView) rootView.findViewById(R.id.textViewDescripcion)).setTypeface(tfLight);
		
		((TextView) rootView.findViewById(R.id.textViewFecha))
				.setText("Fecha: " + model.getmDate_n_activity());

		((TextView) rootView.findViewById(R.id.textViewFecha)).setTypeface(tfLight);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

}
