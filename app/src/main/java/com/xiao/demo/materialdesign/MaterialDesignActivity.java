package com.xiao.demo.materialdesign;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xiao.demo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 萧
 * @create at 2018/10/28 下午3:52
 */
public class MaterialDesignActivity extends Activity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MaterialDesignActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materialdesign);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.materialdesign_btn_viewpager)
    void onMaterialdesignBtnViewpagerClick() {
        ViewPagerAcivity.start(MaterialDesignActivity.this);
    }
}
