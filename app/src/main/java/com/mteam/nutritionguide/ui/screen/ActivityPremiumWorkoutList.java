package com.mteam.nutritionguide.ui.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mteam.nutritionguide.FxpApp;
import com.mteam.nutritionguide.R;
import com.mteam.nutritionguide.bean.WorkoutBean;
import com.mteam.nutritionguide.bean.WorkoutRow;
import com.mteam.nutritionguide.ui.event.PremiumWorkoutListScreenEventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityPremiumWorkoutList extends AbstractFragment {

    private TextView mTitle;

    private View mBack;

    private ListView mWorkoutList;

    final List<Item> items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_premium_workout_list,
                container, false);

        mTitle = (TextView) view.findViewById(R.id.title);
        mWorkoutList = (ListView) view.findViewById(R.id.workouts);
        mBack = view.findViewById(R.id.imgBack);
        initData();
        PremiumWorkoutListScreenEventHandler eventHandler = new PremiumWorkoutListScreenEventHandler(this, getContext());
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
        items.add(new Item(getString(R.string.oange),
                "https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/AN_images/orange-juice-1296x728-feature.jpg?w=1155&h=1528",
                "A drink made from or flavored with oranges."));

        items.add(new Item(getString(R.string.milk),
                "https://upload.wikimedia.org/wikipedia/commons/c/c8/Oat_milk_glass_and_bottles.jpg",
                "Milk is a white liquid food produced by the mammary glands of mammals"));

        items.add(new Item(getString(R.string.smoothie),
                "https://www.sunglowkitchen.com/wp-content/uploads/2021/07/smoothie-recipe-with-avocado-15-1.jpg",
                "This avocado smoothie is rich and creamy thanks to a combination of vanilla yogurt, avocado, and honey"));

        items.add(new Item("Yogurt",
                "https://media.cooky.vn/images/blog-2016/5-dieu-ki-dieu-tu-yogurt-sua-chua-ma-ban-nen-biet%201(1).jpg",
                "A semisolid food prepared from milk fermented by added bacteria, often sweetened and flavored."));

        items.add(new Item(getString(R.string.juice),
                "https://www.goodnature.com/wp-content/uploads/2021/07/apple-juice-hero-500x500.jpg",
                "Apple juice is a fruit juice made by the maceration and pressing of an apple"));

        items.add(new Item("Cream",
                "https://thehiddenveggies.com/wp-content/uploads/2021/01/whipped-cream-sq-2.jpg",
                "Cream is a dairy product composed of the higher-fat layer skimmed from the top of milk before homogenization. In un-homogenized milk, the fat."));
        items.add(new Item("Coconut water",
                "https://images.immediate.co.uk/production/volatile/sites/30/2017/08/coconut-water-bb9cfe8.jpg",
                "Coconut water is a delicious, electrolyte-filled, natural beverage that may benefit your heart, moderate your blood sugar, help improve kidney health."));

    }

    private List<WorkoutRow> prepareData() {
        Map<String, List<WorkoutBean>> workoutsMap = FxpApp.premiumWorkoutsMap;

        List<WorkoutRow> workoutRows = new ArrayList<WorkoutRow>();
        for (String workoutName : workoutsMap.keySet()) {
            WorkoutRow workoutRow = new WorkoutRow(workoutName, R.drawable.premium_workout_default_icon);

            String purchaseId = workoutsMap.get(workoutName).get(0).getPurchaseId();

            workoutRow.setPurchaseId(purchaseId);
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
