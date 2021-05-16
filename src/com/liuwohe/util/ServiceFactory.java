package com.liuwohe.util;

public class ServiceFactory {
    //传递ZS对象，取得LS对象
    public static Object getService(Object service){
       return new TransactionInvocationHandler(service).getProxy();
    }
}
