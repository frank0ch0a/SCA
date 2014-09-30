package org.sca.sca.fragments;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.adapters.ContestAdapter;
import org.sca.sca.fragments.EventsFragment.Task;
import org.sca.sca.model.ContestModel;
import org.sca.sca.util.ImageL;
import org.sca.sca.util.Network;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CompetitionFragment extends Fragment {

	private ListView mListView;
	private JSONObject jsonO;
	private ArrayList<ContestModel> contests;
	private Activity mActivity;

	public CompetitionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_competition,
				container, false);
		mListView = (ListView) rootView.findViewById(R.id.listView);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Llevar a donde debe llevar con la info requerida
			}
		});
		contests = new ArrayList<ContestModel>();

		new Task().execute();
		return rootView;
	}

	class Task extends AsyncTask<Void, Void, Void> {

		final ProgressDialog pd = new ProgressDialog(mActivity);

		@Override
		protected Void doInBackground(Void... params) {
			loadData();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			data(jsonO);
			mListView.setAdapter(new ContestAdapter(mActivity, contests));
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
				.getDataJSONObject("http://sca.siie.co/api?tp=7&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");

	}

	public void data(JSONObject obj) {

		try {

			JSONArray contest = obj.getJSONArray("contest");
			for (int i = 0; i < contest.length(); i++) {
				JSONObject temp = contest.getJSONObject(i);
				ContestModel model = new ContestModel();
				model.setmIdContext(temp.getString("id_contest"));
				model.setmName_contest(temp.getString("name_contest"));
				model.setmDate_i_contest(temp.getString("date_i_contest"));
				model.setmDate_e_contest(temp.getString("date_e_contest"));
				model.setmDate_pi_contest(temp.getString("date_pi_contest"));
				model.setmDate_pf_contest(temp.getString("date_pf_contest"));
				model.setmUrl_contest(temp.getString("url_contest"));
				model.setmDesc_contest(temp.getString("desc_contest"));
				model.setmDate_if_contest(temp.getString("hasimg_contest"));
				model.setmDate_ef_contest(temp.getString("date_ef_contest"));
				JSONObject img = temp.getJSONObject("img");
				model.setmBig(img.getString("big"));
				model.setmT01(img.getString("t01"));
				model.setmT02(img.getString("t02"));
				model.setmT03(img.getString("t03"));
				contests.add(model);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mActivity = activity;
	}
}
