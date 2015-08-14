package cn.xiaowen.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import cn.xiaowen.news.R;
import cn.xiaowen.news.domain.IContent;
import cn.xiaowen.news.utils.ShaPreferenUtils;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity
 * @类名: SplashActivity
 * @创建者: 小温
 * @创建时间: 2015-8-13 下午9:15:32
 * @描述: 这是Splash页面 , 展示logo
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: 完成展示
 */
public class SplashActivity extends Activity {

	private RelativeLayout mRl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		mRl = (RelativeLayout) findViewById(R.id.spalsh_rl);

		// 开启动画
		startAnimation();

		// 开启线程 睡会
		new Thread() {
			public void run() {

				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						comHome();
					}
				});
			};

		}.start();

	}

	/**
	 * 进入引导页面或者进入主页
	 */
	private void comHome() {
		// 进入引导页面或者进入主页
		// 判断是不是第一次
		boolean result = ShaPreferenUtils.getBoolean(this,
				IContent.FIRST_GUIDE, true);
		if (result) {
			// 第一次 , 进入引导页面
			Intent intent = new Intent(this, ComGuideActivity.class);
			startActivity(intent);
			finish();
		} else {
			// 不是第一次,进入主页面
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
			finish();
		}
	}

	private void startAnimation() {
		// 设置动画
		// 旋转 0 到 360
		RotateAnimation rotate = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_PARENT, 0.5f,
				Animation.RELATIVE_TO_PARENT, 0.5f);
		// 缩放
		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
				Animation.RELATIVE_TO_PARENT, 0.5f,
				Animation.RELATIVE_TO_PARENT, 0.5f);
		// 透明
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		// 创建动画集
		AnimationSet set = new AnimationSet(false);
		// 添加动画
		set.addAnimation(rotate);
		set.addAnimation(scale);
		set.addAnimation(alpha);
		// 设置动画的时长
		set.setDuration(1500);
		// 让mRl 做动画
		mRl.setAnimation(set);
		// 开始动画
		set.start();

	}
}
