package liuyang.testdatamongodb.modules.hello.dao;

import liuyang.testdatamongodb.modules.hello.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.*;


/**
 * @author liuyang
 * @scine 2021/8/21
 */
public interface ArticleRepository extends MongoRepository<Article, Long> {

    // ////////////////////////////////////////////////////////
    // 命名规则查询
    List<Article> findByAuthorLike(String author);

    List<Article> findByAidGreaterThan(Long aid);
}
