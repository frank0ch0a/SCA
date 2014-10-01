package org.sca.sca.fragments;

import org.sca.sca.R;
import org.sca.sca.model.ActivitiesModel;
import org.sca.sca.model.ContestModel;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
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

		ImageView m = (ImageView) rootView.findViewById(R.id.imageViewContest);
		Picasso.with(mActivity).load(model.getmT03()).into(m);

		((TextView) rootView.findViewById(R.id.textViewTitleContest))
				.setText(model.getmTitle_activity());
		((TextView) rootView.findViewById(R.id.textViewDescripcion))
				.setText("Descripción: " + model.getmDesc_activity());
		((TextView) rootView.findViewById(R.id.textViewFecha))
				.setText("Fecha: " + model.getmDate_n_activity());

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

}
