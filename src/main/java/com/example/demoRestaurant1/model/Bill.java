package com.example.demoRestaurant1.model;





import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue
    private int billId;
    @Column(name="name")
    private String name;
    @Column(name="date")
    private LocalDateTime date;
    @Column(name="total_price")
    private int totalPrice;

    @PrePersist
    public void prePersist() {
        date= LocalDateTime.now();
    }
    @OneToOne
   private Order order;
}

