package jpastudy.start.chap05;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-03-22 Time: 오후 6:41
 */
public class JpaMainTest {
    @Test
    public void test순수한객체_양방향(){
        //    팀1
        Team team1=new Team("team1","팀1");
        Member member1=new Member("member1","회원1");
        Member member2=new Member("member2","회원2");

        member1.setTeam(team1);
        member2.setTeam(team1);

        List<Member> members=team1.getMembers();
        System.out.println("members.size = "+members.size());
    }

    @Test
    public void test순수한객체_양방향2(){
        Team team1=new Team("team1","팀1");
        Member member1=new Member("member1","회원1");
        Member member2=new Member("member2","회원2");

        member1.setTeam(team1);
        team1.getMembers().add(member1);
        member2.setTeam(team1);
        team1.getMembers().add(member2);


        List<Member> members=team1.getMembers();
        System.out.println("members.size = "+members.size());


    }

}