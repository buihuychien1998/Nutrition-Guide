package com.mteam.nutritionguide.ui.event;

import android.view.View;
import android.view.View.OnClickListener;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mteam.nutritionguide.FxpApp;
import com.mteam.nutritionguide.R;
import com.mteam.nutritionguide.ui.commons.Params;
import com.mteam.nutritionguide.ui.screen.ActivityListSport;
import com.mteam.nutritionguide.ui.screen.ActivityMainWorkoutList;
import com.mteam.nutritionguide.ui.screen.ActivityMenu;
import com.mteam.nutritionguide.ui.screen.ActivityPremiumWorkoutList;

public class MenuScreenEventHandler implements OnClickListener {

	private FragmentManager fragmentManager;

	public MenuScreenEventHandler(ActivityMenu activityMenu) {
		super();

		fragmentManager = activityMenu.getActivity().getSupportFragmentManager();
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		switch (v.getId()) {
			case R.id.layoutMain:
				openMainWorkoutList(transaction);
				break;
			case R.id.layoutPremium:
				openPremiumWorkoutList(transaction);
				break;

			case R.id.layoutSport:
				openLayoutSport(transaction);
				break;
		}
		
		// Commit the transaction
		transaction.commit();
	}

	private void openMainWorkoutList(FragmentTransaction transaction) {
		FxpApp.isMainWorkout = true;
		transaction.replace(R.id.fragment, new ActivityMainWorkoutList(), Params.MAIN_WORKOUT_LIST_SCREEN);
	}
	
	private void openPremiumWorkoutList(FragmentTransaction transaction) {
		FxpApp.isMainWorkout = false;
		transaction.replace(R.id.fragment, new ActivityPremiumWorkoutList(), Params.PREMIUM_WORKOUT_LIST_SCREEN);
	}

	private void openLayoutSport(FragmentTransaction transaction) {
		FxpApp.isMainWorkout = false;
		transaction.replace(R.id.fragment, new ActivityListSport(), Params.SPORT_WORKOUT_LIST_SCREEN);
	}

}
