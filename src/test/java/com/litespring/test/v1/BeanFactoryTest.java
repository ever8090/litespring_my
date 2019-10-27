package com.litespring.test.v1;

import com.litespring.beans.BeanDefinition;
import com.litespring.beans.factory.BeanFactory;
import com.litespring.beans.factory.support.DefaultBeanFactory;
import com.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.litespring.core.io.ClassPathResource;
import com.litespring.service.v1.PetStoreService;
import com.litespring.util.ClassUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author:Liuwx
 * Date:2019/10/23
 */
public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader =null;


    @Before
    public void setUP(){
         factory = new DefaultBeanFactory();
         reader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testClassUtil(){
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = "com.litespring.service.v1.PetStoreService";
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            Object obj = clz.newInstance();
        } catch (Exception e) {
        }
    }

    @Test
    public void testGetBean(){
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        assertEquals("com.litespring.service.v1.PetStoreService",bd.getBeanClassName());
        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);

    }

    @Test
    public void testInvalidBean(){
        try {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
            factory.getBean("invalidBean");
        }catch (Exception e){
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }

    @Test
    public void testInvalidXML(){
        try {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
            BeanDefinition bd = factory.getBeanDefinition("petStore");
        }catch (Exception e){
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException ");
    }
}
