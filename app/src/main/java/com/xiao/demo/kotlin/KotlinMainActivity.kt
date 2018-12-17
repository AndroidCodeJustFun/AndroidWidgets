package com.xiao.demo.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xiao.demo.R

class KotlinMainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent()
            intent.setClass(context, KotlinMainActivity::class.java)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.main_btn_animation -> ParallaxAnimationActivity.start(this@KotlinMainActivity)
//            R.id.main_btn_arouter -> ""
//            R.id.main_btn_design -> ""
//            R.id.main_btn_imageloader -> ImageLoaderActivity.start(this@KotlinMainActivity)
//            R.id.main_btn_widget -> WidgetActivity.start(this@KotlinMainActivity)
//            R.id.main_btn_retrofit -> Toast.makeText(this@KotlinMainActivity, "Retrofit", Toast.LENGTH_LONG).show()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_activity_init);
//        main_btn_animation.setOnClickListener(this);
//        main_btn_arouter.setOnClickListener(this);
//        main_btn_design.setOnClickListener(this);
//        main_btn_imageloader.setOnClickListener(this);
//        main_btn_retrofit.setOnClickListener(this);
//        main_btn_widget.setOnClickListener(this);
    }

//    override fun onResume() {
//        super.onResume()
//    }

//    override fun onPause() {
//        super.onPause()
//    }
}
