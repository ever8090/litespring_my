package com.litespring.context.support;

import com.litespring.beans.factory.support.DefaultBeanFactory;
import com.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.litespring.context.ApplicationContext;
import com.litespring.core.io.ClassPathResource;
import com.litespring.core.io.FileSystemResource;
import com.litespring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	public FileSystemXmlApplicationContext(String configFile) {
		super(configFile);
	}


	protected Resource getResourceByPath(String configFile) {
		return new FileSystemResource(configFile);
	}
}
