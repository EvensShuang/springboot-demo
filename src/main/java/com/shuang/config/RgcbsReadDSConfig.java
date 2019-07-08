package com.rograndec.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * <wdzs数据源配置>
 *
 * @Author: zhengbin.jin
 * @Email: zhengbin.jin@rograndec.com
 * @CreateDate: 2018/5/10
 * @Version: 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.rograndec.service.*.dao.read"}, sqlSessionFactoryRef = "rgcbsReadSqlSessionFactory")
public class RgcbsReadDSConfig {
	@Autowired
	@Qualifier("rgcbsReadDS")
	private DataSource rgcbsReadDS;


	@Bean
	public SqlSessionFactory rgcbsReadSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(rgcbsReadDS);
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/rgcbs/*/read/*.xml"));
		return factoryBean.getObject();

	}


	@Bean
	public SqlSessionTemplate rgcbsReadSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(rgcbsReadSqlSessionFactory());
		return template;
	}
}
