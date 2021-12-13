package br.com.cpdias.news.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
@ComponentScan("br.com.cpdias.news")
public class ConfigurationAppTest {
    
    public void createDataBase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        
        liquibase.setChangeLog("classpath:/migrations/changelog-master.xml");
        liquibase.setDataSource(ds);
        liquibase.setShouldRun(true);
        
        liquibase.setResourceLoader(new DefaultResourceLoader());
        try {
            liquibase.afterPropertiesSet();
           
        } catch (LiquibaseException e) {
            e.printStackTrace();
        }
       
    }
    
    @Bean
    public DataSource dataSource() {
      
        EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("jdbc:h2:mem:ARTICLES_DB;MODE=POSTGRESQL;DB_CLOSE_DELAY=-1")
                .build();
        
        return db;
    }
    
    
    /*@Bean
    public DataSource dataSource() {
        return new JndiDataSourceLookup().getDataSource("java:/NEWS_APP");
    } */
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    /*********************** Configuração do MyBatis ************************************/
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
      
      createDataBase(dataSource());
      sqlSessionFactory.setDataSource(dataSource());
      sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
      sqlSessionFactory.setFailFast(true);
      return  sqlSessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
      return new SqlSessionTemplate(sqlSessionFactory());
    }

}
