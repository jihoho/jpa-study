package jpastudy.start.ch6.model3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-23 Time: 오전 11:51
 */

//@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders=new ArrayList<Order>();

}
