package com.xiao.demo.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseRecyclerViewAdapter;
import com.xiao.demo.materialdesign.items.Item;
import com.xiao.demo.materialdesign.items.RecyclerNormalBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiao on 2017/9/13.
 */

public class ImageTextAdapter extends BaseRecyclerViewAdapter<RecyclerNormalBean<Item>> {

	public ImageTextAdapter(Context mContext) {
		super(mContext);
	}

	public ImageTextAdapter(List<RecyclerNormalBean<Item>> mDataList, Context mContext) {
		super(mDataList, mContext);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mLayoutInflater.inflate(R.layout.layout_imagetext_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((ViewHolder) holder).showItem(getItem(position));
	}

	class ViewHolder extends BaseViewHolder {

		public static final String TAG = "ViewHolder";

		@BindView(R.id.imagetext_img)
		ImageView img;

		@BindView(R.id.imagetext_tv_content)
		TextView tv_content;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			Log.e(TAG, "ViewHolder: " + img + "  " + tv_content);
		}

		@Override
		public void showItem(RecyclerNormalBean<Item> itemRecyclerNormalBean) {
			Item item = itemRecyclerNormalBean.getT();
			Log.e(TAG, "showItem: " + item);
//			GlideApp.with(mContext).load(item.getmDrawableRes()).centerCrop().into(img);
			try {
				img.setImageResource(item.getmDrawableRes());
				tv_content.setText(item.getmTitle());
				if (itemListener != null) {
					rootView.setOnClickListener(view -> itemListener.onItemClick(itemRecyclerNormalBean));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
