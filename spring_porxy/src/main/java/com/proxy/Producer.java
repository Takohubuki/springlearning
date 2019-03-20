package com.proxy;

public class Producer implements IProducer {
    public int sellProduct(Integer money) {
        System.out.println("sold out");
        return money;
    }
}
