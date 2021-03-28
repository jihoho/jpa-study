package jpastudy.start.ch6.ch6_3_1;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 4:58
 */
//@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;
}
