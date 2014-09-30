package org.sca.sca.fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.controllers.EventDetailActivity;
import org.sca.sca.util.ImageL;
import org.sca.sca.util.Network;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventsFragment extends Fragment {

	public static JSONObject jsonO;
	String urlImgBig;
	String jdescription;

	ImageView imageBig;
	TextView description;
	Button scheduleBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_events, container,
				false);

		imageBig = (ImageView) rootView.findViewById(R.id.imageBigEvents);
		description = (TextView) rootView.findViewById(R.id.txtDescription);
		scheduleBtn = (Button) rootView.findViewById(R.id.btnCronograma);

		scheduleBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Log.e("Pacho", "click cronograma btn");

				Intent i = new Intent(getActivity(), EventDetailActivity.class);

				startActivity(i);

			}
		});

		new Task().execute();

		return rootView;
	}

	class Task extends AsyncTask<Void, Void, Void> {

		final ProgressDialog pd = new ProgressDialog(getActivity());

		@Override
		protected Void doInBackground(Void... params) {
			loadData();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			data(jsonO);
			if (pd != null && pd.isShowing()) {
				pd.dismiss();
			}
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd.setMessage("Obteniendo información. Por favor espere.");
			pd.setCancelable(false);
			pd.show();
		}

	}

	public void loadData() {
		Network net = new Network();
		jsonO = net
				.getDataJSONObject("http://sca.siie.co/api?tp=8&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");

	}

	public void data(JSONObject obj) {

		try {
			JSONArray array = obj.getJSONArray("event");
			for (int i = 0; i < array.length(); i++) {
				JSONObject json = array.getJSONObject(i);
				JSONObject jimageBig = json.getJSONObject("img");

				urlImgBig = jimageBig.getString("big");
				jdescription = json.getString("desc_event");
			}
			new ImageL("http://sca-events.s3.amazonaws.com" + urlImgBig,
					imageBig, getActivity());
			description.setText(jdescription);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}
