package cn.xiaowen.news.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * 
 * @项目名: 	MyNewsClient
 * @包名:	cn.xiaowen.news.view
 * @类名:	NoScrollViewPager
 * @创建者:	小温
 * @创建时间:	2015-8-15	上午12:24:32 
 * @描述:	这个是用来禁止滑动的
 * 
 * @svn版本:	$Rev: 11 $
 * @更新人:	$Author: wen $
 * @更新时间:	$Date: 2015-08-15 01:10:34 +0800 (Sat, 15 Aug 2015) $
 * @更新描述:	TODO
 */
public class NoScrollViewPager extends LazyViewPager {

	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NoScrollViewPager(Context context) {
		this(context,null);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return false;
	}

}
