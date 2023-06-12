package com.booking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="schedules")
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="bus_id" , referencedColumnName ="id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name="route_id" , referencedColumnName ="id")
    @JsonBackReference
    private Route route;


    @Column(name="departure_time")
    private Date departureTime;

    @Column(name="arrival_time")
    private Date arrivalTime;



    @Column(name="price")
    private long price;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "schedule" , cascade = CascadeType.ALL)
    private Set<Booking> bookings;
}
