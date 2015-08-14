package cn.xiaowen.news.activity.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import cn.xiaowen.news.activity.controller.TabContrller;

public class HomeContoller extends TabContrller {

	private TextView mTv;

	public HomeContoller(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		mTv.setText("首页");
		// 设置标题
		mTvTitle.setText("首页");
		mIv.setVisibility(View.GONE);
	}

	@Override
	protected View initContentView(Context context) {
		mTv = new TextView(context);

		mTv.setTextColor(Color.RED);
		mTv.setTextSize(22);
		return mTv;
	}

}
