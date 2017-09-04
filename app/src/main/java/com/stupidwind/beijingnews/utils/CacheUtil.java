package com.stupidwind.beijingnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 蠢风 on 2017/9/4.
 * 缓存工具类
 */

public class CacheUtil {


    public static boolean getBoolean(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences("stupidwind", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }
}
