package com.core.comparator;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Comparator interface will not alter the class behavior. It will act like a utility method to sort items. 
 * Can create as many as comparators on a class to sort.
 *
 * java.util.Comparator is used to sort collection of different types(classes) like List<Object>.
 * It means Comparator is like "I can compare myself with other object of same/different type"
 * 
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ComparatorMain {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "abc", "6"));
        students.add(new Student(4, "abc", "1"));
        students.add(new Student(2, "bca", "2"));

        // creating a comparator from interface itself
        students.sort(STUDENT_ID_COMPARATOR);
        log.info("Students list sorted by ID : {}", students);


        Comparator<Student> byName = Comparator.comparing(Student::getStudentName);
        students.sort(byName);
        log.info("Students list sorted by name : {}", students);


        students = new ArrayList<>();
        students.add(new Student(1, "abc", "6"));
        students.add(new Student(4, "abc", "1"));
        students.add(new Student(2, "bca", "2"));

        // creating a comparator out of a class
        students.sort(new StudentIdComparatorClass());
        log.info("Students list sorted by ID comparator class : {}", students);


        // we can define comparator to a tree set to sort its elements
        Set<Student> treeSet = new TreeSet<>(new StudentIdComparatorClass());
        treeSet.add(new Student(1, "abc", "6"));
        treeSet.add(new Student(2, "bca", "2"));
        treeSet.add(new Student(4, "abc", "1"));

        log.info("treeSet sorted by ID comparator class : {}", treeSet);
    }

    private static final Comparator<Student> STUDENT_ID_COMPARATOR = (stu1, stu2) -> {
        if (stu1.getStudentId() > stu2.getStudentId()) {
            return 1;
        } else if (stu1.getStudentId() < stu2.getStudentId()) {
            return -1;
        }
        return 0;
    };

}

class StudentIdComparatorClass implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getStudentId() > o2.getStudentId()){
			return 1;
		} else if(o1.getStudentId() < o2.getStudentId()){
			return -1;
		}
		return 0;
	}

}