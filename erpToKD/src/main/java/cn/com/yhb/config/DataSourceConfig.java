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
    @Bean(name = "dataSourceProperties1")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSourceProperties dataSourceProperties1() {
        return new DataSourceProperties();
    }

    //主数据与 test数据源
    @Bean(name = "dataSource1")
    public DataSource dataSource1(@Qualifier("dataSourceProperties1") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    //第二个数据源配置 test1
    @Primary
    @Bean(name = "dataSourceProperties2")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver-back")
    public DataSourceProperties dataSourceProperties2() {
        return new DataSourceProperties();
    }

    //第二个数据源 test1
    @Primary
    @Bean(name = "dataSource2")
    public DataSource dataSource2(@Qualifier("dataSourceProperties2") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    //第三个数据源配置server test1
    @Bean(name = "dataSourceProperties3")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver-kd")
    public DataSourceProperties dataSourceProperties3() {
        return new DataSourceProperties();
    }

    //第三个数据源 test1
    @Bean(name = "dataSource3")
    public DataSource dataSource3(@Qualifier("dataSourceProperties3") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
