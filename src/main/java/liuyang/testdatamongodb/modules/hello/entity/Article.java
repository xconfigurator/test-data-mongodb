package liuyang.testdatamongodb.modules.hello.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author liuyang
 * @scine 2021/6/18
 */
/*
@Entity
@Table(name = "article")
 */
@Document(collection = "article")
@Data
@ToString
@EqualsAndHashCode
public class Article {

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    @Id
    private Long aid;

    @Field("Author")
    private String author;

    private Date createTime;

    private String title;
}
