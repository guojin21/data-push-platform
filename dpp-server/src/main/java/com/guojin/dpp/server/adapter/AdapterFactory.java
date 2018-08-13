package com.guojin.dpp.server.adapter;


/**
 * @describe: 工厂类：用于生产推送接口对象
 * @author: guojin
 * @date: 2018/8/13 18:00
 **/
public class AdapterFactory {

    private AdapterFactory(){}

    public static class AdapterInstanceHolder{
        private static AdapterFactory adapterFactory =  new AdapterFactory();
    }
    public static AdapterFactory getAdapterInstance(){
        return AdapterInstanceHolder.adapterFactory;
    }

    /**
     * @describe: 用于匹配实际的适配器对象
     * @date: 2018/8/13 18:02
     **/
    public PushTarget getPushTarget(String classInfo) {
        PushTarget pushTarget = null;//定义接口对象
        try {
            //利用反射，生成Class对象
            Class c = Class.forName(classInfo);
            //获得该Class对象的实例
            Object obj = c.newInstance();
            //将Object对象强转为接口对象
            pushTarget = (PushTarget) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回接口对象
        return pushTarget;
    }
}
