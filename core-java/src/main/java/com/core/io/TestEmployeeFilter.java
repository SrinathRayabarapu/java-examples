package com.core.io;

import com.core.comparator.MyComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestEmployeeFilter {

	public static void main(String[] args) {
		employeeFilter();
	}

	/**
	 * Filter a list employees based on their name,designation and age
	 */
	public static void employeeFilter() {

		System.out.println("Please select ..");

		System.out
				.println("1. Number of Employees \n2. Based on given Criteria filter"
						+ "\n3. Print all Age-Name-Designation data Asc/Desc wise \n4. Exit");

		Map<String, Integer> map;
		List<Employee> employeesList = createEmployees();
		int mainInput = 0;
		Scanner scanner = new Scanner(System.in);

		try {
			mainInput = scanner.nextInt();
		} catch (InputMismatchException e) {
		}

		switch (mainInput) {
		case 1:
			System.out.println("Please select ..");
			System.out.println("1. Designation wise \n2. Age wise");

			int subInput1 = 0;

			try {
				subInput1 = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid selection");
			}

			if (subInput1 == 1) {
				map = getDesignationEmployees(employeesList);
				printEmployeeDetails(map);

			} else if (subInput1 == 2) {
				System.out.println("Please enter start and end age values");
				int startAge = 0;
				int endAge = 0;

				try {
					startAge = scanner.nextInt();
					endAge = scanner.nextInt();
					map = getAgeEmployees(employeesList, startAge, endAge);
					printEmployeeDetails(map);

				} catch (Exception e) {
					System.out.println("Invalid selection");
				}
			}

			break;

		case 2:
			System.out.println("Please select ..");
			System.out
					.println("1. Age filter \n2. Name filter \n3. Designation filter");

			int subInput2 = 0;

			try {
				subInput2 = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid selection");
			}

			List<Employee> tempEemployeesList;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));

			switch (subInput2) {
			case 1:
				System.out
						.println("Please enter EmployeeEntity Age and filters like ..");
				System.out.println("1. > \n2. < \n3. <= \n4. >=");

				int age = 0;
				int condition1 = 0;

				try {
					age = scanner.nextInt();
					condition1 = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid selection");
				}

				tempEemployeesList = filterEmployeesAgeOnCondition(age,
						condition1, employeesList);

				Collections.sort(tempEemployeesList, new MyComparator());

				printEmployeeList(tempEemployeesList);

				break;

			case 2:
				System.out
						.println("Please enter EmployeeEntity Name(Pattern) and filters like ..");
				System.out
						.println("1. Whole String \n2. Starts with \n3. Ends with \n4. Contains char set");
				int patternCondition = scanner.nextInt();
				try {
					String pattern = reader.readLine();
					System.out.println("1. Asc \n2. Desc ");

					int condition = 0;

					try {
						condition = scanner.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Invalid selection");
					}

					tempEemployeesList = getPatternedEmployeeNames(
							patternCondition, pattern, condition, employeesList);

					printEmployeeList(tempEemployeesList);

				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}

				break;

			case 3:
				System.out
						.println("Please enter EmployeeEntity Designation and filters like ..");
				System.out.println("1. < \n2. > ");

				try {

					String designation = reader.readLine();
					int condition = 0;

					try {
						condition = scanner.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Invalid selection");
					}
					tempEemployeesList = filterEmployeesDesigOnCondition(
							designation, condition, employeesList);

					printEmployeeList(tempEemployeesList);

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}

				break;

			default:
				System.out.println("Invalid selection");
				break;
			}

			break;

		case 3:

			System.out
					.println("Please select an option for \n1.Age \n2.Name \n3.Designation for printing data ..");

			int option1 = 0;
			int option2 = 0;

			try {
				option1 = scanner.nextInt();
				System.out.println("1. Asc \n2. Desc ");
				option2 = scanner.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("Invalid selection");
			}

			printEmployeeList(employeesList, option1, option2);

			break;

		case 4:
			System.out.println("Exiting application..done!");
			break;

		default:
			System.out.println("Invalid selection");
			break;
		}
	}

	/**
	 * returns employees based on a given pattern
	 * 
	 * @param patternCondition
	 * @param pattern
	 * @param condition
	 * @param employeesList
	 * @return List<EmployeeEntity>
	 */
	private static List<Employee> getPatternedEmployeeNames(
			int patternCondition, String pattern, int condition,
			List<Employee> employeesList) {

		List<Employee> nameList = new ArrayList<Employee>();

		switch (patternCondition) {
		case 1:

			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (employee.name.equals(pattern.trim())) {
					nameList.add(employee);
				}
			}

			if (condition == 1) {
				Collections.sort(nameList, new MyComparator("name"));
			} else if (condition == 2) {
				Collections.sort(nameList, new MyComparator("reverseName"));
			}

			break;
		case 2:

			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (employee.name.startsWith(pattern.trim())) {
					nameList.add(employee);
				}
			}
			if (condition == 1) {
				Collections.sort(nameList, new MyComparator("name"));
			} else if (condition == 2) {
				Collections.sort(nameList, new MyComparator("reverseName"));
			}
			break;
		case 3:

			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (employee.name.endsWith(pattern.trim())) {
					nameList.add(employee);
				}
			}
			if (condition == 1) {
				Collections.sort(nameList, new MyComparator("name"));
			} else if (condition == 2) {
				Collections.sort(nameList, new MyComparator("reverseName"));
			}
			break;
		case 4:

			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (employee.name.contains(pattern.trim())) {
					nameList.add(employee);
				}
			}
			if (condition == 1) {
				Collections.sort(nameList, new MyComparator("name"));
			} else if (condition == 2) {
				Collections.sort(nameList, new MyComparator("reverseName"));
			}
			break;
		default:
			System.out.println("Invalid selection");
			break;
		}
		return nameList;
	}

	/**
	 * returns a list contains employees which are filtered by their designation
	 * 
	 * @param designation
	 * @param condition
	 * @param employeesList
	 * @return List<EmployeeEntity>
	 */
	private static List<Employee> filterEmployeesDesigOnCondition(
			String designation, int condition, List<Employee> employeesList) {

		List<String> employeeLevelList = getEmployeeDesigLevel();
		List<Employee> modifiedEmployeesList = new ArrayList<>();
		int index = 0;

		switch (condition) {
		case 1:

			index = employeeLevelList.indexOf(designation);

			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				for (int i = index; i < employeeLevelList.size(); i++) {
					if (employee.designation.equals(employeeLevelList.get(i))) {

						modifiedEmployeesList.add(employee);
					}
				}
			}
			break;

		case 2:

			index = employeeLevelList.indexOf(designation);

			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				for (int i = 0; i <= index; i++) {
					if (employee.designation.equals(employeeLevelList.get(i))) {

						modifiedEmployeesList.add(employee);
					}
				}
			}

			break;
		default:
			break;
		}

		return modifiedEmployeesList;
	}

	/**
	 * returns a dao list with designation values
	 * 
	 * @return List<String>
	 */
	private static List<String> getEmployeeDesigLevel() {

		int pm = 4;
		int tl = 3;
		int sse = 2;
		int se = 1;
		int trainee = 0;

		List<String> employeeList = new ArrayList<String>();

		employeeList.add(trainee, "trainee");
		employeeList.add(se, "se");
		employeeList.add(sse, "sse");
		employeeList.add(tl, "tl");
		employeeList.add(pm, "pm");

		return employeeList;
	}

	/**
	 * returns a employees list which is filtered by Age conditions
	 * 
	 * @param age
	 * @param condition
	 * @param employeesList
	 * @return List<EmployeeEntity>
	 */
	private static List<Employee> filterEmployeesAgeOnCondition(int age,
			int condition, List<Employee> employeesList) {

		List<Employee> modifiedEmployeesList = new ArrayList<Employee>();

		switch (condition) {
		case 1:
			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (age > employee.age) {
					modifiedEmployeesList.add(employee);
				}
			}
			break;

		case 2:
			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (age < employee.age) {
					modifiedEmployeesList.add(employee);
				}
			}
			break;

		case 3:
			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				if (age <= employee.age) {
					modifiedEmployeesList.add(employee);
				}
			}
			break;

		case 4:
			if (condition == 4) {
				for (Iterator<Employee> iterator = employeesList.iterator(); iterator
						.hasNext();) {
					Employee employee = (Employee) iterator.next();

					if (age >= employee.age) {
						modifiedEmployeesList.add(employee);
					}
				}
			}
			break;
		default:
			break;
		}
		return modifiedEmployeesList;
	}

	/**
	 * returns a employees map with their count of each designation
	 * 
	 * @param employeesList
	 * @return Map<String, Integer>
	 */
	private static Map<String, Integer> getDesignationEmployees(
			List<Employee> employeesList) {

		String pm = "pm";
		String tl = "tl";
		String sse = "sse";
		String se = "se";
		String trainee = "trainee";

		int pmEmployees = 0;
		int tlEmployees = 0;
		int sseEmployees = 0;
		int seEmployees = 0;
		int traineeEmployees = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Iterator<Employee> iterator = employeesList.iterator(); iterator
				.hasNext();) {
			Employee employee = (Employee) iterator.next();

			if (pm.equalsIgnoreCase(employee.designation)) {
				pmEmployees++;
			}

			if (tl.equalsIgnoreCase(employee.designation)) {
				tlEmployees++;
			}

			if (sse.equalsIgnoreCase(employee.designation)) {
				sseEmployees++;
			}

			if (se.equalsIgnoreCase(employee.designation)) {
				seEmployees++;
			}

			if (trainee.equalsIgnoreCase(employee.designation)) {
				traineeEmployees++;
			}
		}

		map.put(pm, pmEmployees);
		map.put(tl, tlEmployees);
		map.put(sse, sseEmployees);
		map.put(se, seEmployees);
		map.put(trainee, traineeEmployees);

		return map;
	}

	/**
	 * returns employees list which is filtered by start age and end age of
	 * employees
	 * 
	 * @param employeesList
	 * @param startAge
	 * @param endAge
	 * @return Map<String, Integer>
	 */
	private static Map<String, Integer> getAgeEmployees(
			List<Employee> employeesList, int startAge, int endAge) {
		int range = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Iterator<Employee> iterator = employeesList.iterator(); iterator
				.hasNext();) {
			Employee employee = (Employee) iterator.next();

			if ((startAge <= employee.age) && (employee.age <= endAge)) {
				range++;
			}
		}

		map.put(startAge + "-" + endAge, range);

		return map;
	}

	/**
	 * Prints employees when a map passed as a parameter
	 * 
	 * @param map
	 */
	private static void printEmployeeDetails(Map<String, Integer> map) {

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = map.get(key).toString();

			System.out.println(key + " : " + value);
		}
	}

	/**
	 * Prints employees when a list passed as a parameter
	 * 
	 * @param employeesList
	 */
	private static void printEmployeeList(List<Employee> employeesList) {

		if (!employeesList.isEmpty()) {
			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println(employee);
			}
		} else
			System.out.println("No data matching");
	}

	/**
	 * Prints employees when a list passed as a parameter and with some
	 * conditions
	 * 
	 * @param employeesList
	 * @param mainCond
	 * @param subCond
	 */
	private static void printEmployeeList(List<Employee> employeesList,
			int mainCond, int subCond) {

		switch (mainCond) {
		case 1:
			if (subCond == 1)
				Collections.sort(employeesList, new MyComparator("age"));
			else if (subCond == 2)
				Collections.sort(employeesList, new MyComparator("reverseAge"));
			printConditionWiseEmployees(employeesList);
			break;

		case 2:
			if (subCond == 1)
				Collections.sort(employeesList, new MyComparator("name"));
			else if (subCond == 2)
				Collections
						.sort(employeesList, new MyComparator("reverseName"));
			printConditionWiseEmployees(employeesList);
			break;

		case 3:
			if (subCond == 1)
				Collections
						.sort(employeesList, new MyComparator("designation"));
			else if (subCond == 2)
				Collections.sort(employeesList, new MyComparator(
						"reverseDesignation"));
			printConditionWiseEmployees(employeesList);
			break;

		default:
			break;
		}
	}

	/**
	 * Prints employees when a list passed as a parameter as condition wise
	 * 
	 * @param employeesList
	 */
	private static void printConditionWiseEmployees(List<Employee> employeesList) {

		System.out
				.println("----------------------------------------------------");
		System.out.println("Sno\t\t\tName\t\t\tAge");
		System.out
				.println("----------------------------------------------------");

		if (!employeesList.isEmpty()) {
			for (Iterator<Employee> iterator = employeesList.iterator(); iterator
					.hasNext();) {
				Employee employee = (Employee) iterator.next();

				System.out
						.println(employee.name.trim() + "\t\t\t"
								+ employee.designation.trim() + "\t\t\t"
								+ employee.age);
			}
		} else
			System.out.println("No data matching");
	}

	/**
	 * returns a dao list with randomly created names, age and designations
	 * 
	 * @return List<EmployeeEntity>
	 */
	private static List<Employee> createEmployees() {

		List<Employee> employeesList = new ArrayList<Employee>();

		Random randomGenerator = new Random();
		for (int idx = 1; idx <= 10; ++idx) {
			int randomAge = randomGenerator.nextInt(60);
			int randomIndex = 0;

			do {
				randomIndex = randomGenerator.nextInt(getEmployeeDesigLevel()
						.size());
				System.out.println("randomIndex " + randomIndex);
			} while (randomIndex > 21);

			Employee employee = new Employee(getString(10),
					getEmployeeDesigLevel().get(randomIndex), randomAge);
			employeesList.add(employee);
		}

		return employeesList;
	}

	/**
	 * returns randomly created string
	 * 
	 * @param len
	 * @return String
	 */
	public static String getString(int len) {

		final char[] alphanumeric = alphanumeric();
		StringBuffer out = new StringBuffer();
		Random rand = new Random();

		while (out.length() < len) {
			int idx = Math.abs((rand.nextInt() % alphanumeric.length));
			out.append(alphanumeric[idx]);
		}
		return out.toString();
	}

	/**
	 * returns a char set
	 * 
	 * @return
	 */
	private static char[] alphanumeric() {
		StringBuffer buf = new StringBuffer(128);
		for (int i = 65; i <= 90; i++)
			buf.append((char) i); // A-Z
		for (int i = 97; i <= 122; i++)
			buf.append((char) i); // a-z
		return buf.toString().toCharArray();
	}

}

