package com.study.renz.dynamicdatasource.config.datasource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renz on 2018/7/9.
 */
@Component
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static List<String> dataSourceIds = new ArrayList<String>();

    public void set(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public String get() {
        String temp = contextHolder.get();
        if(StringUtils.isEmpty(temp)){
            contextHolder.set("db1");
        }
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     *
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
