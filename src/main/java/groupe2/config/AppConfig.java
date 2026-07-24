package groupe2.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource() {

        BasicDataSource ds = new BasicDataSource();
        String host = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
        String dbName = System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "groupe2_mvc";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "postgres";
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "passer";
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://" + host + ":5432/" + dbName);
        ds.setUsername(user);
        ds.setPassword(password);

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        em.setPackagesToScan("groupe2.entity");
        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(vendorAdapter);

        // options Hibernate (important pour PostgreSQL)
        java.util.Properties props = new java.util.Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");
        em.setJpaProperties(props);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager( EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
         txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}