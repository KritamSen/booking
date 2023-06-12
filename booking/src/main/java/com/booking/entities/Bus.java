package com.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="buses")
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="operator_id" , referencedColumnName ="id")
    private User busOperator;

    @Column(name="bus_type")
    private String busType;

    @Column(name="amenities")
    private String amenities;

    @Column(name="total_seats")
    private int totalSeats;

    @Column(name="updated_at")
    private Date updatedAt;


    @Column(name="created_at")
    private Date createdAt;


    @OneToMany(mappedBy = "bus" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Schedule> schedules;
}
