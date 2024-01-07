package com.core.solid;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Software components should be Open for Extension and Closed for Modification
 *
 * Open for extension - Child class should be able to extend the Super class functionality
 * Clased for modification - Don't modify Parent class to add new functionality rather extend it and modify in Child
 *
 * https://www.youtube.com/watch?v=oRA-xnqlB10
 */
@Slf4j
public class OpenClosedMain {

    public static void main(String[] args) {
        Student student = new Student(01, "Srinath");
        log.info("Student : " + student);

        StudentWithMoreDetails studentMore = new StudentWithMoreDetails(01, "Srinath", "Pasra",
                "Bhaskar Rao", "Sarojana");
        log.info("StudentWithMoreDetails : " + studentMore);

    }

}

@ToString
@Slf4j
class Student {
    int id;
    String name;

    // bad idea to modify the base class - either we need to modify or create a new constructor to set these values
//    String place;
//    String fatherName;
//    String motherName;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printMe(){
        log.info("Student id : " + id + ", name : " + name);
    }

}

@ToString
class StudentWithMoreDetails extends Student {

    String place;
    String fatherName;
    String motherName;

    // instead extend and call the super with required data
    public StudentWithMoreDetails(int id, String name, String place, String fatherName, String motherName) {
        super(id, name);
        this.place = place;
        this.fatherName = fatherName;
        this.motherName = motherName;
    }
}