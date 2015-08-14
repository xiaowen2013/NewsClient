package cn.xiaowen.news.activity.controller;

import android.content.Context;
import android.view.View;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity.controller
 * @类名: BaseController
 * @创建者: 小温
 * @创建时间: 2015-8-14 下午6:59:52
 * @描述: 所有控制器的基类
 * 
 * @svn版本: $Rev: 9 $
 * @更新人: $Author: wen $
 * @更新时间: $Date: 2015-08-15 00:07:52 +0800 (Sat, 15 Aug 2015) $
 * @更新描述: TODO
 */
public abstract class BaseController {

	protected Context mContext;
	protected View mRootView;

	public BaseController(Context context) {
		this.mContext = context;
		// 加载视图
		mRootView = initView(context);
	}

	/**
	 * 初始化View
	 * 
	 * @param context
	 * @return
	 */
	public abstract View initView(Context context);

	/**
	 * 获取View
	 * 
	 * @return
	 */
	public View getRootView() {
		return mRootView;
	}

	/**
	 * 加载数据的方法 , 方子类自己去触发调用
	 */
	public void initData() {
	}
}
