package com.dsalgo.princeton.week1;

/**
 * eager approach to solve connected problem
 * 
 * @author srayabar
 *
 */
public class QuickFindUF {
	
	private int[] data;
	
	// intitalize the data set
	public QuickFindUF(int n) {
		data = new int[n];
		//make them self connected
		for(int i=0;i<data.length; i++){
			data[i] = i;
		}
	}
	
	public boolean isConnected(int a, int b){
		return data[a] == data[b];
	}
	
	public int find(int n){		
		return data[n];
	}
	
	/*
	 * if an element has a id, then replace that element id with b id 
	 */
	public void union(int a, int b){
		for(int i=0;i<data.length; i++){
			if(data[i] == data[a]){
				data[i] = data[b];
			}
		}
	}
	
	// driver program
	public static void main(String[] args) {
		
		QuickFindUF findUF = new QuickFindUF(10);
		findUF.union(4,  9);
		System.out.println(findUF.isConnected(4, 9));
		
	}

}