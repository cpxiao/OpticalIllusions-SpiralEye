package com.cpxiao.optical.illusions.spiral.eye.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cpxiao.R;
import com.cpxiao.gamelib.fragment.BaseFragment;
import com.cpxiao.gamelib.views.CountDownTextView;

/**
 * @author cpxiao on 2017/08/30.
 */

public class FullscreenFragment extends BaseFragment {
    public static final String RESOURCE_ID = "RESOURCE_ID";
    private ImageView mImageView;

    private CountDownTextView mCountDownTextView;

    private LinearLayout timeUpLayout;

    public static FullscreenFragment newInstance(Bundle bundle) {
        FullscreenFragment fragment = new FullscreenFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mImageView = view.findViewById(R.id.gif_image_view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int resourceId = bundle.getInt(RESOURCE_ID, -1);
            if (resourceId != -1) {
//                mImageView.setImageResource(resourceId);//此处不要用glide加载，比较卡。用pl.droidsonroids.gif.GifImageView
                Glide.with(getHoldingActivity())
                        .asGif()
                        .load(resourceId)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .into(mImageView);// 20200305 glide加载gif效果也还不错
            } else {
                onDestroy();
            }
        }

        mCountDownTextView = view.findViewById(R.id.count_down_text_view);
        mCountDownTextView.setOnTimeUpListener(new CountDownTextView.OnTimeUpListener() {
            @Override
            public void timeUp() {
                mCountDownTextView.setVisibility(View.INVISIBLE);
                // time up

                timeUpLayout.setVisibility(View.VISIBLE);

                mImageView.setVisibility(View.INVISIBLE);

//                Glide.with(getHoldingActivity())
//                        .asBitmap()
//                        .load(R.drawable.app_icon)
//                        .into(mImageView);// 20200305 glide加载gif效果也还不错
            }
        });

        timeUpLayout = view.findViewById(R.id.time_up_layout);
        timeUpLayout.setVisibility(View.INVISIBLE);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fullscreen;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mCountDownTextView != null) {
            mCountDownTextView.resetTime(30000);
            mCountDownTextView.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImageView != null) {
            mImageView.clearAnimation();
            mImageView.destroyDrawingCache();
        }
    }
}
