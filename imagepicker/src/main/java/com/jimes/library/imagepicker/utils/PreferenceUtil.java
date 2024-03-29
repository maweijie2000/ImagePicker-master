package com.jimes.library.imagepicker.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 *偏好设置与SPUtils一样
 */
public class PreferenceUtil {

	private static SharedPreferences sp = null;
	private static PreferenceUtil p=null;

	private PreferenceUtil(){}

	public static PreferenceUtil getInstance(){
		if(p==null){
		    synchronized (PreferenceUtil.class) {
                if(p==null) p = new PreferenceUtil();
            }
		}

		return p;
	}

	public void init(Context c, String name) {
		sp = c.getSharedPreferences(name, 0);
	}

	public void clear(){
		sp.edit().clear().apply();
	}

	public void putBool(String key, boolean value) {
		sp.edit().putBoolean(key, value).apply();
	}

	public boolean getBool(String key, boolean defValue) {
		return sp.getBoolean(key, defValue);
	}

	public void putInt(String key, int value) {
		sp.edit().putInt(key, value).apply();
	}

	public int getInt(String key, int defValue) {
		return sp.getInt(key, defValue);
	}

	public void putLong(String key, long value) {
		sp.edit().putLong(key, value).apply();
	}

	public long getLong(String key, long defValue) {
		return sp.getLong(key, defValue);
	}

	public void putString(String key, String value) {
		sp.edit().putString(key, value).apply();
	}

	public String getString(String key, String defValue) {
		return sp.getString(key, defValue);
	}

	public Set<String> getStringSet(String key, Set<String> defValue){
		return sp.getStringSet(key, defValue);
	}
	public void putStringSet(String key, Set<String> value) {
		sp.edit().putStringSet(key, value).apply();
	}

	public float getFloat(String key, float defValue) {
		return sp.getFloat(key, defValue);
	}
	public void putFloat(String key, float value) {
		sp.edit().putFloat(key, value).apply();
	}
	public void remove(String key) {
		sp.edit().remove(key).apply();
	}

}
