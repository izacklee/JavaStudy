package com.zeroten.javales.day76c_springprinciple;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理测试类
 */
public class CGLibProxyTest {

    public static void main(String[] args) {

        // 代理class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/app/Downloads/" +
                "javaproject/javatest/basic-code/slsweb/src/com/jinxun" +
                "/githubmaven/java_demo/src/test/java/com/zeroten/javales/day76c_springprinciple/code");

        MethodInterceptor methodInterceptor = new MyMethodInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyTest.class);
        enhancer.setCallback(methodInterceptor);

        ProxyTest proxyTest = (ProxyTest) enhancer.create();
        Integer ret = proxyTest.add(1, 2);

        System.out.println(ret);
    }

    /**
     * 业务增强类，实现耗时时间统计功能
     */
    static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            long curTime = System.nanoTime();

            // 调用父类的方法
            Object ret = methodProxy.invokeSuper(o, objects);

            System.out.println(String.format("耗时:%s 纳秒", System.nanoTime() - curTime));

            return ret;
        }
    }
}
