package jpastudy.start.ch5.ch5_6_2;

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
//            testORM_양방향(em);
            test3(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

 

    public static void testORM_양방향(EntityManager em){
        //        팀1 저장
        Team team1=new Team("team1","팀1");
        em.persist(team1);

        //        회원1 저장
        Member member1=new Member("member1","회원1");
//        양방향 연관관계 설정
        member1.setTeam(team1); // 양방향 연관 관계 설정
        em.persist(member1);    

        //        회원2 저장
        Member member2=new Member("member2","회원2");
        member2.setTeam(team1);  // 양방향 연관 관계 설정
        em.persist(member2);

    }

    public static void test3(EntityManager em){
        //        팀A 저장
        Team teamA=new Team("teamA","팀A");
        em.persist(teamA);

        //        팀A 저장
        Team teamB=new Team("teamB","팀B");
        em.persist(teamB);

        //        회원1 저장
        Member member1=new Member("member1","회원1");
        //        양방향 연관관계 설정
        member1.setTeam(teamA); // 양방향 연관 관계 설정
        em.persist(member1);

        member1.setTeam(teamB);
        em.persist(member1);

        List<Member> members = teamA.getMembers();
    }
}
