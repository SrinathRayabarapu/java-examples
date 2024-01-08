package com.dpattern.behavioural.observer.ex1;

/**
 * It's a behaviour pattern - Observer1 design pattern is based on communicating changes in state of object to observers
 * so that they can take there action.
 * <p>
 * http://www.tutorialspoint.com/design_pattern/observer_pattern.htm.
 * <p>
 * Idea: Subject class has a state variable and list of Observer1 classes. Observer1 is an abstract class which has Subject
 * reference and an update method. Whenever a subject is passed to TestObserver classes they will be calling that subject
 * attach() method. Later when a subject setStatus() method is called, it will call notifyObjects() method which will call
 * internally update() method of each TestObserver class to which this Subject reference is passed.
 * <p>
 * Hence each status change will notify all the Observers
 *
 * @author Srinath.Rayabarapu
 */
public class ObserverPatternMain {

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