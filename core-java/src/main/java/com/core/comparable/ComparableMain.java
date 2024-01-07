package com.core.comparable;

import lombok.extern.slf4j.Slf4j;

/**
 * Comparable interface test class on EmployeeEntity class empId field
 * <p>
 * java.lang.Comparable is used to sort collection of same types(classes) like
 * List<Student>, List<EmployeeEntity>, List<Orange>, It means Comparable is like
 * "I can compare myself with another object of same type".
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ComparableMain {

    public static void main(String[] args) {

        Employee employee1 = new Employee(0, null, 0);
        employee1.setEmpId(1);
        employee1.setEmpName("abc");
        employee1.setDesignation("worker");

        Employee employee2 = new Employee(0, null, 0);
        employee2.setEmpId(1);
        employee2.setEmpName("abc");
        employee2.setDesignation("worker");

        int i1 = employee1.compareTo(employee2);
        if (i1 > 0) {
            log.info("employee1 is greater than employee2");
        } else if (i1 < 0) {
            log.info("employee2 is greater than employee1");
        } else {
            log.info("employee1 and employee2 are the same");
        }
    }

}