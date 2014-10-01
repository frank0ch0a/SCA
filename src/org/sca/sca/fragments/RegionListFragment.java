package org.sca.sca.fragments;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sca.sca.R;
import org.sca.sca.model.ApiRegionConnection;
import org.sca.sca.model.Architect;
import org.sca.sca.model.RegionModel;
import org.sca.sca.model.Regions;
import org.sca.sca.util.ImageL;
import org.sca.sca.util.Network;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RegionListFragment extends Fragment {

	private Activity mActivity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);

		View root = inflater.inflate(R.layout.fragment_list_regions, container,
				false);

		AsyncTask<Object, Integer, ApiRegionConnection> downloadRegions = new AsyncTask<Object, Integer, ApiRegionConnection>() {

			@Override
			protected ApiRegionConnection doInBackground(Object... params) {

				return ApiRegionConnection.getInstance("tp=4&");
			}

			@Override
			protected void onPostExecute(ApiRegionConnection apiregionconnection) {

				ListView listView = (ListView) getView().findViewById(
						android.R.id.list);
				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						new Task().execute(arg3 + "");
					}
				});
				RegionListAdapter adapter = new RegionListAdapter(
						getActivity(), apiregionconnection.getRegionsList());
				listView.setAdapter(adapter);

				/*
				 * ArrayAdapter<Regions> adapter = new
				 * ArrayAdapter<Regions>(getActivity(),
				 * android.R.layout.simple_list_item_1,
				 * apiregionconnection.getRegionsList());
				 * listView.setAdapter(adapter);
				 */
				// listView.setOnItemClickListener((OnItemClickListener)getActivity());

			}

		};

		downloadRegions.execute();

		return root;

	}

	class RegionListAdapter extends ArrayAdapter<Regions> {

		TextView nameReg;
		ImageView image;

		public RegionListAdapter(Context context, List<Regions> regionList) {
			super(context, R.layout.regions_layout, regionList);

		}

		@Override
		public Regions getItem(int position) {
			return super.getItem(position);
		}

		@Override
		public long getItemId(int position) {
			return Long.parseLong(getItem(position).getId_reg());
		}

		public View getView(int position, View regionRow, ViewGroup parent) {

			final HolderAdapter holder;

			// Usamos el inflater para sacar nuestro layout
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if (regionRow == null) {
				holder = new HolderAdapter();
				regionRow = inflater.inflate(R.layout.regions_layout, null);
				holder.nameReg = (TextView) regionRow
						.findViewById(R.id.title_reg_textView);
				holder.image = (ImageView) regionRow
						.findViewById(R.id.regionplaceholder);

				regionRow.setTag(holder);
			} else {
				holder = (HolderAdapter) regionRow.getTag();
			}

			// Obtenemos nuestro modelo para rellenar con la informaciÃ³n de
			// esta fila
			Regions currentRegion = getItem(position);

			holder.nameReg.setText(currentRegion.getName_rege());
			if (currentRegion.getImage() != null)
				Picasso.with(mActivity).load(currentRegion.getImage())
						.into(holder.image);
			// new ImageL(currentRegion.getImage(), holder.image, getContext());
			return regionRow;

		}
	}

	private static class HolderAdapter {
		public TextView nameReg;
		public ImageView image;

	}

	class Task extends AsyncTask<String, Void, Void> {

		final ProgressDialog pd = new ProgressDialog(getActivity());

		@Override
		protected Void doInBackground(String... params) {
			loadData(params[0]);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			if (pd != null && pd.isShowing()) {
				pd.dismiss();
			}

			RegionModel temp = data(jsonO);
			if (temp != null) {
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager
						.beginTransaction()
						.replace(R.id.frame_container,
								new RegionsDetailFragment(temp)).commit();
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

	private static JSONObject jsonO;

	public void loadData(String region_id) {
		Network net = new Network();
		jsonO = net.getDataJSONObject("http://sca.siie.co/api?tp=4&id_reg="
				+ region_id
				+ "&apikey=2177868a8da78fc325996838ab73cec6f9d3eaa0-71100");

	}

	public RegionModel data(JSONObject obj) {
		System.out.println(obj);
		try {
			JSONArray array = obj.getJSONArray("regional");
			JSONObject region = array.getJSONObject(0);
			String big = "", t01 = "", t02 = "", t03 = "";
			if (region.has("img")) {
				JSONObject regionImg = region.getJSONObject("img");
				big = regionImg.getString("big");
				t01 = regionImg.getString("t01");
				t02 = regionImg.getString("t02");
				t03 = regionImg.getString("t03");
			}
			JSONArray personsJson = region.getJSONArray("persons");
			ArrayList<Architect> persons = new ArrayList<Architect>();
			for (int i = 0; i < personsJson.length(); i++) {
				JSONObject tempperson = personsJson.getJSONObject(i);
				JSONObject img = tempperson.getJSONObject("img");
				Architect person = new Architect(
						tempperson.getString("id_person"),
						tempperson.getString("name_person"),
						tempperson.getString("lastname_person"),
						tempperson.getString("bio_person"),
						tempperson.getString("id_reg_person"),
						tempperson.getString("name_reg_person"),
						tempperson.getString("slug_reg_person"),
						tempperson.getString("hasimg_person"),
						tempperson.getString("extimg_person"),
						img.getString("big"), img.getString("t01"),
						img.getString("t02"), img.getString("t03"),
						region.getString("city_reg"));
				persons.add(person);
			}
			return new RegionModel(region.getString("id_reg"),
					region.getString("name_reg"), region.getString("abr_reg"),
					region.getString("slug_reg"), region.getString("dir_reg"),
					region.getString("phone_reg"),
					region.getString("city_reg"),
					region.getString("country_reg"),
					region.getString("district_reg"),
					region.getString("lat_reg"), region.getString("lon_reg"),
					region.getString("id_person_reg"),
					region.getString("name_person_reg"),
					region.getString("lastname_person_reg"),
					region.getString("hasimg_reg"),
					region.getString("extimg_reg"), big, t01, t02, t03, persons);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}
}
