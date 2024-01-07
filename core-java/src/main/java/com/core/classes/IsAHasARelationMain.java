package com.core.classes;

/**
 * shows IS A and HAS A relationship between classes
 *
 * @author Srinath.Rayabarapu
 */
public class IsAHasARelationMain {

    public static void main(String[] args) {
        Scooter dio = new Dio(new Engine());
        dio.start();
        dio.stop();
    }

}

abstract class Scooter{
    abstract void start();
    abstract void stop();
}

class Engine{
    void startingSound(){
        System.out.println("Rum rum..");
    }
    void stoppingSoud(){
        System.out.println("Sszz..");
    }
}

/**
 * Dio IS A Scooter
 */
class Dio extends Scooter{

    // Dio HAS A Engine
    private Engine engine;

    Dio(Engine engine){
        this.engine = engine;
    }

    @Override
    void start() {
        this.engine.startingSound();
        System.out.println("Dio started");
    }

    @Override
    void stop() {
        this.engine.stoppingSoud();
        System.out.println("Dio stopped");
    }

}