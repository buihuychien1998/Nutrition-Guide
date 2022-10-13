package com.mteam.nutritionguide.ui.event;

import android.view.View;
import android.view.View.OnClickListener;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mteam.nutritionguide.FxpApp;
import com.mteam.nutritionguide.ui.commons.Params;
import com.mteam.nutritionguide.ui.screen.ActivityMainWorkoutList;
import com.mteam.nutritionguide.ui.screen.ActivityPremiumWorkoutList;
import com.mteam.nutritionguide.ui.screen.ActivityWorkoutDetail;
import com.mteam.nutritionguide.ui.screen.ActivityWorkoutSelect;

import com.mteam.nutritionguide.R;
public class WorkoutSelectScreenEventHandler implements OnClickListener {

	private FragmentManager fragmentManager;
	
	ActivityWorkoutSelect activityWorkoutSelect;

	public WorkoutSelectScreenEventHandler(ActivityWorkoutSelect activityWorkoutSelect) {
		super();
		
		this.activityWorkoutSelect = activityWorkoutSelect;

		fragmentManager = activityWorkoutSelect.getActivity().getSupportFragmentManager();
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();

		switch (v.getId()) {
		case R.id.imgBack:
			back(transaction);
			break;
			
		case R.id.btnStartWorkout:
			startWorkout(transaction);
			break;
		}

		// Commit the transaction
		transaction.commit();
	}

	private void back(FragmentTransaction transaction) {
		FxpApp.menuBar.getCurrentViewSelected().setSelected(false);
		FxpApp.menuBar.setCurrentViewSelected(FxpApp.menuBar.getHome());
		if(FxpApp.isMainWorkout) {
			transaction.replace(R.id.fragment, new ActivityMainWorkoutList(), Params.MAIN_WORKOUT_LIST_SCREEN);
		} else {
			transaction.replace(R.id.fragment, new ActivityPremiumWorkoutList(), Params.PREMIUM_WORKOUT_LIST_SCREEN);
		}
	}

	private void startWorkout(FragmentTransaction transaction) {
		ActivityWorkoutDetail activityWorkoutDetail = new ActivityWorkoutDetail();
		transaction.replace(R.id.fragment, activityWorkoutDetail, Params.WORKOUT_DETAIL_SCREEN);
	}
}
