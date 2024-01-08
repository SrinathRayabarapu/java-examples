package com.puzzles.fibonacci;

/**
 * In fibonacci series find nth number using recursion with a thread
 * #Actiance
 * 
 * ex : 1 1 2 3 5 8 13 21.........n
 * 
 * @author srinath.rayabarapu 
 */
public class FibonacciSeriesThreadSearchMain {

	/*//default fibonacci series -
	public static int fibinocciNumberWithIteration(int index) {
		if(index == 1 ){
			return 0;
		}
		if(index == 2 ){
			return 1;
		}
		return (fibinocciNumberWithIteration(index-1)+fibinocciNumberWithIteration(index-2));
	}
	*/
	
	public static void main(String[] args) {
		int n = 3;
		FibonacciSeriesRecursion seriesRecursion = new FibonacciSeriesRecursion(n);
		Thread thread = new Thread(seriesRecursion);
		thread.start();
		
		try {
			thread.join(); // waits till the thread completes execution
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( n + " element in the Fibinocci series : " + seriesRecursion.getNumber());
	}
}

class FibonacciSeriesRecursion implements Runnable{
	int number;
	String name;
	
	public FibonacciSeriesRecursion(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		setNumber(calculateFibinocci(this.number));
	}
	
	public int calculateFibinocci(int num){
		if(num == 1 || num == 2){
			return 1;
		}
		return (calculateFibinocci(num-1) + calculateFibinocci(num-2));
	}
	
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}