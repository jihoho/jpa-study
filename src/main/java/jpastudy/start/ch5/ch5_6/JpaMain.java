package jpastudy.start.chap05;

import jpastudy.start.ch5.ch5_6.Member;
import jpastudy.start.ch5.ch5_6.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: hojun
 * Date: 2021-02-25 Time: 오후 6:13
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
//            testSave(em);
//            testSaveNonOwner(em);
            testORM_양방향(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void testSave(EntityManager em) {
//        팀1 저장
        Team team1=new Team("team1","팀1");
        em.persist(team1);

//        회원1 저장
        Member member1=new Member("member1","회원1");
        member1.setTeam(team1);
        em.persist(member1);    // 연관 관계 설정 member1 -> team1

//        회원2 저장
        Member member2=new Member("member2","회원2");
        member2.setTeam(team1);  // 연관 관계 설정 member2 -> team1
        em.persist(member2);
    }

    public static void testSaveNonOwner(EntityManager em){

        Member member3=new Member("member3","회원3");
        em.persist(member3);
        Member member4=new Member("member4","회원4");
        em.persist(member4);

        Team team2=new Team("team1","팀1");
//        주인 아닌 곳만 연관관계 설정
        team2.getMembers().add(member3);
        team2.getMembers().add(member4);

        em.persist(team2);

    }

    public static void testORM_양방향(EntityManager em){
        //        팀1 저장
        Team team1=new Team("team1","팀1");
        em.persist(team1);

        //        회원1 저장
        Member member1=new Member("member1","회원1");
//        양방향 연관관계 설정
        member1.setTeam(team1);
        team1.getMembers().add(member1);
        em.persist(member1);    // 연관 관계 설정 member1 -> team1

        //        회원2 저장
        Member member2=new Member("member2","회원2");
        member2.setTeam(team1);  // 연관 관계 설정 member2 -> team1
        team1.getMembers().add(member2);
        em.persist(member2);

    }

}
