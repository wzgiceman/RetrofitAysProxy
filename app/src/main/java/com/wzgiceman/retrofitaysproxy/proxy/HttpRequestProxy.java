package com.wzgiceman.retrofitaysproxy.proxy;

import android.util.Log;

import com.wzgiceman.retrofitaysproxy.impl.HttpRequestImpl;
import com.wzgiceman.retrofitaysproxy.interfaces.HttpRequest;

/**
 * 代理类-静态
 * Created by WZG on 2017/1/19.
 */

public class HttpRequestProxy implements HttpRequest {

    HttpRequestImpl httpRequest;


    public HttpRequestProxy(HttpRequestImpl httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public void request() {
        Log.e("tag","静态--------->http请求前");
        httpRequest.request();
        Log.e("tag","静态--------->http请求后");
    }

}
