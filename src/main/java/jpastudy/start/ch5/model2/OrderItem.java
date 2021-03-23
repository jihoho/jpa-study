package jpastudy.start.ch5.model2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-23 Time: 오후 12:12
 */

@Entity
@Table(name="ORDER_ITEM")
@Getter
@Setter
public class OrderItem {

    @Id  @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;  // 주문 상품

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;  // 주문

    private int orderPrice; //주문가격


}
