package cn.xiaowen.news.activity.controller;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.xiaowen.news.R;
import cn.xiaowen.news.utils.Logger;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity.controller
 * @类名: TabContrller
 * @创建者: 小温
 * @创建时间: 2015-8-14 下午7:33:30
 * @描述: 这是显示头顶的标题
 * 
 * @svn版本: $Rev: 9 $
 * @更新人: $Author: wen $
 * @更新时间: $Date: 2015-08-15 00:07:52 +0800 (Sat, 15 Aug 2015) $
 * @更新描述: TODO
 */
public abstract class TabContrller extends BaseController {

	private static final String TAG = "TabContrller";
	protected ImageView mIv;
	protected TextView mTvTitle;
	protected FrameLayout mContentContainer;

	public TabContrller(Context context) {
		super(context);
	}

	@Override
	public View initView(Context context) {
		Logger.d(TAG, "TabContrller 的 initView走啦 ....");
		View view = View.inflate(context, R.layout.content_title, null);
		mIv = (ImageView) view.findViewById(R.id.tabcontroll_img);
		mTvTitle = (TextView) view.findViewById(R.id.tabcontroll_title);

		mContentContainer = (FrameLayout) view
				.findViewById(R.id.tab_content_container);

		// 将不同区域显示的加载进来
		mContentContainer.addView(initContentView(context));
		return view;
	}

	/**
	 * 内容区域View的加载
	 * 
	 * @param context
	 * @return
	 */
	protected abstract View initContentView(Context context);
}
