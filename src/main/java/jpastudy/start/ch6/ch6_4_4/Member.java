package jpastudy.start.ch6.ch6_4_4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 5:44
 */
@Entity
@Getter
@Setter
public class Member {

    @Id @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @OneToMany(mappedBy = "member")
    private List<Order> orders=new ArrayList<Order>();

 }
