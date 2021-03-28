package jpastudy.start.ch6.model3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-28 Time: 오후 6:52
 */
@Entity
@Getter
@Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items= new ArrayList<Item>();

    // 카테고리의 계층 구조를 위한 필드들
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany
    private List<Category> child =new ArrayList<Category>();

//    연관 관계 메소드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

    public void addItem(Item item){
        items.add(item);
    }

}
