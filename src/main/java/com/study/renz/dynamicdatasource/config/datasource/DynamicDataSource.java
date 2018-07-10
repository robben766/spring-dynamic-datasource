package com.study.renz.dynamicdatasource.config.datasource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * Created by renz on 2018/7/9.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DynamicDataSource extends AbstractRoutingDataSource {
    private DynamicDataSourceContextHolder dynamicDataSourceContextHolder;

    @Nullable
    protected Object determineCurrentLookupKey() {
        return dynamicDataSourceContextHolder.get();
    }
}
