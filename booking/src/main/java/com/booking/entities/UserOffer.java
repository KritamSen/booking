package com.booking.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="user_offers")
@IdClass(UserOffer.class)
@NoArgsConstructor
public class UserOffer implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="user_id" , referencedColumnName ="id")
    private User user;


    @Id
    @ManyToOne
    @JoinColumn(name="offer_id" , referencedColumnName ="id" )
    private Offer offer;




}
