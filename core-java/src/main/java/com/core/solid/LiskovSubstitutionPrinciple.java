package com.core.solid;

import lombok.extern.slf4j.Slf4j;

/**
 * You should design your classes so that client dependencies can be substituted with subclasses without the
 * client knowing about the change
 *
 * LSP means that the classes, fellow developers created by extending our class, should be able to fit in application
 * without failure. This is important when we resort to polymorphic behaviour through inheritance.
 *
 * This requires the objects of the subclasses to behave in the same way as the objects of the superclass. This is mostly
 * seen in places where we do runtime type identification and then cast it to appropriate reference type.
 *
 * This avoids misusing inheritance
 * It helps to conform to the "is-a" relationship
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {
        Student student = new Student(01, "Srinath");
        log.info("Student : " + student);

        StudentWithMoreDetails studentMore = new StudentWithMoreDetails(01, "Srinath", "Pasra",
                "Bhaskar Rao", "Sarojana");
        log.info("StudentWithMoreDetails : " + studentMore);

        callPrintMe(student);

        callPrintMe(studentMore);
    }

    private static void callPrintMe(Student student) {
        student.printMe();
    }

}
