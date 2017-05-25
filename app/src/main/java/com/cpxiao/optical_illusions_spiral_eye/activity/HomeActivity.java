package com.cpxiao.optical_illusions_spiral_eye.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cpxiao.gamelib.activity.BaseActivity;
import com.cpxiao.optical_illusions_spiral_eye.R;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private Button mButtonWarning;
    private Button mButtonTips;
    private Button mButtonPlay;
    private Button mButtonRating;
    private Button mButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mButtonWarning = (Button) findViewById(R.id.warning);
        mButtonTips = (Button) findViewById(R.id.tips);
        mButtonPlay = (Button) findViewById(R.id.play);
        mButtonRating = (Button) findViewById(R.id.rating);
        mButtonShare = (Button) findViewById(R.id.share);

        mButtonWarning.setOnClickListener(this);
        mButtonTips.setOnClickListener(this);
        mButtonPlay.setOnClickListener(this);
        mButtonRating.setOnClickListener(this);
        mButtonShare.setOnClickListener(this);
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
