package jpastudy.start.ch6.ch6_4_4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 5:47
 */
@Entity
@Getter
@Setter
public class Product {
    @Id @Column(name = "PRODUCT_ID")
    private String id;

    private String name;
}
