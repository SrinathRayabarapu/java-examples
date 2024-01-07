package com.core.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee emp = (Employee) ois.readObject();
		System.out.println(emp);
	}
}
