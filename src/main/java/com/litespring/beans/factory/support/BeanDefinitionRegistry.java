package com.litespring.beans.factory.support;

import com.litespring.beans.BeanDefinition;

/**
 * author:Liuwx
 * Date:2019/10/27
 * 注册bean
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String id, BeanDefinition bd);

    BeanDefinition getBeanDefinition(String beanId);
}
