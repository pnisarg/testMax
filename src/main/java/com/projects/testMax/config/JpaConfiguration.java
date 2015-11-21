package com.projects.testMax.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableJpaRepositories("com.projects.testMax.repository")
@EnableTransactionManagement
public class JpaConfiguration {
	
	/**
	 * Using boneCP for creating data source.
	 * BoneCP is a fast, free, open-source, Java database connection pool (JDBC Pool) library.
	 * We set database related properties in data source.
	 * @return
	 */
	@Bean(destroyMethod = "close")
	public BoneCPDataSource boneCPDataSource() {
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
		boneCPDataSource.setDriverClass("org.postgresql.Driver");
		boneCPDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/testMaxdb");
		boneCPDataSource.setUsername("testmaxdbuser");
		boneCPDataSource.setPassword("testmax");
		boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
		boneCPDataSource.setIdleMaxAgeInMinutes(420);
		boneCPDataSource.setMaxConnectionsPerPartition(30);
		boneCPDataSource.setMinConnectionsPerPartition(10);
		boneCPDataSource.setPartitionCount(3);
		boneCPDataSource.setAcquireIncrement(5);
		boneCPDataSource.setStatementsCacheSize(100);
		boneCPDataSource.setReleaseHelperThreads(3);
		return boneCPDataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		// specify ORM vendor
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);

		// Declare a JPA entityManagerFactory
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.projects.testMax.entity");
		factory.setDataSource(boneCPDataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
