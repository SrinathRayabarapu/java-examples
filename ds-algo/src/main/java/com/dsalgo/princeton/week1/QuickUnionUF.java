package com.dsalgo.princeton.week1;

public class QuickUnionUF {
	
	private int[] data;
	
	public QuickUnionUF(int size) {
		data = new int[size];
		for(int i=0;i<data.length; i++){
			data[i] = i;
		}
	}
	
	public int root(int p){
		int v = 0;
		while(data[p] != p){
			v = data[p];
		}
		return v;
	}
	
	public boolean isConnected(int p, int q){		
		return data[p] == data[q];
	}
	
	public void union(int p, int q){
		int rootP = root(p);
		int rootQ = root(q);
		data[rootP] = rootQ;
	}
	
}
