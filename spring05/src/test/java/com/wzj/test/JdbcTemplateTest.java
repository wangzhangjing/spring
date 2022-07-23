package com.wzj.test;


        import com.mchange.v2.c3p0.ComboPooledDataSource;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        import org.springframework.jdbc.core.JdbcTemplate;

        import java.beans.PropertyVetoException;

public class JdbcTemplateTest {
    @Test
    //测试jdbcTemplate开发步骤
    public void text1() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int i = jdbcTemplate.update(" insert into account values (?,?)", "tom", 5000);
        System.out.println(i);
    }
    @Test
    //测试jdbcTemplate开发步骤
    public void text2() throws PropertyVetoException {
        ApplicationContext jdbc = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = jdbc.getBean(JdbcTemplate.class);
        int i = jdbcTemplate.update(" insert into account values (?,?)", "wzj", 5000);
        System.out.println(i);
    }
}
