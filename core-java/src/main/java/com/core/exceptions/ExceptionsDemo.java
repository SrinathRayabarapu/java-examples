package com.core.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates common exception handling patterns in Java.
 * 
 * <p>This class covers various exception scenarios including:</p>
 * <ul>
 *   <li>IndexOutOfBoundsException - accessing invalid list/array indices</li>
 *   <li>NullPointerException - dereferencing null references</li>
 *   <li>ArithmeticException - division by zero</li>
 *   <li>NumberFormatException - invalid number parsing</li>
 * </ul>
 * 
 * <h3>Exception Handling Best Practices:</h3>
 * <ul>
 *   <li>Catch specific exceptions rather than generic Exception</li>
 *   <li>Use finally block for cleanup operations</li>
 *   <li>Provide meaningful error messages</li>
 *   <li>Consider re-throwing with additional context</li>
 *   <li>Never catch Throwable in production code (includes Errors)</li>
 * </ul>
 * 
 * <h3>Exception Hierarchy:</h3>
 * <pre>
 * Throwable
 * ├── Error (should not be caught)
 * └── Exception
 *     ├── RuntimeException (unchecked)
 *     │   ├── NullPointerException
 *     │   ├── IndexOutOfBoundsException
 *     │   └── ArithmeticException
 *     └── IOException, SQLException, etc. (checked)
 * </pre>
 *
 * @author Srinath.Rayabarapu
 */
public class ExceptionsDemo {

	/**
	 * Main method demonstrating various exception handling scenarios.
	 *
	 * @param args command-line arguments - first argument used for division
	 */
	public static void main(String[] args) {
		indexOutOfBound();
		nullPointer();

        try {
            int i = 1 / Integer.parseInt(args[0]);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(ae);
        } catch (NumberFormatException ne) {
            System.out.println(ne);
        } finally {
            System.out.println("finally.....");
        }
        System.out.println("after exception....");

	}

	/**
	 * Demonstrates handling NullPointerException.
	 * 
	 * <p>NullPointerException occurs when trying to use a null reference
	 * where an object is required (e.g., calling methods on null).</p>
	 *
	 * @throws NullPointerException declared but caught internally
	 */
	private static void nullPointer() throws NullPointerException {
		Student student = new Student();
		Integer id = null;
		try {
			//System.out.println("name:" + id.intValue());
			System.out.println("std name:" + student.getName().toUpperCase());
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("id  is  null ");// customized error messages??			
		}

	}

	/**
	 * Demonstrates handling IndexOutOfBoundsException.
	 * 
	 * <p>IndexOutOfBoundsException occurs when accessing an array or list
	 * with an index that is negative or >= size. This method also shows
	 * exception chaining by catching one exception and throwing another.</p>
	 *
	 * @throws IndexOutOfBoundsException wrapped as ArrayIndexOutOfBoundsException
	 */
	private static void indexOutOfBound() throws IndexOutOfBoundsException {
		List<String> names = new ArrayList<String>();
		try {
			names.add("Shubha");
			names.add("Anu");
			names.add("Priya");
			System.out.println("name @  index :" + names.get(3));

		} catch (Throwable e) {
			System.out.println("e" + e);
			throw new ArrayIndexOutOfBoundsException("hey dude");
		} finally {
			System.out.println("in  finally");
		}
	}
}
