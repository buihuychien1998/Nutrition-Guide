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
import com.mteam.nutritionguide.bean.NutritionCategoryBean;
import com.mteam.nutritionguide.bean.NutritionRow;
import com.mteam.nutritionguide.ui.adapter.NutritionListAdapter;
import com.mteam.nutritionguide.ui.event.NutritionListScreenEventHandler;
import com.mteam.nutritionguide.ui.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ActivityNutritionList extends AbstractFragment {

    private TextView mTitle;

    private View mBack;

    private ListView mNutritionList;

    private List<Items> listNutrition = new ArrayList<>();

    public static final String ICON_PREFIX = "icon";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nutritions_list,
                container, false);

        mTitle = (TextView) view.findViewById(R.id.title);
        mNutritionList = (ListView) view.findViewById(R.id.nutrition);
        mBack = view.findViewById(R.id.imgBack);

        initData();

        NutritionListScreenEventHandler eventHandler = new NutritionListScreenEventHandler(this);
        mBack.setOnClickListener(eventHandler);

        List<NutritionRow> nutritionRows = prepareData();

        NutritionListAdapter workoutListAdapter = new NutritionListAdapter(this.getActivity(), listNutrition);
        mNutritionList.setAdapter(workoutListAdapter);
        mNutritionList.setOnItemClickListener(eventHandler);
        eventHandler.setNutritionRows(listNutrition);

        RelativeLayout menubarLayout = (RelativeLayout) getActivity().findViewById(R.id.menubarLayout);
        menubarLayout.setVisibility(View.VISIBLE);

        return view;
    }

    private void initData() {
        listNutrition.add(new Items("Vegetables: Eat at least 400g of vegetables daily to reduce the risk of metabolic diseases and increase fiber consumption.\n"));
        listNutrition.add(new Items("Fat: Reduce fat intake to less than 30% of total dietary calories to control weight and reduce risk of noncommunicable diseases."));
        listNutrition.add(new Items("Salt, sodium and potassium: We often consume too much sodium through salt (corresponding to an average of 9-12g of salt a day) and low in potassium (under 3.5g). Eating high in sodium and low in potassium contributes to high blood pressure and increases the risk of heart disease and stroke. Reduce salt consumption to less than 5g a day\n."));
        listNutrition.add(new Items("Drink water, coffee, or tea. Skip sugary drinks, limit milk and dairy products to one to two servings per day, and limit juice to a small glass per day."));
        listNutrition.add(new Items("Stay active. The red figure running across the Healthy Eating Plate’s placemat is a reminder that staying active is also important in weight control."));
    }

    private List<NutritionRow> prepareData() {
        Map<String, NutritionCategoryBean> nutritionsMap = FxpApp.nutritionsMap;
        if (nutritionsMap == null) {
            return new ArrayList<>();
        }

        List<NutritionRow> nutritionRows = new ArrayList<>();
        for (String nutritionName : nutritionsMap.keySet()) {
            NutritionCategoryBean nutritionCategoryBean = nutritionsMap.get(nutritionName);

            assert nutritionCategoryBean != null;
            String des = nutritionCategoryBean.getDescription();

            int imageId = R.drawable.breakfast_icon;
            try {
                imageId = CommonUtils.getId(nutritionCategoryBean.getIconId() + "_" + ICON_PREFIX, R.drawable.class);
            } catch (SecurityException e) {
            } catch (IllegalArgumentException e) {
            } catch (NoSuchFieldException e) {
            } catch (IllegalAccessException e) {
            }

            NutritionRow nutritionRow = new NutritionRow(nutritionName, imageId, des);
            nutritionRows.add(nutritionRow);
        }

        NutritionRow[] nutritionRowsArr = new NutritionRow[4];
        for (NutritionRow nutritionRow : nutritionRows) {
            if (nutritionRow.getName().equals("Breakfast")) {
                nutritionRowsArr[0] = nutritionRow;
            } else if (nutritionRow.getName().equals("Snack")) {
                nutritionRowsArr[1] = nutritionRow;
            } else if (nutritionRow.getName().equals("Lunch")) {
                nutritionRowsArr[2] = nutritionRow;
            } else {
                nutritionRowsArr[3] = nutritionRow;
            }
        }

        return Arrays.asList(nutritionRowsArr);
    }

    @Override
    public void onResume() {
        super.onResume();

        mTitle.setTypeface(FxpApp.helveticaNeue);
    }
}
