package pub.imlichao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

//注释此类将被映射到数据库的一个集合（collection为集合名称）
@Document(collection = "pmall")

//创建联合索引
@CompoundIndexes({
        //联合索引 name 索引名称 、def 索引字段、parameter1升序、parameter3降序
        @CompoundIndex(name = "compound_index", def = "{'parameter1': 1, 'parameter3': -1}")
})

public class EntityTest implements Serializable {
    //标记id字段
    @Id
    private ObjectId id;
    //创建单字段索引（默认ASCENDING 升序、DESCENDING 降序）
    @Indexed(direction = DESCENDING)
    private Long parameter1;
    //修改映射到数据库中的名称
    @Field("parameter2_")
    private String parameter2;

    private Date parameter3;

    private Integer parameter4;

    //关联其他集合（不添加此注释时List将会保存具体的实体值，而添加了此注释List保存的是关联集合的id）
    @DBRef
    private List<EntityTest1> parameter5;
    //此字段不映射到数据库
    @Transient
    private Integer parameter6;

    public EntityTest(){

    }
    //声明构造函数，用于实例化查询结果数据
    @PersistenceConstructor
    public EntityTest(Long parameter1, String parameter2, Date parameter3, Integer parameter4, List<EntityTest1> parameter5) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
        this.parameter4 = parameter4;
        this.parameter5 = parameter5;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getParameter1() {
        return parameter1;
    }

    public void setParameter1(Long parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public Date getParameter3() {
        return parameter3;
    }

    public void setParameter3(Date parameter3) {
        this.parameter3 = parameter3;
    }

    public Integer getParameter4() {
        return parameter4;
    }

    public void setParameter4(Integer parameter4) {
        this.parameter4 = parameter4;
    }

    public List<EntityTest1> getParameter5() {
        return parameter5;
    }

    public void setParameter5(List<EntityTest1> parameter5) {
        this.parameter5 = parameter5;
    }

    public Integer getParameter6() {
        return parameter6;
    }

    public void setParameter6(Integer parameter6) {
        this.parameter6 = parameter6;
    }
}
