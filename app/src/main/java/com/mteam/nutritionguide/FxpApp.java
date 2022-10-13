package com.mteam.nutritionguide;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Typeface;


import com.mteam.nutritionguide.bean.ExerciseBean;
import com.mteam.nutritionguide.bean.NutritionCategoryBean;
import com.mteam.nutritionguide.bean.WorkoutBean;
import com.mteam.nutritionguide.ui.screen.ActivityMain;
import com.mteam.nutritionguide.ui.screen.MenuBarFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FxpApp extends Application {

	public static MenuBarFragment menuBar;

	public static Map<String, String> youtubeVideoMap = new HashMap<>();

	public static Map<String, List<WorkoutBean>> mainWorkoutsMap = new HashMap<>();
	
	public static Map<String, List<WorkoutBean>> premiumWorkoutsMap = new HashMap<>();
	
	public static Map<String, ExerciseBean> exercisesMap = new HashMap<>();
	
	public static Map<String, NutritionCategoryBean> nutritionsMap = new HashMap<>();
	
	public static Map<String, Integer> currentDays;

	public static Typeface helveticaNeue;
	public static Typeface helveticaNeueThin;
	public static Typeface helveticaNeueBold;
	
	public static ActivityMain activityMain;
	
	public static SharedPreferences prefs;
	
	public static boolean isMainWorkout;
	
	public static boolean isFromExerciseList;
	
	public static String currentWorkoutName;
	
	public static String currentExerciseName;
	
	public static long currentFuelPoints;
	
	public static boolean isLastDay;
	
	public static List<ExerciseBean> exercisesList;

	static {
//		nutritionsMap.put("Breakfast", new NutritionCategoryBean("", ));
//		nutritionsMap.put("Snack", new NutritionCategoryBean());
//		nutritionsMap.put("Launch", new NutritionCategoryBean());
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		// Initialize currentWorkoutName
		currentWorkoutName = "";
		
		// Initialize currentExerciseName
		currentExerciseName = "";
		
		// Initialize currentDays
		currentDays = new HashMap<String, Integer>();

	}
}
