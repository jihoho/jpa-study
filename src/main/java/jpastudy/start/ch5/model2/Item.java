package jpastudy.start.ch5.model2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-23 Time: 오후 12:19
 */
@Entity
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

}
