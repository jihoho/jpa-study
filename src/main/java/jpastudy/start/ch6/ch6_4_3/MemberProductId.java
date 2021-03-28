package jpastudy.start.ch6.ch6_4_3;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-25 Time: 오후 7:04
 */
@Getter
@Setter
public class MemberProductId implements Serializable {
    private String member; // MemberProduct.member와 연결
    private String product; // MemberProduct.product와 연결

    // hashCode and equals


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
