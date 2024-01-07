Approach:
------------------------------------------------------------------------------------------------
1. Read all talks from File
2. Validate each task and add them to list
	a. Each task must have name and time 
	b. If it's ending with "min" then extract minutes from task
	c. If it's ending with "lightning" then extract minutes(no. of lightnings * 5) from task.
	d. add all valid talks to a list and return
3. Sort all talks based on it's duration descending order
4. Find number of days in which all the tasks can be accommodated
5. Find sessions that can fit for each day Morning and Evenings within the time limit
6. If any tasks left after fitting in both Morning and Evening sessions then will print an error
7. Added in line comments in the code wherever required

Execution:
------------------------------------------------------------------------------------------------
1. All java files are in com.thoughtworks package
2. Main.java has the main method to run the application
3. input.txt will be used to to read input data