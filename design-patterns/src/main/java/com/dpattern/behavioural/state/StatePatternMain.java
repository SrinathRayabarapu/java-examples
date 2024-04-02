package com.dpattern.behavioural.state;

/**
 *
 */
public class StatePatternMain {

    public static void main(String[] args) {
        VendingMachineContext machine = new VendingMachineContext();
        machine.setState(new ReadyState());
        machine.request();

        machine.setState(new ProductSelectedState());
        machine.request();

        machine.setState(new PaymentPendingState());
        machine.request();

//        machine.paymentSuccessful();
//        machine.outOfStock();

        machine.setState(new DispatchedState());
        machine.request();

        machine.setState(new ReadyState());
        machine.request();
    }

}

class VendingMachineContext {
    VendingMachineState state;

    void request(){
        state.handleRequest();
    }

    void setState(VendingMachineState state){
        this.state = state;
    }

}

interface VendingMachineState {
    void handleRequest();
}

class ReadyState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Vending machine is in Ready state");
    }
}

class ProductSelectedState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Product is selected");
    }
}

class PaymentPendingState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Payment is pending");
    }
}

class DispatchedState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Product is dispatched");
    }
}

class OutOfStackState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Product is not available!");
    }
}