package cn.xiaowen.news.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import cn.xiaowen.news.R;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity
 * @类名: HomeActivity
 * @创建者: 小温
 * @创建时间: 2015-8-13 下午9:15:04
 * @描述: 这是主页面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HomeActivity extends SlidingFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// 设置菜单布局
		setBehindContentView(R.layout.fragment_home_left_behind);

		// 获得菜单
		SlidingMenu slidingMenu = getSlidingMenu();
		// 设置宽度
		slidingMenu.setBehindWidth(160);
		// 设置触拉的模式 Touch mode Above;
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// 设置behind scrollScale
		slidingMenu.setBehindScrollScale(0.5f);

		// 设置fade
		slidingMenu.setFadeDegree(0.5f);

		// 拆分左右
		initView();
	}

	private void initView() {
		// 获取 Fragment 管理器 getSupportFragmentManager();
		FragmentManager manager = getSupportFragmentManager();
		// 开启事务
		FragmentTransaction bt = manager.beginTransaction();
		// 加载事务
		// 加载左边
		// containerViewId 显示的 Fragment 的id
		// fragment 的java类
		bt.replace(R.id.home_menu_container, new LeftFragment());
		// 加载内容
		// replace
		bt.replace(R.id.home_content_container, new ContentFragment());
		// 提交信息
		bt.commit();
	}
}
