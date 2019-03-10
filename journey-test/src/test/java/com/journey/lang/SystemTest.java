package com.journey.lang;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuqingwen
 * @date 2018/9/20.
 */
public class SystemTest {

    @Test
    public void test() {

        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println(properties);

        System.out.println();
        Map<String, String> getenv = System.getenv();
        for (Map.Entry<String, String> entry : getenv.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println(getenv);

    }

    @Test
    public void test02() {

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress.isSiteLocalAddress()) {
                        System.out.println(inetAddress.getHostAddress());
                    }

                }
            }
        } catch (SocketException e) {

        }

    }

}
