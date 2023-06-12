package com.booking.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="bus_operators")
@NoArgsConstructor
public class BusOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="operator_name")
    private String operatorName;

    @Column(name="contact_email")
    private String contectEmail;

    private String contectPhone;

    @Column(name="logo_url")
    private String logoUrl;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "busOperator" , cascade = CascadeType.ALL)
    private Set<Bus> buses;
}
