package com.proxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
        Transmit tr = new Transmit();
        UserService o = (UserService) Proxy.newProxyInstance(usi.getClass().getClassLoader(), usi.getClass().getInterfaces(), (proxy, method, args1) -> {


            if("addTr".equals(method.getName())){
                method.invoke(usi,args1);
            }else if("updateTr".equals(method.getName())){
                method.invoke(usi,args1);
            }else if("deleteTr".equals(method.getName())){
                method.invoke(usi,args1);
            }
            return null;
        });
        o.update();
        o.delete();
        o.add();
    }
}