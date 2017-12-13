package com.imooc.classloader;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

/**
 * 加载manager的工厂
 * Created by Knight on 2017/12/13.
 */
public class ManagerFactory {
    //记录热加载类的加载信息
    private static final Map<String,LoadInfo> loadTimeMap=new HashMap<String,LoadInfo>();
    //要加载的类的classpath
    public static final String CLASS_PATH="E:/javacode/project/bin";
    //实现热加载的类的全名称(包名+类名)
    public static final String MY_MANAGER="com.imooc.classloader.MyManager";

    public static BassManager getManager(String className){
        File loadFile=new File(CLASS_PATH+className.replaceAll("\\.","/")+".class");
        long lastModified=loadFile.lastModified();//获取修改的时间
        //loadTimeMap不包含className为key的LoadInfo信息,证明这个类没有被加载,那么需要加载
        if(loadTimeMap.get(className)==null){
            System.out.println('1');
            load(className,lastModified);
        }else if(loadTimeMap.get(className).getLoadTime()!=lastModified){
            System.out.println('2');
            //加载类的时间戳发生变化,那么需要重新加载
            load(className,lastModified);
        }
        return loadTimeMap.get(className).getManager();
    }

    private static void load(String className, long lastModified) {
        MyClassLoader myClassLoader=new MyClassLoader(CLASS_PATH);
        Class<?> loadClass=null;
        try {
            loadClass=myClassLoader.loadClass(className);//加载这个类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BassManager manager=newInstance(loadClass);
        LoadInfo loadInfo =new LoadInfo(myClassLoader,lastModified);
        loadInfo.setManager(manager);
        loadTimeMap.put(className,loadInfo);
    }

    //以反射的方式创建BassManager子类对象
    private static BassManager newInstance(Class<?> loadClass) {
        try {
            return (BassManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
