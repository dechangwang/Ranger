package cn.edu.tongji.ranger.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext appContext;

    public ApplicationContext getApplicationContext() {
        return appContext;
    }

    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        appContext = context;
    }
}
