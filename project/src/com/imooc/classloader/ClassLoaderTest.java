package com.imooc.classloader;

/**
 * 测试java类的热加载
 * Created by Knight on 2017/12/13.
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        new Thread(new MsgHandler()).start();
    }
}
