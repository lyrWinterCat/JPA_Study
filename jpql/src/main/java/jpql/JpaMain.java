package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
                Team teamA = new Team();
                teamA.setName("팀A");
                em.persist(teamA);

                Team teamB = new Team();
                teamB.setName("팀B");
                em.persist(teamB);

                Member member1 = new Member();
                member1.setUsername("회원1");
                member1.setAge(10);
                member1.setTeam(teamA);
                member1.setType(MemberType.USER);

                Member member2 = new Member();
                member2.setUsername("회원2");
                member2.setAge(10);
                member2.setTeam(teamA);
                member2.setType(MemberType.ADMIN);

                Member member3 = new Member();
                member3.setUsername("회원3");
                member3.setAge(10);
                member3.setTeam(teamB);
                member3.setType(MemberType.ADMIN);

                em.persist(member1);
                em.persist(member2);
                em.persist(member3);


//            em.flush();
//            em.clear();

            //모든 회원의 나이는 20살이야! //flush() 자동호출
            int resultCount = em.createQuery("update Member m set m.age=20").executeUpdate();

            System.out.println("resultCount = " + resultCount);

            System.out.println("member1.age= "+member1.getAge()); //10
            System.out.println("member2.age= "+member2.getAge()); //10
            System.out.println("member3.age= "+member3.getAge()); //10

            em.clear();
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getAge()); //20



//            List<Member> result = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1").getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

//            //엔티티 직접사용
//            String query = "select m from Member m where m=:member";
//            Member findMember = em.createQuery(query, Member.class).setParameter("member", member1).getSingleResult();
//            System.out.println("findMember = " + findMember);
//
//            String query2 = "select m from Member m where m.team=:team";
//            List<Member> members = em.createQuery(query2, Member.class).setParameter("team", teamA).getResultList();
//            for (Member member : members) {
//                System.out.println("member = " + member);
//            }


//            String query = "select m from Member m join fetch m.team";

//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername()+", "+member.getTeam().getName());
//                //회원1, 팀A(SQL)
//                //회원2, 팀A(1차캐시)
//                //회원3, 팀B(SQL)
//
//                // 회원 100명 -> N+1
//            }

//            String query2 = "select t from Team t join fetch t.members";
//            List<Team> resultList = em.createQuery(query2, Team.class).getResultList();
//            System.out.println("resultList.size() = " + resultList.size());
//
//            for (Team team : resultList) {
//                System.out.println("team = " + team.getName()+", "+team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("=======member = " + member+"=============");
//                }
//            }

//            String query1 = "select m.username From Member m"; //상태필드 >> 더이상 탐색 불가능
//            String query2 = "select m.team.***.$$. From Member m"; // 묵시적 내부조인 발생 >> 추가 탐색 가능 *조심해서 써야 함 (쿼리 튜닝 시 어려움)
//            String query3 = "select m.username From Team t join t.members m"; //컬랙션으로 묵시적 내부 조인은 발생하나, 추가 참색은 불가능 ( size 정도?)
            // 명시적 조인으로 별칭을 얻으면, 해당 별칭을 통해 탐색 가능


//            Collection result = em.createQuery(query3, Collection.class).getResultList();
//            for (Object o : result) {
//                System.out.println("o = " + o);
//            }



            //String query = "select coalesce(m.username,'이름없는회원') from Member m";
            //String query = "select nullif(m.username,'관리자') from Member m";

            //기본케이스 식
//            String query =
//                    "select "+
//                            "case when m.age <= 10 then '학생요금'"+
//                            " when m.age >= 60 then '경로요금'"+
//                            " else '일반요금'"
//                            +"end"
//                            +" from Member m";
//            List<String> resultList = em.createQuery(query, String.class).getResultList();
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }


//            String query = "select m.username From Member m "+"where m.type = : userType";
//            List userType = em.createQuery(query).setParameter("userType", MemberType.ADMIN).getResultList();
//
//            for (Object o : userType) {
//                System.out.println("o = " + o);
//            }

//            String query = "select m from Member m left join m.team t on t.name='teamA'";
//            String query2 = "select m from Member m join Team t on m.username=t.name";
//
//            List<Member> resultList = em.createQuery(query2, Member.class).getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }

           // List<Member> result = em.createQuery(query, Member.class).getResultList();
//            System.out.println("result.size() = " + result.size());
//
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }


//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username, m.age from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m");

//            List<Member> resultList = query1.getResultList(); //결과값이 여러개일때
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            Member singleResult = null; //결과값이 무조건 하나일 때
//            try {
//                // 많이나오면? 0개나오면???
//                // Spring data Jpa -> 결과가 없다면 null 반환 또는 optional 반환
//                // 아니면 그냥 try catch로 묶음
//                singleResult = query1.getSingleResult();
//            } catch (NoResultException e) {
////                return null;
////                return Optional.ofNullable();
//            }
//
//            System.out.println("singleResult = " + singleResult);

//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username","member1");
//            Member singleResult1 = query.getSingleResult();
//            System.out.println("singleResult1 = " + singleResult1);
//
//            //파라미터 바인딩 이름 / 위치 기준
//            // 이름으로 사용. 위치는 비추천
//            Member singleResult = em.createQuery("select m from Member m where m.username=:username", Member.class)
//                    .setParameter("username", "member1").getSingleResult();
//
//            System.out.println("singleResult = " + singleResult);



            //엔티티 프로젝션
           // List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
//            Member findMember = result.get(0);
//            findMember.setAge(20);

            //join - sql과 최대한 비슷하게 작성 (묵시적 join)
            //List<Team> result = em.createQuery("select m.team from Member m join m.team t", Team.class).getResultList();

            //임베디드 프로젝션 (엔티티로부터 시작)
            //List<Address> result = em.createQuery("select o.address from Order o", Address.class).getResultList();

            // 스칼라 타입 프로젝션 >> sql문처럼 작성
            // 타입이 2개인데? 어떻게 조회??
            // 쿼리타입 / object[] 타입입
//           List resultList1 = em.createQuery("select m.username, m.age from Member m").getResultList();
//
//           Object o = resultList1.get(0);
//           Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);
//
//            List<Object[]> resultList2 = em.createQuery("select m.username, m.age from Member m").getResultList();
//            Object[] result2 = resultList2.get(0);
//            System.out.println("username = " + result2[0]);
//            System.out.println("age = " + result2[1]);
//
//            // new 명령어로 조회
//            List<MemberDTO> resultList3 = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();
//            MemberDTO memberDTO = resultList3.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }
}
