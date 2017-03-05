package com.lemeshko.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
public class JpaConfiguration {

	// // @Value("#{dataSource}")
	// @Resource(name = "dataSource")
	// private javax.sql.DataSource dataSource;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.databaseurl}")
	private String dataBaseUrl;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.dialect}")
	private String dialect;

	@Bean
	public DataSource dataSource() {

		Properties prop = new Properties();
		prop.setProperty("user", username);
		prop.setProperty("password", password);
		prop.setProperty("dialect", dialect);
		prop.setProperty("driverClassName", driverClassName);
		return new DriverManagerDataSource(dataBaseUrl, prop);
	}

	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", MySQL5Dialect.class.getName());
		// props.put("hibernate.show_sql", "true");
		return props;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource());
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lef;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(localContainerEntityManagerFactoryBean().getObject());
	}

}
