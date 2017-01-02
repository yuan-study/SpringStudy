package com.pingan.myspring.dto;

/**
 * Created by zhyy on 2017/1/2.
 */
public class Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }*/

    public void run() {
        System.out.println(this.getName() + "车在跑!");
    }
}
