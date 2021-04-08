package max.yz.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import max.yz.boot.basic.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class ArticleServiceTest {
    @Resource
    private  ArticleService articleService;

    @Test
    void  postArticle(){
        Article article = Article.builder()
                .title("test2")
                .content("test2")
                .author("yz")
                .build();
        log.info("article"+article);
        boolean flag = articleService.postArticle(article);
        log.info("flag:" + flag);
//        assertTrue(flag);
    }

    @Test
    void selectAll() {
        List<Article> articles = articleService.getAll();
//        assertEquals(2,articles.size());
        articles.forEach(article -> {
            log.info("author:" + article.getAuthor());
            log.info("title:" + article.getTitle());
        });
    }

    @Test
    void delete() {
        boolean flag = articleService.deleteArticle(3);
//        assertTrue(flag);
    }

    @Test
    void findById() {
        Article realArticle = articleService.getById(1);
        Article expectedArticle = Article.builder()
                .author("yz")
                .title("SpringBoot")
                .content("SpringBoot从入门到精通")
                .updateTime(new Date())
                .build();
        log.info("expectedArticle-----" + expectedArticle);
//        assertEquals(expectedArticle, realArticle);
    }

    @Test
    void update() {
        Article article = Article.builder()
                .id(1)
                .author("yz")
                .title("Java")
                .content("Java从入门到精通")
                .updateTime(new Date())
                .build();
        boolean flag = articleService.updateArticle(article);
        log.info("flag"+flag);
        assertTrue(flag);
    }


}