package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//@Table(name="USER") 이런 식으로 테이블 이름 설정 가능

// GenerationType.SEQUENCE 로 쓸 때 sequence 지정을 따로 안하면 기본 hibernate_sequence로 생성
//@SequenceGenerator(
//        name="MEMBER_SEQ_GENERATOR",
//        sequenceName="MEMBER_SEQUENCE",
//        initialValue = 1, allocationSize = 1)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
@Entity
public class Member //extends BaseEntity {
{
//    @Id
//    private Long id;
//
//    //@Column(name="설정컬럼명") 으로 직접 설정 가능
//    private String name;

    /*
    <!--데이터베이스 스키마 자동생성 - 속성-->
            <property name="hibernate.hbm2ddl.auto" value="create" />
     을 넣었을때 변화 보기 위한 설정
     */
    //private int age;

//필드와 컬럼 매핑 실습
    @Id //PK
    @GeneratedValue//(strategy = GenerationType.SEQUENCE)
    @Column(name="MEMBER_ID")
    private Long id;
    //private String id;

    @Column(name = "USERNAME")//, nullable = false) //다른 이름으로 매핑
    private String username;

    @ElementCollection
    @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_MNAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name="ADDRESS", joinColumns = @JoinColumn(name="MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="city",column=@Column(name = "WORK_CITY")),
//            @AttributeOverride(name="street",column=@Column(name = "WORK_STREET")),
//            @AttributeOverride(name="zipcode",column=@Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

//    @Column(name="TEAM_ID")
//    private Long teamId;

//    @ManyToOne(fetch = FetchType.EAGER) //member = many , team = one / fetchType : 지연로딩전략
//    @JoinColumn(name = "TEAM_ID") //여기서 insertable=false, updatable=false 를 넣어준다면 일대다 양방향 가능 (여기에서의 team은 읽기전용필드로 사용하겠다고 알려줌)
//    private Team team;
//
//    @OneToOne
//    @JoinColumn(name="LOCKER_ID") //1:1관계
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();
//
////    public String createdBy;
////    public LocalDateTime creatdDate;
////    private String lastModifiedBy;
////    private LocalDateTime lastModifiedDate;
//
//
////getter setter
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//        //team.getMembers().add(this);
//        //this=Member()
//    }
//
//    //편의메서드
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//        //this=Member()
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }

    //    public Member(){}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    //    private Integer age;
//
//    @Enumerated(EnumType.STRING) //enum 매핑
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP) //날짜 타입 : 날짜 + 시간
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    //최신버전 추천 (매핑 없이도 인식 가능)
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//
//    @Lob
//    private String description;



//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

}
