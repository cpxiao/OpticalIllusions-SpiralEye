package com.cpxiao.optical.illusions.spiral.eye.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cpxiao.gamelib.activity.BaseActivity;
import com.cpxiao.optical.illusions.spiral.eye.R;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button buttonWarning = (Button) findViewById(R.id.warning);
        Button buttonTips = (Button) findViewById(R.id.tips);
        Button buttonPlay = (Button) findViewById(R.id.play);
        Button buttonRating = (Button) findViewById(R.id.rating);
        Button buttonShare = (Button) findViewById(R.id.share);

        buttonWarning.setOnClickListener(this);
        buttonTips.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);
        buttonRating.setOnClickListener(this);
        buttonShare.setOnClickListener(this);

        initAdMobAds50("ca-app-pub-4157365005379790/8009860462");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.warning) {
            AlertDialog dialog = new AlertDialog.Builder(this)
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
            AlertDialog dialog = new AlertDialog.Builder(this)
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
            Bundle bundle = ListActivity.makeBundle();
            Intent intent = ListActivity.makeIntent(HomeActivity.this, bundle);
            startActivity(intent);
        } else if (id == R.id.rating) {
        } else if (id == R.id.share) {
        }
    }
}
