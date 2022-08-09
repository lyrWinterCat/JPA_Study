package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            // 새 주문 - 주문아이템 등록
//            Order order = new Order();
////            order.addOrderItem(new OrderItem()); // addOrderItem이라는 편의메서드 생성
//            //단방향 설계시 이렇게 너헝도 상관은 없음
//            // 왜?? 단방향 설계로도 돌아가긴 함
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//
//            em.persist(orderItem);

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("kyh");
            em.persist(book);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
