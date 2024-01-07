package com.core.comparator;

/**
 * simple POJO class
 * 
 * @author Srinath.Rayabarapu
 */
public class Student {
	
	private int studentId;
	private String studentName;
    private String studentClass;

    Student(int stuId, String stuName, String stuClass) {
		this.studentId = stuId;
		this.studentName = stuName;
        this.studentClass = stuClass;
	}
	
	/**
	 * @return the studentId
	 */
    int getStudentId() {
		return this.studentId;
	}

	@Override
	public String toString() {
        return "Student [studentId=" + this.studentId
				+ ", studentName=" + this.studentName
				+ ", studentClass=" + this.studentClass
				+ "]";
	}

	public String getStudentName() {
		return studentName;
	}
}