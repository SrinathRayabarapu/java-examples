package com.dpattern.creational.singleton;

public class SingletonVolatileMain {

    // create a singleton class implementation using volatile keyword
    // to make sure that the instance is created only once and is thread safe
    private static volatile SingletonVolatileMain instance;

    private SingletonVolatileMain() {
        // private constructor to prevent instantiation
    }

    public static SingletonVolatileMain getInstance() {
        if (instance == null) {
            synchronized (SingletonVolatileMain.class) {
                if (instance == null) {
                    instance = new SingletonVolatileMain();
                }
            }
        }
        return instance;
    }

    // Example usage
    public static void main(String[] args) {
        SingletonVolatileMain singleton1 = SingletonVolatileMain.getInstance();
        SingletonVolatileMain singleton2 = SingletonVolatileMain.getInstance();

        System.out.println(singleton1 == singleton2); // true, both references point to the same instance
    }
    // This implementation is thread-safe and ensures that only one instance of the SingletonVolatileMain class is created.
    // The use of volatile keyword ensures that the instance is visible to all threads and prevents the creation of multiple instances.
    // This implementation is also lazy-loaded, meaning that the instance is created only when it is needed.
    // This is a common pattern used in Java to implement the Singleton design pattern.
    // Note: This implementation is not breakable with reflection, serialization, or cloning.
    // However, it is important to note that this implementation is not completely foolproof and can still be broken in some cases.
    // For example, if the SingletonVolatileMain class is loaded by multiple class loaders, each class loader will have its own instance of the SingletonVolatileMain class.
    // To prevent this, you can use the Enum singleton pattern, which is the most robust way to implement a singleton in Java.
    // The Enum singleton pattern is thread-safe, serialization-safe, and reflection-safe.
    // However, it is important to note that the Enum singleton pattern is not always the best choice for all use cases.
    // It is important to consider the specific requirements of your application and choose the appropriate singleton implementation accordingly.
    // In conclusion, the SingletonVolatileMain class is a simple
    // and effective way to implement the Singleton design pattern in Java.
    // It is important to understand the limitations of this implementation and choose the appropriate singleton implementation based on the specific requirements of your application.

}
