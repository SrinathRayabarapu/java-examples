package com.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * class to show one-to-one relationship
 *
 * @author Srinath.Rayabarapu
 */
@Entity
@Table(name = "EventDetails")
public class EventDetails implements Serializable {

    public EventDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String details1;

    @Column
    private String details2;

    @Column
    private String details3;

    // this is bi-directional
//    @OneToOne(mappedBy = "eventDetails", cascade = CascadeType.ALL) // name should match with Event class field
    // this will remove only EventDetails object
    @OneToOne(mappedBy = "eventDetails", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getDetails3() {
        return details3;
    }

    public void setDetails3(String details3) {
        this.details3 = details3;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventDetails{" +
                "id=" + id +
                ", details1='" + details1 + '\'' +
                ", details2='" + details2 + '\'' +
                ", details3='" + details3 + '\'' +
                '}';
    }
}
