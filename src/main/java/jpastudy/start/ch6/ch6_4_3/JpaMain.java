package jpastudy.start.ch6.ch6_4_3;



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
        // 회원 저장
        Product productA= new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);
        // 상품 저장
        Member member1=new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        // 회원 상품 저장
        MemberProduct memberProduct=new MemberProduct();
        memberProduct.setMember(member1); // 주문 회원 - 연관관계 설정
        memberProduct.setProduct(productA);  // 주문 상품 - 연관관계 설정
        memberProduct.setOrderAmount(2); // 주문 수량
        em.persist(memberProduct);


    }
    public static void find(EntityManager em){
        // 기본키 값 생성
        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        MemberProduct memberProduct =em.find(MemberProduct.class,memberProductId);

        Member member= memberProduct.getMember();
        Product product =memberProduct.getProduct();

        System.out.println("member="+member.getUsername());
        System.out.println("product="+product.getName());
        System.out.println("orderAmount="+memberProduct.getOrderAmount());
    }


}
