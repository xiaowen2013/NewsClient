package cn.xiaowen.news.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import cn.xiaowen.news.R;
import cn.xiaowen.news.domain.IContent;
import cn.xiaowen.news.utils.Logger;
import cn.xiaowen.news.utils.ShaPreferenUtils;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.activity
 * @类名: ComGuideActivity
 * @创建者: 小温
 * @创建时间: 2015-8-13 下午9:16:30
 * @描述: 这是引导页面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: 完成引导页面
 */
public class ComGuideActivity extends Activity {

	private static final String TAG = "ComGuideActivity";
	private ViewPager mVager;
	private LinearLayout mLlPoint;
	private ImageView mPointFocus;
	private Button mBtn;

	/**
	 * 两个静态点的距离
	 */
	private int mPointShape;
	/**
	 * 创建List ,封装信息
	 */
	private List<ImageView> mDataIma;

	/**
	 * 添加的图片资源
	 */
	private static final int[] IMA = { R.drawable.guide_1, R.drawable.guide_2,
			R.drawable.guide_3 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		mVager = (ViewPager) findViewById(R.id.guide_pager);
		mLlPoint = (LinearLayout) findViewById(R.id.guide_ll_point);
		mPointFocus = (ImageView) findViewById(R.id.guide_ll_pointfocus);
		mBtn = (Button) findViewById(R.id.guide_btn);
		// 不显示按钮
		mBtn.setVisibility(View.GONE);
		// 加载数据
		initData();

		// 设置适配器
		mVager.setAdapter(new PagerAdapter());
		// 设置 mVager 的监听器
		mVager.setOnPageChangeListener(new PagerLiatent());

		// 设置布局的加载完成的监听
		mPointFocus.getViewTreeObserver().addOnGlobalLayoutListener(
		// OnGlobalLayoutListener
				new OnGlobalLayoutListener() {

					public void onGlobalLayout() {
						// 布局发生改变的时候的回调
						mPointShape = mLlPoint.getChildAt(1).getLeft()
								- mLlPoint.getChildAt(0).getLeft();
						mPointFocus.getViewTreeObserver()
								.removeGlobalOnLayoutListener(this);
					}
				});

		// 设置 按钮的点击事件
		mBtn.setOnClickListener(new BtnOnclickListener());
	}

	private class BtnOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// 把信息设置为不是第一次进入
			ShaPreferenUtils.pullBoolean(ComGuideActivity.this,
					IContent.FIRST_GUIDE, false);

			// 点击了按钮 , 进入主页
			Intent intent = new Intent(ComGuideActivity.this,
					HomeActivity.class);
			startActivity(intent);
			finish();
		}
	}

	/**
	 * 加载数据
	 */
	private void initData() {
		mDataIma = new ArrayList<ImageView>();
		for (int i = 0; i < IMA.length; i++) {
			// 创建ImagerView
			ImageView iv = new ImageView(this);
			// 设置图片
			iv.setImageResource(IMA[i]);
			// 设置宽高
			iv.setScaleType(ScaleType.FIT_XY);

			// 画点
			ImageView point = new ImageView(this);
			// 设置图片
			point.setImageResource(R.drawable.guide_shape_narmar);
			// 大小设置
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

			if (i != 0) {
				params.leftMargin = 10;
			}
			// 添加到list
			mDataIma.add(iv);
			// 添加静态的点
			mLlPoint.addView(point, params);
		}
	}

	/**
	 * 
	 * 设置监听器
	 */
	private class PagerLiatent implements OnPageChangeListener {

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			// 滚动的时候
			Logger.d(TAG, "页面滚动的时候..." + position);
			// position 在那个页面滑动
			// positionOffset 滑动的比例值
			// positionOffsetPixels 滑动的像素点
			// 两个点之间的距离 乘以 滑动的比值 等于 相对的位置距离
			int magLaf = (int) (mPointShape * position + positionOffset
					* mPointShape + 0.5);
			// 动态设置点
			RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) mPointFocus
					.getLayoutParams();
			params.leftMargin = magLaf;
			mPointFocus.setLayoutParams(params);
		}

		@Override
		public void onPageSelected(int position) {
			// 选中的时候
			Logger.d(TAG, "选中的时候..." + position);
			if (position == mDataIma.size() - 1) {
				// 最后一个 , 显示按钮
				mBtn.setVisibility(View.VISIBLE);
			} else {
				mBtn.setVisibility(View.GONE);
			}
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			// 页面状态改变的时候
			Logger.d(TAG, "页面状态改变的时候...");
		}
	}

	/**
	 * 适配器
	 * 
	 */
	private class PagerAdapter extends android.support.v4.view.PagerAdapter {

		@Override
		public int getCount() {
			if (mDataIma != null) {
				return mDataIma.size();
			}
			return 0;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			// 初始化View
			ImageView view = mDataIma.get(position);
			// 添加到 container
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
}
