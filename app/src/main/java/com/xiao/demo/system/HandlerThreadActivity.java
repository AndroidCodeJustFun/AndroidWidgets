package com.xiao.demo.system;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.xiao.demo.R;

import butterknife.BindView;

public class HandlerThreadActivity extends AppCompatActivity {

	@BindView(R.id.handlerthread_btn_new)
	Button btn_new;

	Handler handler = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			return false;
		}
	}) {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
		}

		@Override
		public void dispatchMessage(Message msg) {
			super.dispatchMessage(msg);
		}

		@Override
		public String getMessageName(Message message) {
			return super.getMessageName(message);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_thread);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		btn_new.setOnClickListener(v -> {
			new HandlerThread("HandlerThread Test") {

			};
		});


	}

	class MyIntentService extends IntentService {

		/**
		 * Creates an IntentService.  Invoked by your subclass's constructor.
		 *
		 * @param name Used to name the worker thread, important only for debugging.
		 */
		public MyIntentService(String name) {
			super(name);
		}

		@Override
		protected void onHandleIntent(@Nullable Intent intent) {

		}
	}

}
