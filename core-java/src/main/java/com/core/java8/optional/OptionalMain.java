package com.core.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * using Optional class
 *
 * @author Srinath.Rayabarapu
 */
public class OptionalMain {
	
	public static void main(String[] args) {

		Long aLong = Long.valueOf("15");
		System.out.println(aLong);


		Optional<List<student>> studentsListOptional = fetchStudentsList();

		List<student> studentList = new ArrayList<>();
		studentList.add(new student());

		//mandatory check
		if(studentsListOptional.isPresent()){
			List<student> list = studentsListOptional.orElse(studentList);
			System.out.println("students size : " + list.size());
		}
	}

	private static Optional<List<student>> fetchStudentsList() {
		
		//from db
		List<student> studsList = null;//new ArrayList<dto>();
		//studsList.add(null);
		return Optional.ofNullable(studsList);
	}

}

class student{
	
}