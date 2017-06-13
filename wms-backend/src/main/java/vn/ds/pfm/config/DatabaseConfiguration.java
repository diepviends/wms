package vn.ds.pfm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({ "vn.ds.pfm.domain.aggregate" })
@EnableJpaAuditing
public class DatabaseConfiguration {

	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factory,
			DataSource dataSource, JpaProperties properties) {
		Map<String, Object> jpaProperties = new HashMap<>();
		jpaProperties.putAll(properties.getHibernateProperties(dataSource));
		return factory.dataSource(dataSource).packages("vn.ds.pfm.domain.aggregate").properties(jpaProperties).build();
	}*/
}
