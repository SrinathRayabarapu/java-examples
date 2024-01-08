package com.hibernate;

import com.hibernate.entities.*;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * An app to practice hibernate concepts. It covers the following
 * 1. Configurations and Entity mappers
 * 2. Basic CRUD operations
 * 3. Mapping between the Entities
 * 4.
 *
 * @author Srinath.Rayabarapu
 */
public class EventOrganizerMain {

    private static final Logger LOG = LoggerFactory.getLogger(EventOrganizerMain.class);

    public static void main(String[] args) {

        // creating events
//        createEvents("Hibernate Training", new Date(System.currentTimeMillis()));

        // read ---------
//        Event event = (Event) session.get(Event.class, 9L);
//        LOG.info(event.toString());

        // update ---------
//        updateEvents();

        // delete ---------
//        deleteEvents();
//        deleteEventDetails();

        HibernateUtil.shutdownSessionFactory();
    }

    private static void deleteEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event delEvent = (Event) session.get(Event.class, 5L);

        // method 1
        session.delete(delEvent);

        // method 2
//        session.createQuery("delete from Event where location='1'").executeUpdate();

        session.getTransaction().commit();
    }

    private static void deleteEventDetails() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        EventDetails delEventDetails = (EventDetails) session.get(EventDetails.class, 2L);

        // if we want only EventDetails to be deleted then we need to break the relation as below
//        delEventDetails.getEvent().setEventDetails(null);

        session.delete(delEventDetails);

        session.getTransaction().commit();
    }

    private static void updateEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event event = (Event) session.get(Event.class, 9L);

        // method 1
        event.setTitle("Hibernate updated!");

        //we don't have to save event object explicitly, flush or commit does that!
        session.flush();

        List<Event> eventsList = session.createQuery("from Event where location='9'").list();
        eventsList.forEach(System.out::println);

        // method 2
        session.createQuery("update Event set title='Hibernate updated again!!' where location='9'").executeUpdate();

        session.getTransaction().commit();
    }

    private static void createEvents(String title, Date theDate) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // create
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);

        EventDetails eventDetails = new EventDetails();
        eventDetails.setDetails1("blah");
        eventDetails.setDetails2("blah blah");
        eventDetails.setDetails3("blah blah blah");
        theEvent.setEventDetails(eventDetails);

        Location location = new Location("Bangalore");
        theEvent.setLocation(location);

        Set<Speaker> speakerSet = new HashSet();
        speakerSet.add(new Speaker("Shweta", "Hibernate", new Date(System.currentTimeMillis())));
        GregorianCalendar cal = new GregorianCalendar(2010, 10, 10);
        speakerSet.add(new Speaker("Rajagopal Sir", "Spring", cal.getTime()));
        theEvent.setSpeakers(speakerSet);

        Set<Attendee> attendeeSet = new HashSet();
        attendeeSet.add(new Attendee("Srinath"));
        attendeeSet.add(new Attendee("Shubha"));
        theEvent.setAttendees(attendeeSet);

        session.save(theEvent);

        session.getTransaction().commit();

    }
}