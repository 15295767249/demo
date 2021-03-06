package cn.com.yhb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    //主数据源配置 test
    @Primary
    @Bean(name = "dataSourceProperties1")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSourceProperties dataSourceProperties1() {
        return new DataSourceProperties();
    }

    //主数据与 test数据源
    @Primary
    @Bean(name = "dataSource1")
    public DataSource dataSource1(@Qualifier("dataSourceProperties1") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    //第二个数据源配置 test1
    @Bean(name = "dataSourceProperties2")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSourceProperties dataSourceProperties2() {
        return new DataSourceProperties();
    }

    //第二个数据源 test1
    @Bean(name = "dataSource2")
    public DataSource dataSource2(@Qualifier("dataSourceProperties2") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
