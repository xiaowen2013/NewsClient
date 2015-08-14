package cn.xiaowen.news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity
 * @类名: BaseFragment
 * @创建者: 小温
 * @创建时间: 2015-8-15 上午12:34:23
 * @描述: 所有 Fragment 的基类
 * 
 * @svn版本: $Rev: 10 $
 * @更新人: $Author: wen $
 * @更新时间: $Date: 2015-08-15 00:36:34 +0800 (Sat, 15 Aug 2015) $
 * @更新描述: TODO
 */
public abstract class BaseFragment extends Fragment {

	protected Activity mActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 获取宿主
		mActivity = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 加载布局
		return initView();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// 加载数据
		initData();
	}

	/**
	 * 初始化数据
	 * 
	 * @return
	 */
	protected abstract View initView();

	/**
	 * 加载数据
	 */
	protected void initData() {
	}
}
