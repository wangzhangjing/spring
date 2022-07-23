package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//该标志是spring的核心配置文件类
@Configuration
//<context:component-scan base-package="com.itheima"/>
@ComponentScan("com.itheima")
//<import resource=""/>
//@Import({DataSourceConfiguration.class},xxx,xxx)
@Import(DataSourceConfiguration.class)

public class SpringConfiguration {


}
