package com.mteam.nutritionguide.ui.screen;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.mteam.nutritionguide.R;
import com.mteam.nutritionguide.ui.utils.CommonUtils;

public abstract class AbstractActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!CommonUtils.isTablet(this) || getString(R.string.screen_size).equals("7")) {
        	setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
}
