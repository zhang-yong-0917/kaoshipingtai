package config;//package com.easy.BigHomework.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
//@MapperScan("com.easy.archiecture.dao.mapper")
//@EnableTransactionManagement
public class DataConfig {

    @Resource/*//@Resource的作a用相当于@Autowired，只不过@Autowired按byType自动注入，
             // 而@Resource默认按 byName自动注入罢了*/
    //类似于set方法,注入Bean实例
    private Jdbcconfig jdbcInfo;

    @Bean//注册bean到容器中
    public DataSource getDataSource() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();//相当于连接池
        dataSource.setJdbcUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setDriverClassName(jdbcInfo.getDriver());

        return dataSource;
    }


    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        /*DataSource的概念这是一个接口，可以获取数据库的Connection。是标准化的，取得连接的一种方式。*/
        return new JdbcTemplate(dataSource);//JdbcTemplate配置连接池,底层有懒加载
    }


    /**
     * 装配事务管理器
     */
    //事务就是对一系列的数据库操作进行统一的提交或回滚操作，
    // 比如说做一个转账功能，要更改帐户两边的数据，这时候就必须要用事务才能算是严谨的做法。
    // 要么成功，要么失败，保持数据一致性。如果中间有一个操作出现异常，那么回滚之前的所有操作。

    //是传统的使用JDBC的事务管理，使用DataSource，从数据源中获取connection
    // ,通过con的api进行CRUD，手动的进行commit或者rollback
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * JDBC事务操作配置
     */
    @Bean(name = "txTemplate")
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }



}
