package com.dpattern.behavioural.chainofresponsibility;

/**
 * Part of Behavioral patterns
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {

        L1SupportHandler l1SupportHandler = new L1SupportHandler();
        L2SupportHandler l2SupportHandler = new L2SupportHandler();
        L3SupportHandler l3SupportHandler = new L3SupportHandler();

        // setting the delegation criteria
        l1SupportHandler.setNextHandler(l2SupportHandler);
        l2SupportHandler.setNextHandler(l3SupportHandler);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.MEDIUM);
        Request request3 = new Request(Priority.URGENT);

        l1SupportHandler.handleRequest(request1);
        l1SupportHandler.handleRequest(request2);
        l1SupportHandler.handleRequest(request3);
    }

}

interface SupportHandler {
    void handleRequest(Request request);
    void setNextHandler(SupportHandler handler);
}

class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}

enum Priority {
    BASIC, MEDIUM, URGENT
}

class L1SupportHandler implements SupportHandler {

    SupportHandler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.BASIC){
            System.out.println("L1SupportHandler is handling the request");
        } else {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }
}

class L2SupportHandler implements SupportHandler {

    SupportHandler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.MEDIUM){
            System.out.println("L2SupportHandler is handling the request");
        } else {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }
}

class L3SupportHandler implements SupportHandler {

    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.URGENT){
            System.out.println("L3SupportHandler is handling the request");
        } else {
            System.out.println("Error : request cann't be handled!");
        }
    }

    @Override
    public void setNextHandler(SupportHandler handler) {

    }
}