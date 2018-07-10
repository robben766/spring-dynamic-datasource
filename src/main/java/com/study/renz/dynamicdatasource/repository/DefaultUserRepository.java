package com.study.renz.dynamicdatasource.repository;

import com.study.renz.dynamicdatasource.config.datasource.DynamicDataSource;
import com.study.renz.dynamicdatasource.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by renz on 2018/7/9.
 */
@Component
@Slf4j
public class DefaultUserRepository implements UserRepository {

    @Autowired
    private DynamicDataSource dataSource;

    public void insertUser(User user) {
        if (user.getAge() >= 30) {
            this.dataSource.getDynamicDataSourceContextHolder().set("db2");
        } else {
            this.dataSource.getDynamicDataSourceContextHolder().set("db1");
        }

        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "insert into t_user(name, address, age) values('" + user.getName() + "', '" + user.getAddress() + "', " + user.getAge() + ")";
        jdbcTemplate.update(sql);
    }

}
