package com.imooc.classloader;

/**
 * 封装加载类的信息
 * Created by Knight on 2017/12/13.
 */
public class LoadInfo {
    //自定义的类加载
    private  MyClassLoader myLoader;
    //记录要加载类的时间戳->加载时间
    private long loadTime;
    private BassManager manager;

    public LoadInfo(MyClassLoader myLoader, long loadTime) {
        super();
        this.myLoader = myLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyLoader() {
        return myLoader;
    }

    public void setMyLoader(MyClassLoader myLoader) {
        this.myLoader = myLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BassManager getManager() {
        return manager;
    }

    public void setManager(BassManager manager) {
        this.manager = manager;
    }
}
