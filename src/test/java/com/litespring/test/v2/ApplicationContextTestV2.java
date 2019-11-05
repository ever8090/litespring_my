package com.litespring.test.v2;

import com.litespring.context.ApplicationContext;
import com.litespring.context.support.ClassPathXmlApplicationContext;
import com.litespring.dao.v2.AccountDao;
import com.litespring.dao.v2.ItemDao;
import com.litespring.service.v2.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationContextTestV2 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		
		assertNotNull(petStore.getAccountDao());
		assertNotNull(petStore.getItemDao());
		
		assertTrue(petStore.getAccountDao() instanceof AccountDao);
		assertTrue(petStore.getItemDao() instanceof ItemDao);
		
		assertEquals("liuxin",petStore.getOwner());
		assertEquals(2, petStore.getVersion());
		
	}

}
