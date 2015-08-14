package cn.xiaowen.news.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 
 * @项目名: MyNewsClient
 * @包名: cn.xiaowen.news.utils
 * @类名: ShaPreferenUtils
 * @创建者: 小温
 * @创建时间: 2015-8-13 下午9:18:59
 * @描述: 这个工具类用于存储固定的配置信息
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class ShaPreferenUtils {

	private static final String FILENAME_CONFIG = "config";
	/**
	 * 声明一个 SharedPreferences 的变量
	 */
	private static SharedPreferences mPs;

	/**
	 * 获取 SharedPreferences
	 * 
	 * @param context
	 * @return
	 */
	public static SharedPreferences getSharedPreferences(Context context) {

		if (mPs == null) {
			mPs = context.getSharedPreferences(FILENAME_CONFIG,
					Context.MODE_PRIVATE);
		}
		return mPs;
	}

	/**
	 * 获取对应的 key - value值 boolean类型
	 * 
	 * @param context
	 * @param key
	 * @return 要是没有对应的值 , 返回false
	 */
	public static boolean getBoolean(Context context, String key) {

		return getBoolean(context, key, false);
	}

	/**
	 * 获取对应的 key - value值 ,要是没有 ,则返回 defValue boolean类型
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(Context context, String key,
			boolean defValue) {

		SharedPreferences preferences = getSharedPreferences(context);

		boolean result = preferences.getBoolean(key, defValue);
		return result;
	}

	/**
	 * 存储 key-values boolean类型
	 * 
	 * @param context
	 * @param key
	 * @param values
	 */
	public static void pullBoolean(Context context, String key, boolean values) {
		// 获取 SharedPreferences
		SharedPreferences ps = getSharedPreferences(context);
		// 获取编辑器
		Editor edit = ps.edit();
		// 添加保存的信息
		edit.putBoolean(key, values);
		// 提交
		edit.commit();
	}

	/**
	 * 获取对应的 key - value值 String 类型
	 * 
	 * @param context
	 * @param key
	 * @return 要是没有对应的值 , 返回 null
	 */
	public static String getString(Context context, String key) {

		return getString(context, key, null);
	}

	/**
	 * 获取对应的 key - value值 ,要是没有 ,则返回 defValue String 类型
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getString(Context context, String key, String defValue) {

		SharedPreferences preferences = getSharedPreferences(context);

		String result = preferences.getString(key, defValue);
		return result;
	}

	/**
	 * 存储 key-values String 类型
	 * 
	 * @param context
	 * @param key
	 * @param values
	 */
	public static void pullString(Context context, String key, String values) {
		// 获取 SharedPreferences
		SharedPreferences ps = getSharedPreferences(context);
		// 获取编辑器
		Editor edit = ps.edit();
		// 添加保存的信息
		edit.putString(key, values);
		// 提交
		edit.commit();
	}
}
