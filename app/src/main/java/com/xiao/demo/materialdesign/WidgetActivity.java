package com.xiao.demo.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xiao.demo.R;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.customview.CustomViewActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xiao on 2017/9/5.
 */

public class WidgetActivity extends BaseActivity {

    public static final String TAG = "WidgetActivity";

    @BindView(R.id.toolbar_title)
    Toolbar toolbarTitle;

    @BindView(R.id.toolbar_tv_title)
    TextView toolbarTvTitle;

    @BindView(R.id.widget_actionbar)
    CardView widgetActionbar;

    @BindView(R.id.widget_btn_coordinatorlayout)
    Button btn_coordinatorlayout;
//	@BindView(R.id.widget_btn_expandingcollapsing_toolbars)
//	Button btn_excotoolbars;

    public static void start(Context context) {
        Intent starter = new Intent(context, WidgetActivity.class);
        context.startActivity(starter);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_widget;
    }

    @Override
    public void initView() {
        widgetActionbar.setOnClickListener(view ->
                ActionBarActivity.start(WidgetActivity.this)
        );
        setSupportActionBar(toolbarTitle);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_white_24dp));
        toolbarTitle.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
        toolbarTitle.setOnMenuItemClickListener(menu -> {
            Log.e(TAG, "initView: groupId = " + menu.getGroupId() + "  itemId = " + menu.getItemId() + " text " + menu.getTitle());
            Toast.makeText(this, "menu.getTitle():" + menu.getTitle(), Toast.LENGTH_SHORT).show();
            return false;
        });
        btn_coordinatorlayout.setOnClickListener(view -> CoordinatorLayoutActivity.start(WidgetActivity.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_more, menu);
        return true;
    }

    @Override
    public void initData() {
        toolbarTvTitle.setText("WidgetActivity");
    }

    @OnClick({R.id.widget_btn_customview})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.widget_btn_customview:
                CustomViewActivity.start(WidgetActivity.this);
                break;
        }
    }
}
