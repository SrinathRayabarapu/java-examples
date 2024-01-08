package com.hibernate.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COURSES")
public class Course {

    private long courseId;
    private String courseName;
    private Date courseStartDate;
    private Date courseEndDate;

    public Course() {
    }

    public Course(String courseName, Date startDate, Date endDate) {
        this.courseName = courseName;
        this.courseStartDate = startDate;
        this.courseEndDate = endDate;
    }

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    public long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Column(name = "COURSE_NAME", nullable = false)
    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

}
