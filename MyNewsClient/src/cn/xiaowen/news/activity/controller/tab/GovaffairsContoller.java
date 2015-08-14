package cn.xiaowen.news.activity.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import cn.xiaowen.news.activity.controller.TabContrller;

public class GovaffairsContoller extends TabContrller {

	private TextView mTv;

	public GovaffairsContoller(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		mTv.setText("政务");
		// 设置标题
		mTvTitle.setText("政务");
		// 设置图标
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
