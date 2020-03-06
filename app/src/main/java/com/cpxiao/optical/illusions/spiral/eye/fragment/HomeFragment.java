package com.cpxiao.optical.illusions.spiral.eye.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cpxiao.R;
import com.cpxiao.androidutils.library.utils.RateAppUtils;
import com.cpxiao.androidutils.library.utils.ShareAppUtils;
import com.cpxiao.gamelib.fragment.BaseFragment;

/**
 * @author cpxiao on 2017/08/30.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    public static HomeFragment newInstance(Bundle bundle) {
        HomeFragment fragment = new HomeFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        ImageButton buttonRateApp = view.findViewById(R.id.rate_app);
        ImageButton buttonShare = view.findViewById(R.id.share);
        ImageButton buttonWarning = view.findViewById(R.id.warning);
        ImageButton buttonTips = view.findViewById(R.id.tips);
        ImageButton buttonPlay = view.findViewById(R.id.play);

        buttonRateApp.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
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
        Context context = getHoldingActivity();
        if (id == R.id.rate_app) {
            RateAppUtils.rate(context);
        } else if (id == R.id.share) {
            String msg = getString(R.string.share_msg) + "\n" +
                    getString(R.string.app_name) + "\n" +
                    "https://play.google.com/store/apps/details?id=" + context.getPackageName();
            ShareAppUtils.share(context, getString(R.string.share), msg);
        } else if (id == R.id.warning) {
            showWaringDialog(context);
        } else if (id == R.id.tips) {
            showTipsDialog(context);
        } else if (id == R.id.play) {
            Bundle bundle = new Bundle();
            addFragment(ListFragment.newInstance(bundle));
        }
    }

    private void showWaringDialog(Context context) {
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
    }

    private void showTipsDialog(Context context) {
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
    }


}
