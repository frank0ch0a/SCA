package org.sca.sca.fragments;

import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.util.Network;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

@SuppressLint("NewApi")
public class WhoWeAreFragment extends Fragment implements
		YouTubePlayer.OnInitializedListener {

	private YouTubePlayerView ytpv;

	private YouTubePlayer ytp;

	private TextView title;
	private TextView description;

	public WhoWeAreFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_whoweare, container,
				false);
		ytpv = (YouTubePlayerView) rootView.findViewById(R.id.youtubeplayer);
		ytpv.initialize("AIzaSyA2q6QTUAbC7rRJhEBG29oWonQzr0Ro4NE", this);
		title = (TextView) rootView.findViewById(R.id.sca_title);
		description = (TextView) rootView.findViewById(R.id.sca_description);
		return rootView;
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
			pd.setMessage("Obteniendo informaci—n. Por favor espere.");
			pd.setCancelable(false);
			pd.show();
		}

	}

	public JSONObject loadData() {
		Network net = new Network();
		return net
				.getDataJSONObject("http://sca.siie.co/api?tp=10001&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");

	}

	public void data(JSONObject obj) {
		System.out.println(obj);
		try {
			JSONObject config = obj.getJSONObject("config");
			Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Regular.otf");
			Typeface tfLight = Typeface.createFromAsset(getActivity().getAssets(), "Dosis-Light.otf");
			title.setText(config.getString("S_NOMBCORTO"));
			title.setTypeface(tf);
			description.setText(config.getString("APP_ABOUT"));
			description.setTypeface(tfLight);
			String video = config.getString("APP_VID");
			String[] parts = video.split("/");
			String endpart = parts[parts.length - 1];
			String[] videoidpart = endpart.split(Pattern.quote("?"));
			ytp.loadVideo(videoidpart[0]);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onInitializationFailure(Provider arg0,
			YouTubeInitializationResult arg1) {
		System.out.println("Initialization Fail");
	}

	@Override
	public void onInitializationSuccess(Provider provider,
			YouTubePlayer player, boolean wasrestored) {
		ytp = player;
		System.out.println("Initialization Success");
		new Task().execute();
	}

}
