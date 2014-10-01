package org.sca.sca.adapters;

import java.util.ArrayList;

import org.sca.sca.R;
import org.sca.sca.adapters.EventDetailAdapter.ViewHolderItem;
import org.sca.sca.model.ActivitiesModel;
import org.sca.sca.model.Architect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RegionArchitectAdapter extends BaseAdapter {
	private LayoutInflater mLayoutInflater;
	private ArrayList<Architect> architects;
	private Context context;

	public RegionArchitectAdapter(Context context,
			ArrayList<Architect> architects) {
		this.context = context;
		mLayoutInflater = LayoutInflater.from(context);
		this.architects = architects;
	}

	@Override
	public int getCount() {
		return architects.size();
	}

	@Override
	public Object getItem(int position) {
		return architects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return Integer.parseInt(architects.get(position).getId_person());
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolderItem viewHolder;
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.event_detail_row,
					parent, false);

			viewHolder = new ViewHolderItem();
			viewHolder.image = (ImageView) convertView
					.findViewById(R.id.imageViewImageActivity);

			viewHolder.title = (TextView) convertView
					.findViewById(R.id.textViewTitle);

			viewHolder.date = (TextView) convertView
					.findViewById(R.id.textViewHour);

			convertView.setTag(viewHolder);

		} else {

			viewHolder = (ViewHolderItem) convertView.getTag();
		}

		Architect objectItem = architects.get(position);

		if (objectItem != null) {

			Picasso.with(context).load(objectItem.getT01())
					.into(viewHolder.image);
			viewHolder.title.setText(objectItem.getName_person() + " "
					+ objectItem.getLastname_person());
			// viewHolder.date.setText(objectItem.getBio_person());
		}

		return convertView;
	}

	static class ViewHolderItem {
		ImageView image;
		TextView title;
		TextView date;
		int position;
	}

}
