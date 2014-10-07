package hello;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

// @EnableJpaRepositories("")
@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		dataSource.setUrl("jdbc:derby:H:/Derby/sample1;create=true");
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter jva = new EclipseLinkJpaVendorAdapter();
		jva.setDatabase(Database.DERBY);
		jva.setGenerateDdl(true);
		jva.setShowSql(true);
		return jva;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"jp.sample.repositories"});

		em.setJpaVendorAdapter(jpaVendorAdapter());

		Properties p = new Properties();
		// p.setProperty("", "");
		em.setJpaProperties(p);

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
