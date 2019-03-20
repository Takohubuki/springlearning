package com.proxy;

public class Transmit {
    public void addTr(UserServiceImpl usi){
        usi.add();
    }

    public void updateTr(UserServiceImpl usi){
        usi.update();
    }

    public void deleteTr(UserServiceImpl usi){
        usi.delete();
    }
}
