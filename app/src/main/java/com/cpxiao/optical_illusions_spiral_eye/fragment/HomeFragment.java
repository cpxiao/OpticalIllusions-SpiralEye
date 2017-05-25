package com.cpxiao.optical_illusions_spiral_eye.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpxiao.optical_illusions_spiral_eye.R;

/**
 * @author cpxiao on 2017/05/21.
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        return view;
        //        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
