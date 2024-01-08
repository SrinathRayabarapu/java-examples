package com.dsalgo.linkedlist;


import com.dsalgo.dtos.Employee;

/**
 * node class for both single and double linked lists
 * 
 * @author srayabar
 *
 */
public class EmployeeNode {
	
	private Employee employee;
	private EmployeeNode next;
	private EmployeeNode previous;

	public EmployeeNode(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the dao
	 */
	public Employee getEmployee() {
		return this.employee;
	}

	/**
	 * @param employee the dao to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the next
	 */
	public EmployeeNode getNext() {
		return this.next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(EmployeeNode next) {
		this.next = next;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return this.employee.toString();
	}

	/**
	 * @return the previous
	 */
	public EmployeeNode getPrevious() {
		return this.previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(EmployeeNode previous) {
		this.previous = previous;
	}
	
}
