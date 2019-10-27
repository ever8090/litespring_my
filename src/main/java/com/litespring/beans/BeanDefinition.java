package com.litespring.beans;

/**
 * author:Liuwx
 * Date:2019/10/23
 */
public interface BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    boolean isSingleton();
    public boolean isPrototype();
    String getScope();
    void setScope(String scope);

    public String getBeanClassName();
}
