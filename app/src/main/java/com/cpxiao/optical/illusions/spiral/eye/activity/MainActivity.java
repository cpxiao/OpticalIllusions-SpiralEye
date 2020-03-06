package com.cpxiao.optical.illusions.spiral.eye.activity;

import android.os.Bundle;

import com.cpxiao.gamelib.activity.BaseAdsActivity;
import com.cpxiao.gamelib.fragment.BaseFragment;
import com.cpxiao.optical.illusions.spiral.eye.fragment.HomeFragment;

public class MainActivity extends BaseAdsActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return HomeFragment.newInstance(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAds();
    }

    private void loadAds() {
//        initAdMobAds100("ca-app-pub-3940256099942544/6300978111");// AdMob test id
        initAdMobAds100("ca-app-pub-4157365005379790/8250583556");// main banner
        initAdMobAds100("ca-app-pub-4157365005379790/8009860462");// home banner
        initAdMobAds100("ca-app-pub-4157365005379790/5268216868");// list banner
        initAdMobAds100("ca-app-pub-4157365005379790/2175149663");// fullScreen banner


        initFbAds90("1074299932671998_1149772785124712");// main banner
        initFbAds90("1074299932671998_1074300832671908");// home banner
        initFbAds90("1074299932671998_1074300959338562");// list banner
        initFbAds90("1074299932671998_1074300592671932");// fullScreen banner

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
