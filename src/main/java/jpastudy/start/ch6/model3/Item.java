package jpastudy.start.ch6.model3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-23 Time: 오후 12:19
 */
//@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name; // 이름
    private  int price; // 가격
    private int stockQuantity; // 재고수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories= new ArrayList<Category>();

}
