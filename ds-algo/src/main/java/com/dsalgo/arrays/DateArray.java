package com.dsalgo.arrays;

/* 15.	Set up an array of 10 String variables each containing an arbitrary string of the form month/day/year, for example 10/29/99. Analyze each element in the array and output date represented in the form 29th October 1999. */

/* authors: SDN Hayath Ali & R.Preetha, Marlabs Software (P) Ltd.,Mysore   Date:08-03-2007
 ---------------------------------------------------------------------------------------------- */

/* The Dates class contains the variable declaration and a method showDates(),that contains the functionality to achieve the above said task */

class Dates {
	// month array contains the names of 12 months

	String[] month = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };

	// date array contains 10 sample dates in the format mm/dd/yy

	String[] date = { "01/10/96", "12/23/98", "10/29/00", "03/04/97",
			"01/01/80", "11/11/92", "06/24/95", "04/15/00", "07/22/06",
			"01/31/05" };

	// suffix string variable is used to store the suffix of the date like: st
	// (or) nd (or) rd (or) th
	String suffix = "";

	/*
	 * string variable s_year stores the year(integer format) into the string
	 * format. It is needed to display the year 01 thru 09 to be displayed as
	 * 2004,2005 etc.. else it'll take the year 04 as 4, 05 as 5 and prints
	 * 204,205... instead of 2004,2005
	 */
	String s_year;

	// variable i is used for iterations in a loop
	/*
	 * variable mm stores month(as integer) taken as a substring from the date
	 * array, dd stores the day and yy stores the year
	 */
	int i, mm, dd, yy;

	void showDates() // method to define the functionality
	{ // begin of method showDates

		/*
		 * the for loop iterates from the first element(date) of the date array
		 * till the last element. it takes element by element and splits the
		 * date into three parts, month,day and year. they are taken as strings
		 * and then they are converted into integers with the help of wrapper
		 * class method parseInt()
		 */

		for (i = 0; i < date.length; i++) {

			// substring() method is used to fetch a part of a string data
			// specified with index value as parameters

			// substring(0,2) fetches the first two digits[mm] and converts them
			// into integer
			mm = Integer.parseInt(date[i].substring(0, 2));

			// substring(3,5) fetches the next two digits[dd] after the '/' and
			// converts them into integer
			dd = Integer.parseInt(date[i].substring(3, 5));

			s_year = date[i].substring(6, 8);

			// substring(6,8) fetches the last two digits[yy] and converts them
			// into integer
			yy = Integer.parseInt(s_year);

			/*
			 * this if statement checks the days for suffixing 'st' or 'nd' or
			 * 'rd' or 'th' for the day dd
			 */

			if (dd == 1 || dd == 21 || dd == 31)
				suffix = "st"; // begin of if statement1

			else if (dd == 2 || dd == 22)
				suffix = "nd";

			else if (dd == 3 || dd == 23)
				suffix = "rd";

			else
				suffix = "th"; // end of if statement

			/*
			 * below if statements check for the year if it's between 00 to 06
			 * [both inclusive] it is taken upto 06 because if the user enters
			 * the year as 08 then it should take it as 1908 instead of 2008 as
			 * 2008 is yet to come
			 */

			if (yy >= 0 && yy < 7) // begin of if statement2
				System.out.println(dd + suffix + " " + month[mm - 1] + " 20"
						+ s_year);
			else
				System.out.println(dd + suffix + " " + month[mm - 1] + " 19"
						+ s_year);
			// end of if statement2

		}
	}
}

class DateArray // class DateArray has the main method that creates an object of
// Dates class
{
	public static void main(String[] args) {
		Dates dt = new Dates(); // creating an object of Dates class
		dt.showDates(); // accessing the showDates() method using the object of
						// Dates class
	}
}
