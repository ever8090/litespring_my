package com.litespring.test.v1;

import com.litespring.beans.BeanDefinition;
import com.litespring.beans.factory.BeanFactory;
import com.litespring.beans.factory.support.DefaultBeanFactory;
import com.litespring.service.v1.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author:Liuwx
 * Date:2019/10/23
 */
public class BeanFactoryTest {

    @Test
    public void testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        assertEquals("com.litespring.service.v1.PetStoreService",bd.getBeanClassName());
        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);

    }
}
