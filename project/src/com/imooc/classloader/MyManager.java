package com.imooc.classloader;

/**
 * BassManager的子类,此类需要实现java类的热加载
 * Created by Knight on 2017/12/13.
 */
public class MyManager implements BassManager {
    @Override
    public void logic() {
        System.out.println("我在慕课网学习sssaaaa");
        System.out.println("慕课网学习资源丰富sdsdasd");
    }
}
