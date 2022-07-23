package com.wzj.anno;


import org.springframework.stereotype.Component;

@Component("target")
public class Target implements Targetinterface {

    public void save() {


System.out.println("save runing......");  //         int i =1/0;
    }
}
