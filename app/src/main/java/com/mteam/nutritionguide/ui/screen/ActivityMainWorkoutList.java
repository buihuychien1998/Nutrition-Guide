package com.mteam.nutritionguide.ui.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mteam.nutritionguide.R;
import com.mteam.nutritionguide.FxpApp;
import com.mteam.nutritionguide.bean.WorkoutBean;
import com.mteam.nutritionguide.bean.WorkoutRow;
import com.mteam.nutritionguide.ui.event.MainWorkoutListScreenEventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityMainWorkoutList extends AbstractFragment {

	private TextView mTitle;

	private ListView mWorkoutList;

	final List<Item> items = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_main_workout_list,
		        container, false);
		
		mTitle = (TextView) view.findViewById(R.id.title);
		mWorkoutList = (ListView) view.findViewById(R.id.workouts);
		View mBack = view.findViewById(R.id.imgBack);
		initData();
		MainWorkoutListScreenEventHandler eventHandler = new MainWorkoutListScreenEventHandler(this,getContext());
		mBack.setOnClickListener(eventHandler);
		
		List<WorkoutRow> workoutRows = prepareData();

		FoodAdapter workoutListAdapter = new FoodAdapter(this.requireActivity(), items);
		mWorkoutList.setAdapter(workoutListAdapter);
		mWorkoutList.setOnItemClickListener(eventHandler);
		eventHandler.setWorkoutRows(items);
		
		RelativeLayout menubarLayout = (RelativeLayout) getActivity().findViewById(R.id.menubarLayout);
		menubarLayout.setVisibility(View.VISIBLE);
		
		return view;
	}

	private void initData() {
		items.add(new Item("Tuna",
				"https://www.thespruceeats.com/thmb/x2CccLs17Ve1vmehwA7kieBBFX8=/1800x1800/smart/filters:no_upscale()/tunaloinsteak_getty2400-58a4b82c3df78c4758e06bbb.jpg",
				"Tuna are remarkable and impressive wild animals. The Atlantic bluefin can reach ten feet in length and weigh as much as 2000 pounds (more than a horse)"));

		items.add(new Item("Lamb",
				"https://www.simplyrecipes.com/thmb/BPNd4q6CBB_uuNz35kOm2C76HwA=/3733x3733/smart/filters:no_upscale()/Simply_Recipes_Classic_Lamb_Rack_LEAD-1-de5b82ea21514161ac9e272ec456480b.jpg",
				"Lamb or lamb is a type of food meat from sheep. In some countries, lamb is not only good for health, but is considered a dish that brings good luck and prosperity."));

		items.add(new Item(getString(R.string.crab),
				"https://image.cnbcfm.com/api/v1/image/101100237-113240502.jpg?v=1532564619",
				getString(R.string.sadasd)));

		items.add(new Item("Salmon",
				"https://cdn.tgdd.vn/Files/2021/03/30/1339250/phan-biet-cac-phan-thit-ca-hoi-va-nhung-cach-che-bien-ngon-het-say-202103301024596127.jpg",
				"Salmon is the common name for fish in the family Salmonidae. Salmon usually live along the coasts of the North Atlantic Ocean and the Pacific Ocean"));

		items.add(new Item("Radish",
				"https://www.simplyrecipes.com/thmb/cNH7oi5tJQHObretbNvWzhXd8rs=/2600x2600/smart/filters:no_upscale()/Simply-Recipes-Radish-Guide-07-Daikon-Watermelon-Red-Easter-7-9509680820604cb19802b4dde4b8fa9a.jpg",
				"The radish (Raphanus raphanistrum subsp. sativus) is an edible root vegetable of the family Brassicaceae that was domesticated in Asia prior to Roman times."));

		items.add(new Item(getString(R.string.potato),
				"https://www.foodnetwork.com/content/dam/images/food/fullset/2003/9/29/0/ig1a07_roasted_potatoes.jpg",
				getString(R.string.vegetable)));

	}

	private List<WorkoutRow> prepareData() {
		Map<String, List<WorkoutBean>> workoutsMap = FxpApp.mainWorkoutsMap;
		
		List<WorkoutRow> workoutRows = new ArrayList<WorkoutRow>();
		for (String workoutName : workoutsMap.keySet()) {
			WorkoutRow workoutRow = new WorkoutRow(workoutName, R.drawable.main_workout_default_icon);
			workoutRows.add(workoutRow);
		}
		
		return workoutRows;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		mTitle.setTypeface(FxpApp.helveticaNeue);
	}
}
