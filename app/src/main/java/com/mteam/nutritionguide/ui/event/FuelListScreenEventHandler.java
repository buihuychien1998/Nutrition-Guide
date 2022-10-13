package com.mteam.nutritionguide.ui.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mteam.nutritionguide.R;
import com.mteam.nutritionguide.FxpApp;
import com.mteam.nutritionguide.bean.FuelRow;
import com.mteam.nutritionguide.ui.commons.Params;
import com.mteam.nutritionguide.ui.screen.ActivityFuelList;
import com.mteam.nutritionguide.ui.screen.ActivitySettings;

import java.util.List;

public class FuelListScreenEventHandler implements OnClickListener, OnItemClickListener {

	private List<FuelRow> fuelRows;

	private FragmentManager fragmentManager;

	public FuelListScreenEventHandler(ActivityFuelList activityFuelList) {
		super();

		fragmentManager = activityFuelList.getActivity().getSupportFragmentManager();
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();

		switch (v.getId()) {
		case R.id.imgBack:
			back(transaction);
			break;
		}

		// Commit the transaction
		transaction.commit();
	}

	private void back(FragmentTransaction transaction) {
		FxpApp.menuBar.getCurrentViewSelected().setSelected(false);
		FxpApp.menuBar.setCurrentViewSelected(FxpApp.menuBar.getSettings());
		transaction.replace(R.id.fragment, new ActivitySettings(), Params.SETTINGS_SCREEN);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//		FuelRow fuelRow = (FuelRow) fuelRows.get(position);
	}

	public List<FuelRow> getFuelRows() {
		return fuelRows;
	}

	public void setFuelRows(List<FuelRow> fuelRows) {
		this.fuelRows = fuelRows;
	}
}
