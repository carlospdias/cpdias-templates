package br.com.cpdias.news.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("br.com.cpdias.news")
public class ConfigurationApp {
   
    @Bean
    public DataSource dataSource() {
        return new JndiDataSourceLookup().getDataSource("java:/NEWS_APP");
    }
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    /*********************** Configuração do MyBatis ************************************/
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
      
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
