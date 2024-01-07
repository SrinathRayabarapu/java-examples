package com.core.solid;

import lombok.extern.slf4j.Slf4j;

/**
 * One class should have one and only one responsibility
 * Ex: POJOs follow SRP
 *
 * Use layers in your application and break GOD classes into smaller classes or modules
 *
 * https://www.youtube.com/watch?v=oRA-xnqlB10
 * @author Srinath Rayabarapu
 */
@Slf4j
public class SingleResponsibilityMain {
    public static void main(String[] args) {

    }
}

class Employee {
    int id;
    String name;

    // is a bad design - violates SRP
//    int departmentId;
//    String departmentName;

    // instead do this
    Department department;

}

class Department{
    int departmentId;
    String departmentName;

}


