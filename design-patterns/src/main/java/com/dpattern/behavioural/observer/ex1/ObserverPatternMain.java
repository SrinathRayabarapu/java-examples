package com.dpattern.behavioural.observer.ex1;

/**
 * Demonstrates the Observer Design Pattern - one of the Gang of Four (GoF) Behavioral patterns.
 * 
 * <p>The Observer pattern defines a one-to-many dependency between objects so that when one
 * object (the Subject) changes state, all its dependents (Observers) are notified and updated
 * automatically. Also known as Publish-Subscribe pattern.</p>
 * 
 * <h3>Pattern Structure:</h3>
 * <ul>
 *   <li><b>Subject</b> ({@link Subject}) - Maintains a list of observers and notifies them of state changes</li>
 *   <li><b>Observer</b> ({@link Observer}) - Abstract class defining the update interface</li>
 *   <li><b>Concrete Observers</b> ({@link Observer1}, {@link Observer2}, {@link Observer3}) - React to subject's state changes</li>
 * </ul>
 * 
 * <h3>How It Works:</h3>
 * <ol>
 *   <li>Observer registers with Subject via {@code attach()} method</li>
 *   <li>Subject's state changes via {@code setState()}</li>
 *   <li>Subject calls {@code notifyAllObservers()}</li>
 *   <li>Each Observer's {@code update()} method is invoked</li>
 *   <li>Observers pull the new state from Subject</li>
 * </ol>
 * 
 * <h3>Real-World Examples:</h3>
 * <ul>
 *   <li>Event listeners in GUI frameworks</li>
 *   <li>Newsletter subscriptions</li>
 *   <li>Stock price updates</li>
 *   <li>MVC architecture (View observes Model)</li>
 *   <li>Social media notifications</li>
 * </ul>
 * 
 * <h3>Benefits:</h3>
 * <ul>
 *   <li>Loose coupling between Subject and Observers</li>
 *   <li>Support for broadcast communication</li>
 *   <li>Dynamic relationship establishment</li>
 * </ul>
 *
 * @author Srinath.Rayabarapu
 * @see Subject
 * @see Observer
 */
public class ObserverPatternMain {

    /**
     * Demonstrates the Observer pattern with a Subject and multiple Observers.
     * 
     * <p>Shows that observers are only notified after they are attached to the subject,
     * and subsequent state changes trigger updates to all registered observers.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        //the one that changes it's state
        Subject subject = new Subject();

        //changing the status - but here no impact
        subject.setState(0); //this doesn't have any effect as subject is not attached to a Observer1

        //adding subject to multiple observers whom will get intimated
        new Observer1(subject);
        new Observer2(subject);
        new Observer3(subject);

        //this status change will impact above observers
        subject.setState(1);
    }
}