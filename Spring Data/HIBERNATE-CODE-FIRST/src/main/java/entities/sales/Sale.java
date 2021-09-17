package entities.sales;


import entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {


    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDateTime date;

    public Sale() {
    }


    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    public Product getProduct() {
        return product;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    public Customer getCustomer() {
        return customer;
    }

    @ManyToOne
    @JoinColumn(name = "sore_location",referencedColumnName = "id")
    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    @Column(name = "date")
    public LocalDateTime getDate() {
        return date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
