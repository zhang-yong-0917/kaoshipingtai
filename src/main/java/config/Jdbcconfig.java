package config;//package com.easy.BigHomework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//用于将mysql的配置文件管理在spring的容器中，从而在程序中优雅的使用。
@Component//类似于xml
//当前这个类的属性需要与某个配置文件绑定
@PropertySource("classpath:mysql.properties")// classpath路径："classpath:/com/myco/app.properties"
//文件对应路径："file:/path/to/file"
public class Jdbcconfig {

    @Value("${URL}")//类似于set方法
    private String url;

    @Value("${DRIVER}")
    private String driver;

    @Value("${UNAME}")
    private String username;

    @Value("${PASSWORD}")
    private String password;

    @Value("${FILTERS}")
    private String filters;


//    @Value("${CONNECTION_PROPERTIES}")
//    private String connectionProperties;

    public String getFilters() {
        return filters;
    }

//    public String getConnectionProperties() {
//        return connectionProperties;
//    }


    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
