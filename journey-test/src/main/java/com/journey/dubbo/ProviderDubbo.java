package com.journey.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;

/**
 * @author liuqingwen
 * @date 2018/2/22.
 */
public class ProviderDubbo {


    public Object query() {

        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://192.168.6.12:9830"));
        registry.register(URL.valueOf("memcached://192.168.6.12/com.foo.BarService?category=provider&dynamic=false&application=foo"));


        return null;
    }

}
