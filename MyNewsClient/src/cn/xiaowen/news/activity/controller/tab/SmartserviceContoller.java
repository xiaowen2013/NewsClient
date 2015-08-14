package cn.xiaowen.news.activity.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import cn.xiaowen.news.activity.controller.TabContrller;

public class SmartserviceContoller extends TabContrller {

	private TextView mTv;

	public SmartserviceContoller(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		mTv.setText("智慧服务");
		// 设置标题
		mTvTitle.setText("智慧服务");
		mIv.setVisibility(View.VISIBLE);
	}

	@Override
	protected View initContentView(Context context) {
		mTv = new TextView(context);

		mTv.setTextColor(Color.RED);
		mTv.setTextSize(22);
		return mTv;
	}

}
