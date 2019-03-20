package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Producer p = new Producer();
        IProducer o = (IProducer) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rv = null;
                Integer money = (Integer) args[0];
                if ("sellProduct".equals(method.getName())) {
                    rv = method.invoke(p, money);
                }
                return rv;
            }
        });
        int i = o.sellProduct(100);
        System.out.println(i);
    }
}