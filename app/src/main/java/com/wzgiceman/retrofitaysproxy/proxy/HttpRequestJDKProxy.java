package com.wzgiceman.retrofitaysproxy.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理-jdk
 * Created by WZG on 2017/1/19.
 */

public class HttpRequestJDKProxy implements InvocationHandler {

    private Object target;
    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.e("tag","jdk--------->http请求前");
        Object  result=method.invoke(target, objects);
        Log.e("tag","jdk--------->http请求后");
        return result;
    }
}
