package com.cpxiao.optical.illusions.spiral.eye.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cpxiao.R;
import com.cpxiao.gamelib.fragment.BaseZAdsFragment;
import com.cpxiao.zads.core.ZAdPosition;

/**
 * @author cpxiao on 2017/08/30.
 */

public class HomeFragment extends BaseZAdsFragment implements View.OnClickListener {

    public static HomeFragment newInstance(Bundle bundle) {
        HomeFragment fragment = new HomeFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        loadZAds(ZAdPosition.POSITION_HOME);

        Button buttonWarning = (Button) view.findViewById(R.id.warning);
        Button buttonTips = (Button) view.findViewById(R.id.tips);
        Button buttonPlay = (Button) view.findViewById(R.id.play);

        buttonWarning.setOnClickListener(this);
        buttonTips.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Context context = getActivity();
        if (id == R.id.warning) {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle(R.string.warning)
                    .setMessage(R.string.warning_msg)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        } else if (id == R.id.tips) {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle(R.string.tips)
                    .setMessage(R.string.tips_msg)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        } else if (id == R.id.play) {
            Bundle bundle = new Bundle();
            addFragment(ListFragment.newInstance(bundle));
        }
    }


}
