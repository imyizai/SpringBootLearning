package max.yz.boot.basic.dao;
import max.yz.boot.basic.entity.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author imyizai
 * @ClassName ArticleDAO
 * @Description
 * @Date 2021/3/16 1:41 下午
 **/
@Repository
public class ArticleDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存文章
     *
     * @param article article对象
     * @return 新增成功的article对象
     */
    public Article save(Article article) {
        String sql = "INSERT INTO t_article (author,title,content) VALUES (?,?,?)";
        Object[] args = {article.getAuthor(), article.getTitle(), article.getContent()};
        int count = jdbcTemplate.update(sql, args);
        if (count == 1) {
            return article;
        } else {
            return null;
        }

    }



    /**
     * 根据id删除文章
     *
     * @param id id
     * @return int
     */
    public int deleteById(Integer id) {

        return jdbcTemplate.update("DELETE FROM t_article WHERE id = ? ",id);
    }

    /** 更新文章
     *
     * @param article article
     * @return int
     */
    public int update(Article article) {
//
        String sql = "UPDATE t_article SET author = ?, title = ? , content = ? , update_time = ? WHERE id = ? ";
        Object[] args = {article.getAuthor(),article.getTitle(), article.getContent(), article.getUpdateTime() ,article.getId()};
        int update = jdbcTemplate.update(sql, args);
        return  update;
    }
    /** 根据id查找文章
     * @param id id
     * @return Article
     */
    public  Article findById(Integer id) {
        List<Article> articles = jdbcTemplate.query("SELECT * FROM t_article WHERE id = ?",
               new Object[]{id}, new BeanPropertyRowMapper<>(Article.class));
        return articles.get(0);
    }
    /** 查询所有文章
     *
     * @return List<Article>
     */
    public List<Article> findAll() {
        return jdbcTemplate.query("SELECT * FROM t_article ",
                new BeanPropertyRowMapper<>(Article.class));
    }

}

