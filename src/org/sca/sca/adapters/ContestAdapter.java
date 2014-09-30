package org.sca.sca.adapters;

import java.util.ArrayList;

import org.sca.sca.R;
import org.sca.sca.model.ContestModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContestAdapter extends BaseAdapter {

	private LayoutInflater mLayoutInflater;
	private ArrayList<ContestModel> activities;
	private Context context;

	public ContestAdapter(Context context, ArrayList<ContestModel> activities) {
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
		return Integer.parseInt(activities.get(position).getmIdContext());
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

		ContestModel objectItem = activities.get(position);

		if (objectItem != null) {
			Picasso.with(context).load(objectItem.getmT01())
					.into(viewHolder.image);
			viewHolder.title.setText(objectItem.getmName_contest());
			viewHolder.date.setText(objectItem.getmDate_i_contest());
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
