package br.lostpets.infra;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DatabaseConfig {

	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	@Primary
	public DataSource getDataSource() {
		//DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//dataSource.setDriverClassName("com.microsoft.sqlserver");
		//dataSource.setUrl("***URL***");
		//dataSource.setUsername("***username***");
		//dataSource.setPassword("***password***");
		
		return DataSourceBuilder.create().build(); // está consumindo info do application.properties
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adpater = new HibernateJpaVendorAdapter();
		adpater.setDatabase(Database.SQL_SERVER);
		adpater.setShowSql(true);
		adpater.setGenerateDdl(true);
		adpater.setDatabasePlatform("org.hibernate.dialect.SQLServerDialect");
		adpater.setPrepareConnection(true);
		
		return adpater;
	}
}
