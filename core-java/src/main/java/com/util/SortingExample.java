package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Student> studentsList = new ArrayList<Student>();

		studentsList.add(new Student(80, 25, "abc"));

		studentsList.add(new Student(70, 23, "def"));
		studentsList.add(new Student(70, 25, "jkl"));

		studentsList.add(new Student(60, 20, "ghi"));
		studentsList.add(new Student(60, 28, "mno"));

		studentsList.add(new Student(50, 20, "pqr"));

		Collections.sort(studentsList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {

				int result = ((Integer) o2.getMarks()).compareTo(o1.getMarks());

				if (result != 0) {
					return result;
				}
				return ((Integer) o2.getAge()).compareTo(o1.getAge());
			}
		});

		for (Student student : studentsList) {
			System.out.println(student.getMarks() + ":" + student.getAge()
					+ ":" + student.getName());
		}
	}
}

class Student {
	int marks;
	int age;
	String name;

	public Student(int marks, int age, String name) {
		this.marks = marks;
		this.age = age;
		this.name = name;
	}

	public int getMarks() {
		return this.marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}