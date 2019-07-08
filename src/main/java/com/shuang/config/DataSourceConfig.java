package com.shuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * <多数据源配置>
 *
 * @Author: zhengbin.jin
 * @Email: zhengbin.jin@rograndec.com
 * @CreateDate: 2018/5/10
 * @Version: 1.0
 */
@Configuration
public class DataSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.rgcbs-read")
    public DataSource rgcbsReadDS() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.rgcbs-write")
    public DataSource rgcbsWriteDS() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

}
