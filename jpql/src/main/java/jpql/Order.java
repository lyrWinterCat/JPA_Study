package jpql;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {

    @Id @GeneratedValue
    private Long id;
    private int orderArgument;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderArgument() {
        return orderArgument;
    }

    public void setOrderArgument(int orderArgument) {
        this.orderArgument = orderArgument;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
