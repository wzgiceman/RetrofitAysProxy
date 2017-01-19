package com.wzgiceman.retrofitaysproxy.impl;

import android.util.Log;

import com.wzgiceman.retrofitaysproxy.interfaces.HttpRequest;

/**
 * 委托类
 * Created by WZG on 2017/1/19.
 */

public class HttpRequestImpl implements HttpRequest {
    @Override
    public void request() {
        Log.e("tag","-------->htt请求");
    }
}
