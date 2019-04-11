package com.zqr.demo;

import com.zqr.zqrframework.ZqrService;

@ZqrService
public class DemoService  implements IDemoService {


    public String sayHello(String word) {
        System.out.println("你好啊.......");
        return word+" what are you doing ?";
    }
}
