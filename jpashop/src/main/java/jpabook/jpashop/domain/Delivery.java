package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery  extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @Embedded
    private Address addresss;


    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;


    public Address getAddresss() {
        return addresss;
    }

    public void setAddresss(Address addresss) {
        this.addresss = addresss;
    }

}
