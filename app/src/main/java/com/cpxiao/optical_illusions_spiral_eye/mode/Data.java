package com.cpxiao.optical_illusions_spiral_eye.mode;

import com.cpxiao.optical_illusions_spiral_eye.R;

import java.util.ArrayList;

/**
 * @author cpxiao on 2017/05/22.
 */

public class Data {
    public static ArrayList<Integer> getOIGifData() {
        int[] array = {
                R.drawable._oi_gif_01, R.drawable._oi_gif_02,
                 R.drawable._oi_gif_04,
                R.drawable._oi_gif_05, R.drawable._oi_gif_06,
                R.drawable._oi_gif_07, R.drawable._oi_gif_08,
                R.drawable._oi_gif_09, R.drawable._oi_gif_10,
                R.drawable._oi_gif_11, R.drawable._oi_gif_12,
                R.drawable._oi_gif_13
        };
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int anA : array) {
            arrayList.add(anA);
        }

        return arrayList;
    }

}
