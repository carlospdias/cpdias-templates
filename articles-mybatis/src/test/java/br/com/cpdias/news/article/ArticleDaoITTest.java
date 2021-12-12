package br.com.cpdias.news.article;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = {"br.com.cpdias.news"} )
@Transactional
public class ArticleDaoITTest {
    
    @Autowired
    private ArticleDao articleDao;
    
    @Test
    @DisplayName("Deve confirmar a um ambiente pronto para uso")
    public void existeAmbiente() {
        assertThat(articleDao, notNullValue());
    }
}
