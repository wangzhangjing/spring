package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {


//        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
//        <property name="driverClass" value="${jdbc.drive}"></property>
//        <property name="jdbcUrl" value="${jdbc.url}"></property>
//        <property name="user" value="${jdbc.username}"></property>
//        <property name="password" value="${jdbc.password}"></property>


    @Value("${jdbc.drive}")
    private String drive;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")//Spring会将当前方法的返回值以指定名称存储到spring容器中
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource= new ComboPooledDataSource();
        dataSource.setDriverClass(drive);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
