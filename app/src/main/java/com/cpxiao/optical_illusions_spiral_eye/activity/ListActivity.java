package com.cpxiao.optical_illusions_spiral_eye.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cpxiao.androidutils.library.utils.PreferencesUtils;
import com.cpxiao.gamelib.activity.BaseActivity;
import com.cpxiao.optical_illusions_spiral_eye.R;
import com.cpxiao.optical_illusions_spiral_eye.mode.Data;
import com.cpxiao.optical_illusions_spiral_eye.mode.Extra;

import java.util.ArrayList;


/**
 * @author cpxiao on 2017/05/21.
 */

public class ListActivity extends BaseActivity {

    private static final int ROW_COUNT = 2;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, ROW_COUNT));
        ArrayList<Integer> arrayList = Data.getOIGifData();
        NormalAdapter adapter = new NormalAdapter(this, arrayList);
        mRecyclerView.setAdapter(adapter);
    }


    public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.NormalViewHolder> {
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private ArrayList<Integer> mDataList;

        public NormalAdapter(Context context, ArrayList<Integer> dataList) {
            mDataList = dataList;
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
            GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            params.height = (int) (parent.getMeasuredWidth() / ROW_COUNT * 0.618);
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
            int level = PreferencesUtils.getInt(getApplicationContext(), Extra.Key.LEVEL, Extra.Key.LEVEL_DEFAULT);

            final int index = holder.getAdapterPosition();
            final Integer data = mDataList.get(index);
            holder.mImageView.setImageResource(data);
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = FullScreenActivity.makeBundle(data);
                    Intent intent = FullScreenActivity.makeIntent(mContext, bundle);
                    startActivity(intent);
                    //                    Toast.makeText(mContext, "Level " + data.level + " is locked!", Toast.LENGTH_SHORT).show();
                }
            });

            //            if (data < level) {
            //                holder.mImageView.setTextColor(ContextCompat.getColor(holder.mImageView.getContext().getApplicationContext(), R.color.common_black));
            //                holder.mImageView.setOnClickListener(new View.OnClickListener() {
            //                    @Override
            //                    public void onClick(View v) {
            //                        Toast.makeText(mContext, "Level " + data.level + " is locked!", Toast.LENGTH_SHORT).show();
            //                    }
            //                });
            //            } else {
            //                holder.mImageView.setTextColor(ContextCompat.getColor(holder.mImageView.getContext().getApplicationContext(), R.color.text_success));
            //                holder.mImageView.setOnClickListener(new View.OnClickListener() {
            //                    @Override
            //                    public void onClick(View v) {
            //                        data.unlockLevel();
            //                        ClassicGameActivity.comeToMe(mContext, data.level);
            //                    }
            //                });
            //        }

        }

        @Override
        public int getItemCount() {
            return mDataList == null ? 0 : mDataList.size();
        }

        public class NormalViewHolder extends RecyclerView.ViewHolder {
            ImageView mImageView;

            public NormalViewHolder(View view) {
                super(view);
                mImageView = (ImageView) view.findViewById(R.id.image_view);
            }
        }

    }

    public static Bundle makeBundle() {
        Bundle bundle = new Bundle();
        return bundle;
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
