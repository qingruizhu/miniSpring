package com.zqr.demo;


import com.zqr.zqrframework.ZqrAutowired;
import com.zqr.zqrframework.ZqrController;
import com.zqr.zqrframework.ZqrRequestMapping;
import com.zqr.zqrframework.ZqrRequestParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ZqrController
@ZqrRequestMapping("demo")
public class DemoController {

    @ZqrAutowired
    private IDemoService demoService;

    @ZqrRequestMapping("sayHello")
    public void sayHello(
            HttpServletRequest req,
            HttpServletResponse resp,
            @ZqrRequestParameter("name") String name,
            @ZqrRequestParameter("age") String age
    ){
        String s = demoService.sayHello("age:"+age+",name:"+name);
        try {
            resp.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
