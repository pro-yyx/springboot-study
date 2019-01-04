package com.yyx.springboot.datasoucesStudy;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description: 数据源配置类
 * @Auther: yinyuxin
 * @Date: 2018/11/20 15:41
 */

/*@Configuration
@MapperScan(basePackages = "com.yyx.springboot.mapper",sqlSessionFactoryRef = "sqlSessionFactory01")*/
public class DatasorceConfig {

    @Bean(name = "dataSouce01")
    @ConfigurationProperties(prefix = "spring.datasource.data01")
    public DataSource readDataSouceProperties(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceTransactionManager01")
    public DataSourceTransactionManager createTransactionManager(@Qualifier(value = "dataSouce01") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory01")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier(value = "dataSouce01") DataSource dataSouce) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSouce);
        SqlSessionFactory object = sqlSessionFactoryBean.getObject();

        return object;

    }

    @Bean(name = "sql+SessionTemplate01")
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier(value = "sqlSessionFactory01") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
