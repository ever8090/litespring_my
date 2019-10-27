package com.litespring.beans.factory.support;

import com.litespring.beans.BeanDefinition;
import com.litespring.beans.factory.BeanCreationException;
import com.litespring.beans.factory.BeanDefinitionStoreException;
import com.litespring.beans.factory.BeanFactory;
import com.litespring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author:Liuwx
 * Date:2019/10/23
 */
public class DefaultBeanFactory implements BeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    public static final String ID_ATTRIBUTE = "id";

    public static final String CLASS_ATTRIBUTE = "class";

    public static final String SCOPE_ATTRIBUTE = "scope";

    public DefaultBeanFactory(String configFile) {
        loadBeanDefinitions(configFile);
    }

    private void loadBeanDefinitions(String configFile) {
        {
            InputStream is = null;
            try{
                is = ClassUtils.getDefaultClassLoader().getResourceAsStream(configFile);
                SAXReader reader = new SAXReader();
                Document doc = reader.read(is);

                Element root = doc.getRootElement(); //<beans>
                Iterator<Element> iter = root.elementIterator();
                while(iter.hasNext()){
                    Element ele = (Element)iter.next();
                    String id = ele.attributeValue(ID_ATTRIBUTE);
                    String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                    BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
                    this.beanDefinitionMap.put(id, bd);
                }
            } catch (Exception e) {
                throw new BeanDefinitionStoreException("IOException parsing XML document from "+configFile,e);
            }finally{
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if(bd == null){
            return null;
        }
        return createBean(bd);
    }
    private Object createBean(BeanDefinition bd) {
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
        }
    }
}
