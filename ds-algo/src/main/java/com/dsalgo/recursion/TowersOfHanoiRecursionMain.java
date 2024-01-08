package com.dsalgo.recursion;

/**
 * recursive approach to solve towers of hanoi problem - using towerB, move all the disks from towerA to towerC
 * 
 * Logic :
 * 1. Move n-1 disks from A to B using C
 * 2. Move a disk from A to C
 * 3. Move n-1 disks from B to C using A
 * 
 * @author Srinath.Rayabarapu
 */
public class TowersOfHanoiRecursionMain {
	
	public static void main(String[] args) {
		towersOfHanoi(3, "towerA", "towerB", "towerC");
	}

	public static void towersOfHanoi(int disksNumber, String fromTower, String tempTower, String toTower){
		if(disksNumber > 0){
			towersOfHanoi(disksNumber-1, fromTower, toTower, tempTower);
			System.out.println("move a disk from " + fromTower + " to " + toTower);
			towersOfHanoi(disksNumber-1, tempTower, fromTower, toTower);
		}
	}

}