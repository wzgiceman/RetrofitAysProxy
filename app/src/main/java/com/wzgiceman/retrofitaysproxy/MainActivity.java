package com.wzgiceman.retrofitaysproxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wzgiceman.retrofitaysproxy.impl.HttpRequestImpl;
import com.wzgiceman.retrofitaysproxy.interfaces.HttpRequest;
import com.wzgiceman.retrofitaysproxy.proxy.HttpRequestJDKProxy;
import com.wzgiceman.retrofitaysproxy.proxy.HttpRequestProxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*静态代理*/
        HttpRequestImpl request = new HttpRequestImpl();
        HttpRequestProxy proxy = new HttpRequestProxy(request);
        proxy.request();


        /*jdk动态代理*/
        HttpRequestJDKProxy jdkProxy = new HttpRequestJDKProxy();
        HttpRequest httpRequest = (HttpRequest) jdkProxy.bind(request);
        httpRequest.request();


         /*cglib动态代理*/
//        HttpRequestCglibProxy httpRequestCglibProxy=new HttpRequestCglibProxy();
//        HttpRequest httpRequestCglib = (HttpRequest) httpRequestCglibProxy.getInstance(new HttpRequestCglibImpl());
//        httpRequestCglib.request();
    }
}
