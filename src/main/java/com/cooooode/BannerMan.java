package com.cooooode;

import com.cooooode.annotation.Banner;
import com.cooooode.annotation.Cache;
import com.cooooode.utils.BannerLocalTool;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: banner
 * @description: aop添加banner打印, cglib动态代理
 * @author: vua
 * @create: 2020-01-19 17:30
 */
public class BannerMan implements MethodInterceptor {
    private Object target;

    public BannerMan(Object target) {
        this.target = target;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Cache cache = method.getAnnotation(Cache.class);
        Banner banner = method.getAnnotation(Banner.class);
        if (cache != null) {
            if (banner != null) {
                if (BannerLocalTool.exist(banner)) {
                    System.out.println("@Cache");
                    BannerLocalTool.print(banner);
                } else {
                    BannerLocalTool.printAfterGet(banner, true);
                }
            }
        } else {
            if (banner != null)
                BannerLocalTool.printAfterGet(banner, false);
        }


        Object invoke = method.invoke(target, objects);
        return invoke;
    }

    public Object create() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }
}
