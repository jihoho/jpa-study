package jpastudy.start.ch6.ch6_4_1;



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
            find(em);
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
        Product productA= new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member member1=new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA); // 연관관계 설정
        em.persist(member1);


    }
    public static void find(EntityManager em){
        Member member= em.find(Member.class,"member1");
        List<Product> products=member.getProducts(); // 객체 그래프 탐색
        for (Product product:products){
            System.out.println("product.name= "+product.getName());
        }

    }

}
