package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "team") // mapped by :: members가 Member의 team이랑 걸려있어! 라고 알려주는 것
//    private List<Member> members = new ArrayList<>();




    //편의메서드
//    public void addMember(Member member) {
//        member.setTeam(this);
//        members.add(member);
//    }

//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
