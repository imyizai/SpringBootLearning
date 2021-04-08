package max.yz.boot.basic.service.impl;
import lombok.extern.slf4j.Slf4j;
import max.yz.boot.basic.dao.ArticleDAO;
import max.yz.boot.basic.entity.Article;
import max.yz.boot.basic.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author imyizai
 * @ClassName ArticleServiceImpl
 * @Description
 * @Date 2021/3/16 1:50 下午
 **/

@Service
@Slf4j
public class ArticleServiceImpl  implements ArticleService {
    @Resource
    private ArticleDAO articleDAO;


    @Override
//    @Transactional
    public boolean postArticle(Article article) {
        Article saveArticle = articleDAO.save(article);

        return saveArticle != null;
//        int a = 3/0;  //模拟可能出现的异常
//         List<Article> all = articleDAO.findAll();
//        return all.get(100).getId() == 1;
    }
    @Override
    public boolean deleteArticle(int id) {
        int row = articleDAO.deleteById(id);
        return row != 0;
    }

    @Override
    public boolean updateArticle(Article article) {
        int row = articleDAO.update(article);
        return row != 0;
    }

    @Override
    public Article getById(int id) {
        Article article = articleDAO.findById(id);
        return article;
    }

    @Override
    public List<Article> getAll() {

        return articleDAO.findAll();
    }

}
