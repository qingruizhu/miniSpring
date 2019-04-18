package com.zqr.zqrframework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ZqrHandler {

    //controller实例
    private Object controller;
    //url对应的pattern
    private Pattern pattern;
    //url对应的method
    private Method method;
    //method的参数顺序
    protected Map<String,Integer> paramIndexMapping;

    public ZqrHandler(Object controller, Pattern pattern, Method method) {
        this.controller = controller;
        this.pattern = pattern;
        this.method = method;
        paramIndexMapping = new HashMap<String,Integer>();
        putParamIndexMapping(method);

    }

    private void putParamIndexMapping(Method method) {
        // 1.ZqrRequestParameter注解参数设置(实参)
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            for (Annotation annotation:annotations[i]) {
                if (annotation instanceof ZqrRequestParameter){
                    String paramName = ((ZqrRequestParameter) annotation).value();
                    if (!"".equals(paramName)){
                        paramIndexMapping.put(paramName,i);
                    }
                }

            }

        }
        // 2.Reqeus和Response的设置(形参)
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (HttpServletRequest.class == parameterType || HttpServletResponse.class == parameterType){
                paramIndexMapping.put(parameterType.getName(),i);
            }

        }
    }


    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
