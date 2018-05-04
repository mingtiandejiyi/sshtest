package com.ssh.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by huangguan18 on 15-10-15.
 */
@Lazy(false)
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext context = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static <T> T getBean(String name){
        return (T)context.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return context.getBean(name, requiredType);
    }

    public static <T> T getBean(Class cls){
        return (T)context.getBean(cls);
    }

    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }

    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return context.getAliases(name);
    }
}
