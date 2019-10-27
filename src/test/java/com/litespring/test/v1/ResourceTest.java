package com.litespring.test.v1;

import com.litespring.core.io.ClassPathResource;
import com.litespring.core.io.FileSystemResource;
import com.litespring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class ResourceTest {

	@Test
	public void testClassPathResource() throws Exception {

		Resource r = new ClassPathResource("petstore-v1.xml");

		InputStream is = null;

		try {
			is = r.getInputStream();
			// 注意：这个测试其实并不充分！！
			Assert.assertNotNull(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}

	}

	@Test
	public void testFileSystemResource() throws Exception {

		/*Resource r = new FileSystemResource("D:\\workspace\\litespring_my\\src\\test\\resources\\petstore-v1.xml\\petstore-v1.xml");

		InputStream is = null;

		try {
			is = r.getInputStream();
			// 注意：这个测试其实并不充分！！
			Assert.assertNotNull(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}*/

	}

}
