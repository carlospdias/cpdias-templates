package br.com.cpdias.news.article;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
class ArticleDaoMyBatis implements ArticleDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoMyBatis.class);

    private final SqlSession sqlSession;

    @Autowired
    public ArticleDaoMyBatis(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    @Override
    public List<Article> restoreAllOfTheDay() {
        LOGGER.info("Searching articles");
         List<Article>articles = this.sqlSession.selectList("news.articles.ArticleMapper.selectAllArticles");
         if (articles != null){
             return articles;
         }
        LOGGER.warn("No Article found.");
         return Collections.emptyList();
    }

}
