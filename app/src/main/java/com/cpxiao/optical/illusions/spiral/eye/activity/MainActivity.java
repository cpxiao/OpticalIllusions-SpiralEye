package com.cpxiao.optical.illusions.spiral.eye.activity;

import android.os.Bundle;

import com.cpxiao.gamelib.activity.BaseZAdsActivity;
import com.cpxiao.optical.illusions.spiral.eye.fragment.BaseFragment;
import com.cpxiao.optical.illusions.spiral.eye.fragment.HomeFragment;
import com.cpxiao.zads.ZAdManager;
import com.cpxiao.zads.core.ZAdPosition;

public class MainActivity extends BaseZAdsActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return HomeFragment.newInstance(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZAdManager.getInstance().init(getApplicationContext());
        initAds(ZAdPosition.POSITION_HOME);
    }
}
