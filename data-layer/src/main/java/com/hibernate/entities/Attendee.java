package com.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "Attendee")
public class Attendee {

    private int attendeeId;
    private String name;

    public Attendee(){
    }

    public Attendee(String name) {
        this.name = name;
    }

    @Column(name = "attendee_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendee_id")
    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "attendeeId=" + attendeeId +
                ", name='" + name + '\'' +
                '}';
    }

}