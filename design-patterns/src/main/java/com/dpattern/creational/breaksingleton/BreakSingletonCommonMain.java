package com.dpattern.creational.breaksingleton;

import com.dpattern.creational.singleton.SingletonCommon;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class BreakSingletonCommonMain {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, CloneNotSupportedException {

//        throughReflection();

//        throughSerialization();

        throughCloning();

        // TODO - test all the above methods with BillPughSinglePattern

    }

    private static void throughCloning() throws CloneNotSupportedException {

        log.info("Original SingletonCommon.getInstance() : {}", SingletonCommon.getInstance().hashCode());

        Object clone = SingletonCommon.getInstance().clone();

        log.info("DeSerialized SingletonCommon.getInstance() : {}", clone.hashCode());

        if (SingletonCommon.getInstance().hashCode() != clone.hashCode()) {
            log.info("BROKEN!!!");
        }
    }

    private static void throughSerialization() throws IOException, ClassNotFoundException {

        log.info("Original SingletonCommon.getInstance() : {}", SingletonCommon.getInstance().hashCode());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/srinathr/SingletonCommon.ser"));
        objectOutputStream.writeObject(SingletonCommon.getInstance());
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/srinathr/SingletonCommon.ser"));
        SingletonCommon singletonCommon = (SingletonCommon) objectInputStream.readObject();

        log.info("DeSerialized SingletonCommon.getInstance() : {}", singletonCommon.hashCode());

        if (SingletonCommon.getInstance().hashCode() != singletonCommon.hashCode()) {
            log.info("BROKEN!!!");
        }

    }

    private static void throughReflection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        log.info("SingletonCommon.getInstance().hashCode() : " + SingletonCommon.getInstance().hashCode());

        Class<?> aClass = Class.forName("com.dpattern.creational.singleton.SingletonCommon");
        Optional<Constructor<?>> declaredConstructorOpt = Arrays.stream(aClass.getDeclaredConstructors()).findFirst();

        if(declaredConstructorOpt.isPresent()) {
            Constructor<?> constructor = declaredConstructorOpt.get();
            constructor.setAccessible(true);
            // below will fail as we have protected SingletonCommon private constructor otherwise this can break!
            Object obj = constructor.newInstance();
            log.info("Reflection object hashcode : {}", obj.hashCode());
        }
    }

}
