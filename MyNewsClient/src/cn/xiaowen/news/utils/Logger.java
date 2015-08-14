package cn.xiaowen.news.utils;

import android.util.Log;

/**
 * 
 * @项目名: 	MyNewsClient
 * @包名:	cn.xiaowen.news.utils
 * @类名:	Logger
 * @创建者:	小温
 * @创建时间:	2015-8-13	下午9:18:05 
 * @描述:	这是用来显示bug信息的
 * 
 * @svn版本:	$Rev$
 * @更新人:	$Author$
 * @更新时间:	$Date$
 * @更新描述:	TODO
 */
public class Logger {

	/**
	 * 输出日志的级别
	 */
	private static final int LEN_V = 0;
	private static final int LEN_D = 1;
	private static final int LEN_I = 2;
	private static final int LEN_W = 3;
	private static final int LEN_E = 4;

	/**
	 * 日志是否可见
	 */
	private static final boolean isEnable = true;

	/**
	 * 当前日志级别
	 */
	private static final int LOG_LENVEN = LEN_V;

	/**
	 * 输出全部信息
	 * 
	 * @param tag
	 *            目标
	 * @param msg
	 *            打印的信息
	 */
	public static void v(String tag, String msg) {
		// 判断当前日志是否可见
		if (!isEnable) {
			return;
		}
		// 判断输出的内容
		if (LOG_LENVEN <= LEN_V) {
			// 输出全部的信息
			Log.v(tag, msg);
		}
	}

	/**
	 * 输出调试信息
	 * 
	 * @param tag
	 *            目标
	 * @param msg
	 *            打印的信息
	 */
	public static void d(String tag, String msg) {
		// 判断当前日志是否可见
		if (!isEnable) {
			return;
		}
		// 判断输出的内容
		if (LOG_LENVEN <= LEN_D) {
			// 输出全部的信息
			Log.d(tag, msg);
		}
	}

	/**
	 * 输出info信息
	 * 
	 * @param tag
	 *            目标
	 * @param msg
	 *            打印的信息
	 */
	public static void i(String tag, String msg) {
		// 判断当前日志是否可见
		if (!isEnable) {
			return;
		}
		// 判断输出的内容
		if (LOG_LENVEN <= LEN_I) {
			// 输出全部的信息
			Log.i(tag, msg);
		}
	}

	/**
	 * 输出警告信息
	 * 
	 * @param tag
	 *            目标
	 * @param msg
	 *            打印的信息
	 */
	public static void w(String tag, String msg) {
		// 判断当前日志是否可见
		if (!isEnable) {
			return;
		}
		// 判断输出的内容
		if (LOG_LENVEN <= LEN_W) {
			// 输出全部的信息
			Log.w(tag, msg);
		}
	}

	/**
	 * 输出错误信息
	 * 
	 * @param tag
	 *            目标
	 * @param msg
	 *            打印的信息
	 */
	public static void e(String tag, String msg) {
		// 判断当前日志是否可见
		if (!isEnable) {
			return;
		}
		// 判断输出的内容
		if (LOG_LENVEN <= LEN_E) {
			// 输出全部的信息
			Log.e(tag, msg);
		}
	}
}
