package com.core.comparable;

import java.util.Objects;

/**
 * the class will have to alter it's behavior by implementing Comparable interface.
 * 
 * @author Srinath.Rayabarapu
 */
public class Employee implements Comparable<Employee>{
	
	private int empId;
	private String empName;
	private String designation;
	private int age;
	
	public Employee(int empId, String empName, int age) {
		this.empId = empId;
		this.empName = empName;
		this.age = age;
	}
	
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return this.empId;
	}
	
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return this.empName;
	}
	
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return this.designation;
	}
	
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public int compareTo(Employee o) {
		if(this.empId > o.empId){
			return 1;
		} else if(this.empId < o.empId){
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return empId == employee.empId && age == employee.age && empName.equals(employee.empName) && designation.equals(employee.designation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, designation, age);
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeEntity [empId=");
		builder.append(this.empId);
		builder.append(", empName=");
		builder.append(this.empName);
		builder.append(", designation=");
		builder.append(this.designation);
		builder.append(", age=");
		builder.append(this.age);
		builder.append("]");
		return builder.toString();
	}
	
}