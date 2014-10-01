package org.sca.sca.fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.model.ActivitiesModel;
import org.sca.sca.model.Architect;
import org.sca.sca.model.RegionModel;
import org.sca.sca.util.Network;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArchitectDetailFragment extends Fragment {

	private static Architect architect;
	private Activity mActivity;
	private LinearLayout mImagenes;

	public ArchitectDetailFragment(Architect architect) {
		ArchitectDetailFragment.architect = architect;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		View root = inflater.inflate(R.layout.fragment_architect_detail,
				container, false);

		((TextView) root.findViewById(R.id.textViewName)).setText(architect
				.getName_person() + " " + architect.getLastname_person());
		((TextView) root.findViewById(R.id.textViewCity)).setText(architect
				.getCity());

		((TextView) root.findViewById(R.id.textViewBio)).setText(architect
				.getBio_person());

		Picasso.with(mActivity).load(architect.getBig())
				.into((ImageView) root.findViewById(R.id.imageViewArchitect));

		mImagenes = (LinearLayout) root.findViewById(R.id.LinearLayoutImagenes);

		new Task().execute();
		return root;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

	class Task extends AsyncTask<Void, Void, JSONObject> {

		final ProgressDialog pd = new ProgressDialog(getActivity());

		@Override
		protected JSONObject doInBackground(Void... params) {
			return loadData();

		}

		@Override
		protected void onPostExecute(JSONObject result) {
			super.onPostExecute(result);

			if (pd != null && pd.isShowing()) {
				pd.dismiss();
			}
			data(result);

		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd.setMessage("Obteniendo información. Por favor espere.");
			pd.setCancelable(false);
			pd.show();
		}

	}

	public JSONObject loadData() {
		Network net = new Network();
		// data(net.getDataJSONObject("http://sca.siie.co/api?tp=5&id_person="
		// + architect.getId_person()
		// + "&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100"));
		return net.getDataJSONObject("http://sca.siie.co/api?tp=5&id_person="
				+ architect.getId_person()
				+ "&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");

	}

	private void data(JSONObject obj) {
		System.out.println(obj);
		try {
			JSONArray person = obj.getJSONArray("person");
			JSONObject info = person.getJSONObject(0);
			JSONArray work = info.getJSONArray("work");
			for (int i = 0; i < work.length(); i++) {
				JSONObject temp = work.getJSONObject(i);
				if (temp.has("img")) {
					JSONObject img = temp.getJSONObject("img");
					if (img.has("big")) {
						ImageView trabajo = new ImageView(mActivity);
						LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(
								LayoutParams.MATCH_PARENT,
								LayoutParams.MATCH_PARENT, 1f);
						trabajo.setLayoutParams(layout);
						mImagenes.addView(trabajo);
						Picasso.with(mActivity)
								.load(ActivitiesModel.IMAGE_URL
										+ img.getString("big"))
								.placeholder(R.drawable.ic_launcher)
								.into(trabajo);
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
