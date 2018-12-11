package com.xiao.demo.materialdesign;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiao.demo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 萧
 * @create at 2018/10/28 下午3:51
 */
public class ViewPagerAcivity extends Activity {

    public static void start(Context context) {
        Intent starter = new Intent(context, ViewPagerAcivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_viewpager);
        ButterKnife.bind(this);
        adapter = new MyAdapter(this, null);
        viewPager.setAdapter(adapter);
    }

    class MyAdapter extends PagerAdapter {
        private final LayoutInflater layoutInflater;

        Context context;

        List<View> viewList;

        public MyAdapter(Context context, List<View> viewList) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = layoutInflater.inflate(R.layout.layout_cardview_viewpager, container, false);
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
}
