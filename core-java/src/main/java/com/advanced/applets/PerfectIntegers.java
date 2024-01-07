package com.advanced.applets;

/*1.	An integer is said to be a perfect if its factors, including 1 but not the number itself add up to the number. (Ex 6 = 1+2+3). Write an applet with a method in it called Perfect that determines if the parameter number is a perfect number. Use this applet that determines and displays all the perfect numbers between 1 and 1000. Print the factors of each perfect number to confirm the number is indeed perfect. Challenge the computing power of your computes by testing numbers larger than 1000. */

import java.applet.Applet;
import java.awt.*;

public class PerfectIntegers extends Applet {
	String str = null;
	int number1, number2;

	int i, sum = 0;

	public boolean Perfect() {
		str = getParameter("num");
		number1 = Integer.parseInt(str);
		number2 = number1;

		for (i = 1; i < number1; i++) {
			if (number1 % i == 0) {
				sum = sum + i;
			}
		}

		if (number2 == sum)
			return true;
		else
			return false;
	}

	public void paint(Graphics g) {
		int row;
		Font f = new Font("Times New Roman", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.red);
		row = 70;
		if ((Perfect() == true)) {
			g.drawString("Factors of  " + number2, 20, 40);
			for (int i = 1, column = 80; i < number2; i++, column = column + 20) {
				if (number2 % i == 0)
					g.drawString(i + "", row, column);
			}
		} else {
			g.drawString(number2 + " is not a Perfect Integer", 60, 100);
		}

	}
}
/*
 * <applet code="PerfectIntegers.class" width=900 height=800> <param name="num"
 * value="6"> </applet>
 */

