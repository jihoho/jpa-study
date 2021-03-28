package jpastudy.start.ch5.ch5_6_2;

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
 * Date: 2021-02-25 Time: 오후 7:19
 */

//@Entity
@Getter
@Setter
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members=new ArrayList<Member>();


}
