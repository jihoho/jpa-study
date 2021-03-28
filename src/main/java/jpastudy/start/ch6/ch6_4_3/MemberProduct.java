package jpastudy.start.ch6.ch6_4_3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 7:01
 */

//@Entity
@IdClass(MemberProductId.class)
@Getter
@Setter
public class MemberProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member; // MemberProductId.member와 연결

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product; // MemberProductId.product와 연결

    private int orderAmount;
}
