package com.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 可以从不同地方读取XML，如classpath，filesystem等
 * 这里的resource是对读取XML的抽象
 * resource接口有拿到inputstream的能力，交给{@link XmlBeanDefinitionReader}处理
 */
public interface Resource {
	public InputStream getInputStream() throws IOException;
	public String getDescription();
}
