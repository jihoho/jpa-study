package jpastudy.start.ch6.ch6_4_3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 5:44
 */
//@Entity
@Getter
@Setter
public class Member {

    @Id @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts;
 }
