package com.dpattern;

/**
 * The front controller design pattern means that all requests that come for a resource in an application will be
 * handled by a single handler and then dispatched to the appropriate handler for that type of request. The front
 * controller may use other helpers to achieve the dispatching mechanism.
 *
 * https://www.geeksforgeeks.org/front-controller-design-pattern/
 *
 * @author Srinath.Rayabarapu
 */
public class FrontControllerMain {

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("Teacher");
        frontController.dispatchRequest("Student");
    }

}

class FrontController {

    Dispatcher dispatcher = null;
    FrontController(){
        this.dispatcher = new Dispatcher();
    }

    public void dispatchRequest(String request) {
        trackRequest(request);
        if (isAuthenticated(request)) {
            dispatcher.dispatch(request);
        }
    }

    private boolean isAuthenticated(String request) {
        System.out.println(request + " is authenticated!");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Tracking request: " + request);
    }

}

class Dispatcher {

    private StudentView studentView;
    private TeacherView teacherView;

    Dispatcher() {
        this.studentView = new StudentView();
        this.teacherView = new TeacherView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("teacher")) {
            this.teacherView.display(request);
        } else if (request.equalsIgnoreCase("student")) {
            this.studentView.display(request);
        }
    }
}

class StudentView {
    public void display(String request) {
        System.out.println("View rendered for - " + request);
    }
}

class TeacherView {
    public void display(String request) {
        System.out.println("View rendered for - " + request);
    }
}