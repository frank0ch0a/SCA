package org.sca.sca.fragments;

import com.bienal2014.app.R;
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

public class CompetitionDetailFragment extends Fragment {

	private static ContestModel model;
	private Activity mActivity;

	public CompetitionDetailFragment(ContestModel model) {
		CompetitionDetailFragment.model = model;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_competition_detail,
				container, false);
		
		Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Regular.otf");
		Typeface tfLight = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Light.otf");

		ImageView m = (ImageView) rootView.findViewById(R.id.bg_contest);
		Picasso.with(mActivity).load(model.getmT03()).into(m);

		((TextView) rootView.findViewById(R.id.textViewTitleContest))
				.setText(model.getmName_contest());
		((TextView) rootView.findViewById(R.id.textViewTitleContest)).setTypeface(tf);
		
		
		((TextView) rootView.findViewById(R.id.textViewDescripcion))
				.setText("Descripción: " + model.getmDesc_contest());
		((TextView) rootView.findViewById(R.id.textViewDescripcion)).setTypeface(tfLight);
		
		((TextView) rootView.findViewById(R.id.textViewFecha)).setText("Hora: "
				+ model.getmDate_pi_contest() + " a "
				+ model.getmDate_pf_contest());
		
		((TextView) rootView.findViewById(R.id.textViewFecha)).setTypeface(tfLight);

		((Button) rootView.findViewById(R.id.buttonVer))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent i = new Intent(Intent.ACTION_VIEW);
						i.setData(Uri.parse(model.getmUrl_contest()));
						startActivity(i);
					}
				});

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

}
