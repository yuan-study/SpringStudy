package com.pingan.myspring.aop;

public class Person {
    public void run() {
        System.err.println("走路。。。。。。");
    }

    public void say() {
        System.err.println("说话。。。。。。");
    }

    public void sayHello() {
        System.err.println("说一句Hello。。。。。。");
    }

    public void sayHello(String name) {
        System.err.println("说一句Hello。。。。。。" + name);
    }

    public String sayGood(String name) {
        System.err.println("说一句Hello。。。。。。" + name);
        return "";
    }
}
