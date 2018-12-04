package com.example.webmagic.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author czWang
 * @Created 2018/8/1 16:59.
 */
@Component
public class ToolSpring implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(ToolSpring.applicationContext == null){
            ToolSpring.applicationContext  = applicationContext;
          //  log.info("---------------------------------------------------------------------");
           // log.info("========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext={}========",applicationContext);
            //log.info("---------------------------------------------------------------------");
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
}
