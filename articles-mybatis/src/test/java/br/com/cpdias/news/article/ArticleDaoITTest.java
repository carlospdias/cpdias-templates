package br.com.cpdias.news.article;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import br.com.cpdias.news.config.ConfigurationAppTest;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigurationAppTest.class} )
@Transactional
public class ArticleDaoITTest {
    
    @Autowired
    private ArticleDao articleDao;
    
    @Test
    @DisplayName("Deve confirmar a um ambiente pronto para uso")
    public void existeAmbiente() {
        assertThat(articleDao, notNullValue());
    }
    
    @Test
    @DisplayName("Deve retorna uma lista de artigos válidos.")
    public void shouldReturnAValidListOfArticles() {
        List<Article> articles = articleDao.restoreAllOfTheDay();
        
       for(Article article: articles) {
           System.out.println(article.getContent());
       }
        
        System.out.println(articles);
    }
}
