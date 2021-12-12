package br.com.cpdias.news.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Headlines {
    
    private ArticleDao articleDao;

    @Autowired
    public Headlines(ArticleDao articleDao) {
        super();
        this.articleDao = articleDao;
    }
    
    public List<Article>getAllArticles(){
        return articleDao.restoreAllOfTheDay();
    }
}
