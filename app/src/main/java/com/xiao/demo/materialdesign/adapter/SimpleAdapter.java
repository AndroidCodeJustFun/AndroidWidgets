package com.xiao.demo.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiao on 2017/9/11.
 */

public class SimpleAdapter extends BaseRecyclerViewAdapter<String> {

	public static final String TAG = "SimpleAdapter";

	public SimpleAdapter(Context mContext) {
		super(mContext);
	}

	public SimpleAdapter(List<String> mDataList, Context mContext) {
		super(mDataList, mContext);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mLayoutInflater.inflate(R.layout.layout_single_text_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((ViewHolder) holder).showItem(mDataList.get(position));
	}

	class ViewHolder extends BaseViewHolder {

		@BindView(R.id.sinble_text_tv_content)
		TextView tvContent;
		@BindView(R.id.single_text_cardview)
		CardView cardview;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}

		@Override
		public void showItem(String s) {
			if (tvContent != null)
				tvContent.setText(s);
			else Log.e(TAG, "showItem: tvContent is null");
		}
	}

}
