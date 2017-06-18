package com.cpxiao.optical_illusions_spiral_eye.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cpxiao.gamelib.activity.BaseActivity;
import com.cpxiao.optical_illusions_spiral_eye.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * @author cpxiao on 2017/05/22.
 */

public class FullScreenActivity extends BaseActivity {
    private static final String ID = "ID";
    private GifImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        imageView = (GifImageView) findViewById(R.id.gif_image_view);
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                int id = bundle.getInt(ID, -1);
                if (id != -1) {
                    imageView.setImageResource(id);
                } else {
                    if (DEBUG) {
                        String msg = "onCreate: error! id == -1";
                        Log.d(TAG, msg);
                        throw new IllegalArgumentException(msg);
                    }
                    finish();
                }
            }
        }

        initAdMobAds50("ca-app-pub-4157365005379790/2175149663");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (imageView != null) {
            imageView.clearAnimation();
            imageView.destroyDrawingCache();
        }
    }

    public static Bundle makeBundle(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(ID, id);
        return bundle;
    }

    public static Intent makeIntent(Context context, Bundle bundle) {
        Intent intent = new Intent(context, FullScreenActivity.class);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

}
