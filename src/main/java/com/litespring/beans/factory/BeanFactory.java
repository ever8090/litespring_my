package com.litespring.beans.factory;

import com.litespring.beans.BeanDefinition;

/**
 * author:Liuwx
 * Date:2019/10/23
 */
public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String petStore);
}
