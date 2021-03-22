package jpastudy.start;

import javax.persistence.*;
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
            testSave(em);
//            objectQuery(em);
//            queryLogicJoin(em);
//            updateRelation(em);
            biDirection(em);
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
        Team team1=new Team();
        team1.setId("team1");
        team1.setName("팀1");
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


/*    public static void objectQuery(EntityManager em) {
        Member member =em.find(Member.class,"member1");
        Team team=member.getTeam();
        System.out.println("팀 이름 = "+team.getName());
    }

    public static void queryLogicJoin(EntityManager em){
        String jpql="select m from Member m join m.team t where "+
                "t.name=:teamName";
        List<Member> resultList= em.createQuery(jpql,Member.class)
                .setParameter("teamName","팀1")
                .getResultList();

        for(Member member:resultList){
            System.out.println("[query] member.username= "+member.getUsername());
        }
    }

    public static void updateRelation(EntityManager em){
//        새로운 팀2
        Team team2= new Team("team2","팀2");
        em.persist(team2);

//        회원1에 새로운 팀2 설정
        Member member=em.find(Member.class,"member1");
        member.setTeam(team2);
    }*/

    public static void biDirection(EntityManager em){
        Team team=em.find(Team.class,"team1");
        List<Member> members=team.getMembers();
        System.out.println(members);
        for (Member member:members){
            System.out.println("member.username= "+member.getUsername());
        }
    }
}
