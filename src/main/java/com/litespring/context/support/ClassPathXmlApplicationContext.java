package com.litespring.context.support;

import com.litespring.beans.factory.support.DefaultBeanFactory;
import com.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.litespring.context.ApplicationContext;
import com.litespring.core.io.ClassPathResource;
import com.litespring.core.io.FileSystemResource;
import com.litespring.core.io.Resource;

/**
 * author:Liuwx
 * Date:2019/10/27
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }


    protected Resource getResourceByPath(String configFile) {
        return new ClassPathResource(configFile);
    }
}
