package com.yyx.springboot.jtaatomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description: 配置数据源 .利用atomikos管理数据源后，不需要配置事务管理器
 * @Auther: yinyuxin
 * @Date: 2018/11/23 14:20
 */
@Configuration
@MapperScan(basePackages = "com.yyx.springboot.mapper01",sqlSessionTemplateRef = "sqlSessionTemplate")
public class MybastisConfig01 {

    @Primary
    @Bean(name = "datasource")
    public DataSource createDataSource(DataConfig01 dataConfig01) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();

        mysqlXADataSource.setUrl(dataConfig01.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(dataConfig01.getUsername());
        mysqlXADataSource.setPassword(dataConfig01.getPassword());
        //将本地事务注册到atomikos全局事务
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("testDataresource");
        atomikosDataSourceBean.setMinPoolSize(dataConfig01.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dataConfig01.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(dataConfig01.getMaxLiftTime());
        atomikosDataSourceBean.setMaxIdleTime(dataConfig01.getMaxIdleTime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(dataConfig01.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dataConfig01.getLoginTimeout());
        atomikosDataSourceBean.setTestQuery(dataConfig01.getTestQuery());
        atomikosDataSourceBean.setMaintenanceInterval(dataConfig01.getMaintenanceInterval());
        return atomikosDataSourceBean;
    }

    @Primary
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
