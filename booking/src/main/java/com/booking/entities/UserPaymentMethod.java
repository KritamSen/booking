package com.booking.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="user_payment_methods")
@NoArgsConstructor
public class UserPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="user_id" , referencedColumnName ="id")
    private User user;

    @Column(name="payment_type")
    private String paymentType;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="expiration_date")
    private String expirationDate;

    @Column(name="card_holder_name")
    private String cardHolderName;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;
    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;




}
