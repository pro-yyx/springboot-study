package com.yyx.springboot.jtaatomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description: 配置数据源
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/23 14:20
 */
/*@Configuration*/
@MapperScan(basePackages = "com.yyx.springboot.mapper02",sqlSessionTemplateRef = "sqlSessionTemplate02")
public class MybastisConfig02 {

    @Bean(name = "datasource02")
    public DataSource createDataSource(DataConfig02 dataConfig02) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dataConfig02.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(dataConfig02.getUsername());
        mysqlXADataSource.setPassword(dataConfig02.getPassword());
        //将本地事务注册到atomikos全局事务
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("testDataresource02");
        atomikosDataSourceBean.setMinPoolSize(dataConfig02.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dataConfig02.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(dataConfig02.getMaxLiftTime());
        atomikosDataSourceBean.setMaxIdleTime(dataConfig02.getMaxIdleTime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(dataConfig02.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dataConfig02.getLoginTimeout());
        atomikosDataSourceBean.setTestQuery(dataConfig02.getTestQuery());
        atomikosDataSourceBean.setMaintenanceInterval(dataConfig02.getMaintenanceInterval());
        return atomikosDataSourceBean;
    }

    @Bean(name = "sqlSessionFactory02")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("datasource02") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate02")
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier("sqlSessionFactory02") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
