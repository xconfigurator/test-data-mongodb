package liuyang.testdatamongodb.modules.hello.dao;

import liuyang.testdatamongodb.modules.hello.entity.Article;
import liuyang.testdatamongodb.modules.id.Id;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author liuyang
 * @scine 2021/8/21
 */
@SpringBootTest
@Slf4j
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    //@Test
    @RepeatedTest(50)
    void testSave() {
        Article article = new Article();
        article.setAid(Id.nextId());
        article.setAuthor("liuyang");
        article.setCreateTime(new Date());
        article.setTitle("《命题人8套卷》");
        articleRepository.save(article);
    }

    @Test
    void testUpdate() {
        Optional<Article> articleOptional = articleRepository.findById(1428915630953861120l);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            article.setTitle("《终极预测4套卷》");
            articleRepository.save(article);
        }
    }

    @Test
    void testDelete() {
        articleRepository.deleteAll();
        //articleRepository.deleteById(1428915630953861120l);
    }

    // 查询
    @Test
    void testFindAll() {
        articleRepository.findAll().stream().forEach(System.out::println);
    }

    // 查询 按主键
    @Test
    void testFindById() {
        Optional<Article> byId = articleRepository.findById(1428919945449836544l);
        if (byId.isPresent()) log.info("article = {}", byId.get());
    }

    // 排序分页查询
    @Test
    void testFindAllwithPaggingAndSorting() {
        Sort sort = Sort.by(Sort.Order.desc("aid"));
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        page.getContent().stream().forEach(System.out::println);
    }

    // 命名规则查询
    @Test
    void testFind01() {
        articleRepository.findByAuthorLike("liu").stream().forEach(System.out::println);
    }

    @Test
    void testFind02() {
        // 预期出处两个
        articleRepository.findByAidGreaterThan(1428919947748315136l).stream().forEach(System.out::println);
    }
}
