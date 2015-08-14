package cn.xiaowen.news.activity;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import cn.xiaowen.news.R;
import cn.xiaowen.news.activity.controller.BaseController;
import cn.xiaowen.news.activity.controller.tab.GovaffairsContoller;
import cn.xiaowen.news.activity.controller.tab.HomeContoller;
import cn.xiaowen.news.activity.controller.tab.SettingContoller;
import cn.xiaowen.news.activity.controller.tab.SmartserviceContoller;
import cn.xiaowen.news.activity.controller.tab.newsHomeContoller;
import cn.xiaowen.news.utils.Logger;
import cn.xiaowen.news.view.NoScrollViewPager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity
 * @类名: ContentFragment
 * @创建者: 小温
 * @创建时间: 2015-8-14 下午6:33:59
 * @描述: Home 的数据加载
 * 
 * @svn版本: $Rev: 11 $
 * @更新人: $Author: wen $
 * @更新时间: $Date: 2015-08-15 01:10:34 +0800 (Sat, 15 Aug 2015) $
 * @更新描述: TODO
 */
public class ContentFragment extends BaseFragment {

	private static final String TAG = "ContentFragment";
	private NoScrollViewPager mViewPager;
	private List<BaseController> mData;
	private RadioGroup mRg;
	private int mCurrentTab; // 当前显示的页面

	@Override
	protected View initView() {
		// TextView tv = new TextView(mActivity);
		// tv.setText("显示部分");

		View view = View.inflate(mActivity, R.layout.fra_content, null);
		mRg = (RadioGroup) view.findViewById(R.id.contant_rg);

		mViewPager = (NoScrollViewPager) view.findViewById(R.id.content_fra_pager);

		return view;
	}

	@Override
	protected void initData() {
		super.initData();
		// 设置数据
		mData = new ArrayList<BaseController>();

		mData.add(new HomeContoller(mActivity));
		mData.add(new newsHomeContoller(mActivity));
		mData.add(new SmartserviceContoller(mActivity));
		mData.add(new GovaffairsContoller(mActivity));
		mData.add(new SettingContoller(mActivity));

		// 设置 ViewPager 的适配器
		mViewPager.setAdapter(new PagerAdapter());

		// 设置默认的显示 ,新闻
		mRg.check(R.id.content_rb_news);
		mViewPager.setCurrentItem(1);

		// 设置 RadioGroup 的监听事件
		mRg.setOnCheckedChangeListener(new RadioGroupListener());

	}

	// OnCheckedChangeListener
	private class RadioGroupListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// 判断点击的是哪个button

			switch (checkedId) {
			case R.id.content_rb_home:
				// 主页
				mCurrentTab = 0;
				setSlidingMenu(false);
				break;
			case R.id.content_rb_news:
				// 新闻业
				mCurrentTab = 1;
				setSlidingMenu(true);
				break;
			case R.id.content_rb_smartservice:
				// 智慧服务
				mCurrentTab = 2;
				setSlidingMenu(true);
				break;
			case R.id.content_rb_govaffairs:
				// 政务
				mCurrentTab = 3;
				setSlidingMenu(true);
				break;
			case R.id.content_rb_setting:
				// 设置
				mCurrentTab = 4;
				setSlidingMenu(false);
				break;

			default:
				break;
			}

			// 点击了那个就显示那个
			mViewPager.setCurrentItem(mCurrentTab);
		}

	}

	/**
	 * 设置当前是否可用拉出左边的菜单
	 * 
	 * @param flag
	 */
	private void setSlidingMenu(boolean flag) {
		SlidingMenu slidingMenu = ((HomeActivity) (mActivity)).getSlidingMenu();
		slidingMenu.setTouchModeAbove(flag ? SlidingMenu.TOUCHMODE_FULLSCREEN
				: SlidingMenu.TOUCHMODE_NONE);
	}

	private class PagerAdapter extends android.support.v4.view.PagerAdapter {

		@Override
		public int getCount() {
			return mData.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			Logger.d(TAG, "加载了页面: " + position);
			BaseController controller = mData.get(position);
			View rootView = controller.getRootView();

			container.addView(rootView);
			// 加载数据
			controller.initData();
			return rootView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			Logger.d(TAG, "销毁了页面 :" + position);
			container.removeView((View) object);
		}
	}
}
