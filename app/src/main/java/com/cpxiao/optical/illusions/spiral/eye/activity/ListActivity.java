package com.cpxiao.optical.illusions.spiral.eye.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cpxiao.gamelib.activity.BaseActivity;
import com.cpxiao.optical.illusions.spiral.eye.R;
import com.cpxiao.optical.illusions.spiral.eye.mode.Data;

import java.util.ArrayList;


/**
 * @author cpxiao on 2017/05/21.
 */

public class ListActivity extends BaseActivity {

    private static final int ROW_COUNT = 3;
    private static final float ASPECT_RATIO = 1.3f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, ROW_COUNT));
        ArrayList<Integer> arrayList = Data.getOIGifData();
        NormalAdapter adapter = new NormalAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        initAdMobAds50("ca-app-pub-4157365005379790/5268216868");
    }


    class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.NormalViewHolder> {
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private ArrayList<Integer> mDataList;

        NormalAdapter(Context context, ArrayList<Integer> dataList) {
            mDataList = dataList;
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
            GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            params.height = (int) (parent.getMeasuredWidth() / ROW_COUNT * ASPECT_RATIO);
            view.setLayoutParams(params);
            return new NormalViewHolder(view);
        }


        @Override
        public void onBindViewHolder(NormalViewHolder holder, int position) {
            if (mDataList == null) {
                return;
            }
            if (position < 0 || position >= mDataList.size()) {
                return;
            }
            //            int level = PreferencesUtils.getInt(getApplicationContext(), Extra.Key.LEVEL, Extra.Key.LEVEL_DEFAULT);

            final int index = holder.getAdapterPosition();
            final Integer data = mDataList.get(index);
            Glide.with(ListActivity.this)
                    .asBitmap()
                    .load(data)
                    .into(holder.mImageView);
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = FullScreenActivity.makeBundle(data);
                    Intent intent = FullScreenActivity.makeIntent(mContext, bundle);
                    startActivity(intent);
                }
            });

            String title = getResources().getString(R.string.level) + ": " + (index + 1);
            holder.mTitle.setText(title);

        }

        @Override
        public int getItemCount() {
            return mDataList == null ? 0 : mDataList.size();
        }

        class NormalViewHolder extends RecyclerView.ViewHolder {
            ImageView mImageView;
            TextView mTitle;

            NormalViewHolder(View view) {
                super(view);
                mImageView = (ImageView) view.findViewById(R.id.image_view);
                mTitle = (TextView) view.findViewById(R.id.title);
            }
        }

    }

    public static Bundle makeBundle() {
        return null;
        //        Bundle bundle = new Bundle();
        //        return bundle;
    }

    public static Intent makeIntent(Context context, Bundle bundle) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

}
