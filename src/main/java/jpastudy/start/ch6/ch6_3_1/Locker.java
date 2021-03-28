package jpastudy.start.ch6.ch6_3_1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 5:00
 */
//@Entity
public class Locker {
    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;
}
