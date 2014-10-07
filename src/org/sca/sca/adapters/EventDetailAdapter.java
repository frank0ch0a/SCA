package org.sca.sca.adapters;

import java.util.ArrayList;

import com.bienal2014.app.R;
import org.sca.sca.model.ActivitiesModel;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailAdapter extends BaseAdapter {

	private LayoutInflater mLayoutInflater;
	private ArrayList<ActivitiesModel> activities;
	private Context context;

	public EventDetailAdapter(Context context,
			ArrayList<ActivitiesModel> activities) {
		this.context = context;
		mLayoutInflater = LayoutInflater.from(context);
		this.activities = activities;
	}

	@Override
	public int getCount() {
		return activities.size();
	}

	@Override
	public Object getItem(int position) {
		return activities.get(position);
	}

	@Override
	public long getItemId(int position) {
		return Integer.parseInt(activities.get(position).getId_activity());
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

		ActivitiesModel objectItem = activities.get(position);

		if (objectItem != null) {

			Picasso.with(context).load(objectItem.getmBig())
					.into(viewHolder.image);
			viewHolder.title.setText(objectItem.getTitle_activity());
			viewHolder.date.setText(objectItem.getHour_i_activity_format());
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
