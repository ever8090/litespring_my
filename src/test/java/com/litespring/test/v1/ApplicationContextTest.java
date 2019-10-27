package com.litespring.test.v1;

import com.litespring.context.ApplicationContext;
import com.litespring.context.support.ClassPathXmlApplicationContext;
import com.litespring.context.support.FileSystemXmlApplicationContext;
import com.litespring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

/**
 * author:Liuwx
 * Date:2019/10/27
 */
public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }
    @Test
    public void testGetBeanFromFileSystemContext(){
        //注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		ApplicationContext ctx = new FileSystemXmlApplicationContext("D:/workspace/litespring_my/src/test/resources/petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		Assert.assertNotNull(petStore);

    }
}
