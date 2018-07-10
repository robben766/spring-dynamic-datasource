package com.study.renz.dynamicdatasource.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by renz on 2018/7/9.
 */
@Configuration
public class DBConfig {

    @Autowired
    private DynamicDataSourceContextHolder dynamicDataSourceContextHolder;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/robben");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public DataSource dataSource2(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/robben2");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    @Bean
    public DynamicDataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDynamicDataSourceContextHolder(dynamicDataSourceContextHolder);
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put("db1", dataSource());
        targetDataSources.put("db2", dataSource2());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
