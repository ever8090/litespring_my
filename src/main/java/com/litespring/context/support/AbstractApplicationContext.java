package com.litespring.context.support;

import com.litespring.beans.factory.support.DefaultBeanFactory;
import com.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.litespring.context.ApplicationContext;
import com.litespring.core.io.FileSystemResource;
import com.litespring.core.io.Resource;
import com.litespring.util.ClassUtils;

/**
 * author:Liuwx
 * Date:2019/10/27
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader;
    public AbstractApplicationContext(String configFile){
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(this.getResourceByPath(configFile));
    }


    protected abstract Resource getResourceByPath(String configFile);

    public Object getBean(String beanId) {
        return this.factory.getBean(beanId);
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
