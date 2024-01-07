package com.core.comparator;

import com.core.io.Employee;

import java.util.Comparator;

/**
 * it is a utility class to compare dao objects based on different properties
 *
 * @author srinath.rayabarapu
 */
public class MyComparator implements Comparator<Employee> {

	String comp = "age";

	public MyComparator(String param) {
		comp = param;
	}

	public MyComparator() {
	}

	public int compare(Employee e1, Employee e2) {

		if (comp.equals("age")) {
			if (e1.age > e2.age)
				return 1;
			else if (e1.age < e2.age)
				return -1;
			else
				return 0;

		} else if (comp.equals("reverseAge")) {

			if (e1.age > e2.age)
				return -1;
			else if (e1.age < e2.age)
				return 1;
			else
				return 0;

		} else if (comp.equals("name")) {
			return e1.name.compareTo(e2.name);

		} else if (comp.equals("reverseName")) {
			return e2.name.compareTo(e1.name);

		} else if (comp.equals("designation")) {
			return e1.designation.compareTo(e2.designation);

		} else if (comp.equals("reverseDesignation")) {
			return e2.designation.compareTo(e1.designation);
		} else
			return 0;
	}
}
