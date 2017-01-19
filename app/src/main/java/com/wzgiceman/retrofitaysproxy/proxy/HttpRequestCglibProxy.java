package com.wzgiceman.retrofitaysproxy.proxy;

import android.util.Log;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理类
 * Created by WZG on 2017/1/19.
 */

public class HttpRequestCglibProxy implements MethodInterceptor {

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Log.e("tag", "Cglib--------->http请求前");
        Object result= methodProxy.invokeSuper(o, objects);
        Log.e("tag", "Cglib--------->http请求后");
        return result;

    }
}
