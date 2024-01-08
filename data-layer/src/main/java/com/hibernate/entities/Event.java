package com.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Event entity which has relationships for ManyToOne, OneToMany and ManyToMany.
 */
@Entity
@Table(name = "Event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_title")
    private String title;

    @Column(name = "start_date")
    private Date date;

    // all available options {ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH}
    @OneToOne(cascade = CascadeType.ALL)
    // this is uni-directional
    @JoinColumn(name = "eventDetails_id")
    private EventDetails eventDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location = new Location();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Speaker> speakers;

    // this is bi-directional
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "attendee_id")}
    )
    private Set<Attendee> attendees;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<Attendee> attendees) {
        this.attendees = attendees;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", eventDetails=" + eventDetails +
                ", location=" + location +
                ", speakers=" + speakers +
                ", attendees=" + attendees +
                '}';
    }

}