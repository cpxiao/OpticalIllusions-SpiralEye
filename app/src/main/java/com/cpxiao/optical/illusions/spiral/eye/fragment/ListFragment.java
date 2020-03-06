package com.cpxiao.optical.illusions.spiral.eye.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cpxiao.R;
import com.cpxiao.gamelib.fragment.BaseFragment;
import com.cpxiao.optical.illusions.spiral.eye.mode.Data;

import java.util.ArrayList;

/**
 * @author cpxiao on 2017/08/30.
 */

public class ListFragment extends BaseFragment {

    private static final int ROW_COUNT = 3;
    private static final float ASPECT_RATIO = 1.3f;

    public static ListFragment newInstance(Bundle bundle) {
        ListFragment fragment = new ListFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), ROW_COUNT));
        ArrayList<Integer> arrayList = Data.getOIGifData();
        NormalAdapter adapter = new NormalAdapter(context, arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
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
            if (DEBUG) {
                Log.d(TAG, "onCreateViewHolder: " + params.width);
                Log.d(TAG, "onCreateViewHolder: " + params.height);
            }
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

            final int index = holder.getAdapterPosition();
            final Integer resourceId = mDataList.get(index);
            if (DEBUG) {
//                holder.mImageView.setImageResource(resourceId);//此处不要用glide加载，比较卡。用pl.droidsonroids.gif.GifImageView。
                Glide.with(getHoldingActivity())
                        .asGif()
                        .load(resourceId)
                        .into(holder.mImageView);// 20200305 glide加载gif效果也还不错
            } else {
                Glide.with(mContext)
                        .asBitmap()
                        .load(resourceId)
                        .into(holder.mImageView);
            }
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(FullscreenFragment.RESOURCE_ID, resourceId);
                    addFragment(FullscreenFragment.newInstance(bundle));
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
                mImageView = view.findViewById(R.id.image_view);
                mTitle = view.findViewById(R.id.title);
            }
        }
    }

}
