package com.dpattern.creational.builder.good;

public class StudentBuilderBestMain {

    public static void main(String[] args) {
        Student student = Student
                .builder()
                .setAge(10)
                .setName("srinath")
                .build();
        System.out.println(student);
    }

}

class Student {

    private String name;
    private int age;

    public Student(StudentBuilder studentBuilder) {
        this.age = studentBuilder.getAge();
        this.name = studentBuilder.getName();
    }

    static StudentBuilder builder(){
        return new StudentBuilder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentBuilder {

    private String name;
    private int age;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Student build(){
        return new Student(this);
    }
}