package cn.xiaowen.news.activity.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import cn.xiaowen.news.activity.controller.TabContrller;

public class SettingContoller extends TabContrller {

	private TextView mTv;

	public SettingContoller(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		mTv.setText("设置");
		mTvTitle.setText("设置");
		mIv.setVisibility(View.GONE);
	}

	@Override
	protected View initContentView(Context context) {
		mTv = new TextView(context);

		mTv.setTextColor(Color.RED);
		mTv.setTextSize(22);

		// 设置标题
		return mTv;
	}

}
