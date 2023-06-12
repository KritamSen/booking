package com.booking.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="routes")
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="origin")
    private String origin;

    @Column(name="destination")
    private String destination;

    @Column(name="distance")
    private double distance;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "route" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Schedule> schedules;

}
