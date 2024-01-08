package com.dpattern.creational.builder.lombokstyle;

import lombok.ToString;

/**
 * this is how lombok implemented builder pattern
 */
public class BuilderPatternMain {

    public static void main(String[] args) {
        Student student = Student.builder()
                .setStudentName("Student 1")
                .setAddress("Whitefield")
                .setQualification("MCA")
                .build();

        System.out.println("Student obj : " + student);
    }

}

@ToString
class Student {

    private String studentName;

    private String qualification;

    private String address;

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