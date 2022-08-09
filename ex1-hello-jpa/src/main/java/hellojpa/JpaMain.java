package hellojpa;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//            Member findmember = em.find(Member.class, 1L); //JPA를 통해서 가져온 객체는 JPA가 관리함
//            System.out.println("findmember.getId = " + findmember.getId());
//            System.out.println("findmember.getName = " + findmember.getName());
//            em.remove(findmember); >> 찾은 멤버 삭제

//            findmember.setName("ByeA"); // >> 수정할 멤버를 찾아서 새롭게 set 하고, persist를 다시 해주지 않아도 됨

            //Member 객체를 대상으로 한 쿼리 >> JPQL
//            List<Member> result = em.createQuery("select m from Member"
//                            //+" as m where m.name==:??" //이런식으로 조건을 줄 수도 있음
//                            , Member.class)
//                    //.setFirstResult(5) // 페이징 첫번째 페이지
//                    //.setMaxResults(8) // 페이징 마지막 페이지 설정
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            //비영속상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPAA");
//
//            //영속상태
//            System.out.println("=======BEFORE========");
//            em.persist(member); //1차 캐시에 저장
//            System.out.println("=======AFTER========");
//
            // 1차 캐시
//            Member a = em.find(Member.class, 101L); //DB에서 가져옴, 영속 컨텍스트에 올림
//            Member b = em.find(Member.class, 101L); // 영속 컨테스트 안의 1차 캐시에서 조회
//            // 쿼리문은 1번만 실행
//
            //동일성 보장
//            System.out.println(a==b);
//
//            //DB조회가 아닌 1차캐시에서 조회
//            System.out.println("findMember1.getId() = " + findMember.getId());
//            System.out.println("findMember1.getName() = " + findMember.getName());

            //트랜잭션을 지원하는 쓰기 지연
            //영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("===============================");

            // 영속
            //엔티티 수정
            //변경 감지 (dirty check)
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZ");
            
//            if(member.getName().equals("ZZZ")){
//                em.update(member);
//            } >> 이런 update 코드를 짜지 않아도 자동을 update 날림
            
            //em.persist(member); update시 persist는 해 줄 필요 없음

            //영속성 컨텍스트 플러시
//            Member member = new Member(200L,"member200");
//            em.persist(member);
//
//            em.flush();
//
//            System.out.println("========================");

            //영속 준영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//            //em.detach(member); //JPA에서 관리하지 않음 >> 준영속상태로 변경
//
//            em.clear(); //영속성 컨테스트 초기화
//            Member member2 = em.find(Member.class, 150L); //처음부터 다시 찾음
//
//            System.out.println("========================");

//            Member member = new Member();
//            member.setId(1L);
//            member.setUsername("A");
//            member.setRoleType(RoleType.USER);
//
//            em.persist(member);

//            Member member = new Member();
//            //member.setId("ID_A");
//            member.setUsername("C");
//            em.persist(member);



            //저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");

            //member.setTeam(team); // ** 이부분이 중요함 반드시 필요 !

            //member.setTeamId(team.getId());


            //team.getMembers().add(member); // >> 이것만 한다면 이건 거짓매핑. 동작안함.
            // 양쪽에 다 값을 입력하는 것이 객체관계를 고려한다면 좋음

//            em.persist(member);
//
//            //member기준? team기준?
//            team.addMember(member);
            //member.changeTeam(team);

            //쿼리문을 보고싶다면 영속성을 제거해주면 됨
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }

            // Member findMember = em.find(Member.class, member.getId());

            //Long findTeamId = findMember.getTeamId();
//            Team findTeam = findMember.getTeam();
//
//            System.out.println("findTeam = " + findTeam.getName());
            //Team findTeam = em.find(Team.class, findTeamId);

//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
            //===========================================22.08.02=====================================================

//            Movie movie = new Movie();
//            movie.setActor("배우");
//            movie.setDirector("감독");
//            movie.setPrice(15000);
//            movie.setName("바람과 함께 사라지다");
//
//            em.persist(movie);

            //프록시
//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);

            //            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("findMember.Id = " + findMember.getId());
//            System.out.println("findMember.Username = " + findMember.getUsername());

//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            member1.setTeam(team);

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);

//            em.flush();
//            em.clear();

//            Member m = em.find(Member.class, member1.getId());
//            System.out.println("m = " + m.getTeam().getClass());
//
//            System.out.println("===============");
//            m.getTeam().getName(); //초기화
//            System.out.println("teamName = " + m.getTeam().getName()); //초기화
//            System.out.println("===============");

            //즉시로딩시 em.find 에서는 문제가 없음
            // 그러나 createQuery로 select를 하면...? >> select문이 2개!
            //List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

            //SQL : select * from Member (1차적으로 DB로 보냄)
            // 어라..? team도 가지고 와야하네..? >> 즉시로딩딩
           //SQL : select * from Team where TEAM_ID = xxx



//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//            Member m2 = em.find(Member.class, member2.getId());

            //System.out.println("m1==m2 : "+(m1.getClass() == m2.getClass()));
            // find + getReference 비교 >> false
            // find + getReference 비교에서 true가 나오기 위해서는 instanceof가 필요 >> logic 참고

            //logic(m1, m2);
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); //Proxy
//            //refMember.getUsername();//강제 호출
//            //System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//            Hibernate.initialize(refMember);//강제 초기화

            //========================================================================================


//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//
//            // 귀찮아. 내가 parent 를 persist 할 때 child도 자동으로 persist 했으면 좋겠어..! >> cascade!
//
//            Parent parent1 = em.find(Parent.class, 1L);
//            parent1.getChildList().remove(0);

            //=================================================================================
//            Address address = new Address("city","street","zip");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address newAddress = new Address("newCity",address.getStreet(),address.getZipcode());
//            member.setHomeAddress(newAddress);

//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
            //member.getHomeAddress().setCity("newCity");

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("city1","street","10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
//            member.getAddressHistory().add(new AddressEntity("old2","street","10000"));
//
//            //저장
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("============START=========================");
//            Member findMember = em.find(Member.class, member.getId());

            //조회
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            //city1 >> newCity로 수정
//            findMember.getHomeAddress().setCity("newCity");
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity",a.getStreet(),a.getZipcode()));
//
//            //치킨 >> 연어
//            //수정한다는 개념 X , 새로 갈아 낀다는 식으로 접근
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("연어");
//
//            findMember.getAddressHistory().remove(new AddressEntity("old1","street","10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1","street","10000"));

            //============================================20220807=======================================
//            List<Member> result = em.createQuery("select m from Member m where m.username like '%kim%'", Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);
            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//    }

//    private static void printMember(Member member){
//        System.out.println("member = " + member.getUsername());
//    }

//    private static void logic(Member m1, Member m2){
//        System.out.println("m1 == m2 : " + (m1 instanceof Member));
//        System.out.println("m1 == m2 : " + (m2 instanceof Member));
//    }
}
