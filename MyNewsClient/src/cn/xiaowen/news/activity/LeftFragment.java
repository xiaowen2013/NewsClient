package cn.xiaowen.news.activity;

import android.view.View;
import android.widget.TextView;

public class LeftFragment extends BaseFragment {

	@Override
	protected View initView() {
		 TextView tv = new TextView(mActivity);
		 tv.setText("菜单部分");

//		View view = View.inflate(mActivity, R.layout.fra_content, null);
		return tv;
	}
}
