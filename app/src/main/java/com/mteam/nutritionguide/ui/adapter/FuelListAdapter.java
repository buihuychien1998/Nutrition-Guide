package com.mteam.nutritionguide.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.mteam.nutritionguide.FxpApp;
import com.mteam.nutritionguide.R;
import com.mteam.nutritionguide.bean.FuelRow;

import java.util.List;

public class FuelListAdapter extends BaseAdapter {

	private Context mContext;

	private List<FuelRow> mItems;

	public FuelListAdapter(Context context, List<FuelRow> items) {
		mContext = context;
		mItems = items;
	}

	@Override
	public int getCount() {
		return mItems == null ? 0 : mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.fuel_row, null);
		}

		FuelRow fuelRow = (FuelRow) getItem(position);
		String day = fuelRow.getDay();
		String point = fuelRow.getPoint();

		TextView txtDay = (TextView) v.findViewById(R.id.txtDay);
		TextView txtPoint = (TextView) v.findViewById(R.id.txtPoint);
		
		txtDay.setText(day);
		txtDay.setTypeface(FxpApp.helveticaNeue);
		txtPoint.setText(point);
		txtPoint.setTypeface(FxpApp.helveticaNeueThin);

		return v;
	}

}
