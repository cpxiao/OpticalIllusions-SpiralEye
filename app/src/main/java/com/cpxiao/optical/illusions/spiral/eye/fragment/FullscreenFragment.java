package com.cpxiao.optical.illusions.spiral.eye.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cpxiao.R;
import com.cpxiao.gamelib.fragment.BaseZAdsFragment;
import com.cpxiao.zads.core.ZAdPosition;

/**
 * @author cpxiao on 2017/08/30.
 */

public class FullscreenFragment extends BaseZAdsFragment {
    public static final String RESOURCE_ID = "RESOURCE_ID";
    private ImageView mImageView;

    public static FullscreenFragment newInstance(Bundle bundle) {
        FullscreenFragment fragment = new FullscreenFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        loadZAds(ZAdPosition.POSITION_GAME);

        mImageView = (ImageView) view.findViewById(R.id.gif_image_view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int resourceId = bundle.getInt(RESOURCE_ID, -1);
            if (resourceId != -1) {
                //此处不要用glide加载，比较卡。用pl.droidsonroids.gif.GifImageView
                mImageView.setImageResource(resourceId);
                //                Glide.with(getActivity()).load(resourceId).into(mImageView);
            } else {
                onDestroy();
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fullscreen;
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
