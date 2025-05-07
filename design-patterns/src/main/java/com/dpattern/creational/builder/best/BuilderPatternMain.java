package com.dpattern.creational.builder.best;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Builder pattern is used to create complex objects. It is a creational design pattern.
 * Builder pattern is a design pattern that allows you to create complex objects step by step. It is a creational design pattern.
 * <p>
 * Practical examples: Creating Immutable objects, StringBuilder, StringBuffer, StringJoiner, StringTokenizer
 *
 */
@Slf4j
public class BuilderPatternMain {

    public static void main(String[] args) {
        Student student = Student.builder()
                .setStudentName("Student 1")
                .setAddress("Whitefield")
                .setQualification("MCA")
                .build();

        log.info("Student obj : {}", student);
    }

}

@ToString
class Student {

    private final String studentName;
    private final String qualification;
    private final String address;

    private Student(StudentBuilder builder) {
        this.studentName = builder.studentName;
        this.qualification = builder.qualification;
        this.address = builder.address;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    public static class StudentBuilder {

        private String studentName;
        private String qualification;
        private String address;

        public StudentBuilder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public StudentBuilder setQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

}