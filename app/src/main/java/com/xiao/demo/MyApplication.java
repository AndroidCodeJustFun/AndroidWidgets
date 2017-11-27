package com.xiao.demo;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xiao on 2017/9/4.
 */

public class MyApplication extends Application {

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	class MYS extends Service{

		@Nullable
		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
		}
	}

}
