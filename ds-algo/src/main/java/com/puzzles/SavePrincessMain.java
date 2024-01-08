package com.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * TODO: understand and solve it
 *
 * https://github.com/mkhattab/hackerrank-solutions/blob/master/track-1/bot-saves-princess.org
 *
 * @author Srinath.Rayabarapu
 */
public class SavePrincessMain {

	private String[][] field = null;
	private int[] myLocation = null;
	private int[] princessLocation = null;

	public void setFieldSize(int size) {
		this.field = new String[size][size];
		System.out.println("Field initialized with capacity " + size);
	}

	@SuppressWarnings("null")
	public void feedData(String filePath) {
		Scanner scanner = null;
		// "C:\\Work\\Bot_saves_princess.txt"
		try {
			scanner = new Scanner(new File(filePath));
			int fieldSize = Integer.parseInt(scanner.nextLine());
			setFieldSize(fieldSize);

			int count = 0;
			while (scanner.hasNext()) {
				String nextLine = scanner.nextLine();
				String[] split = nextLine.trim().split("");

				for (int i = 1; i < split.length; i++) {
					this.field[count][i - 1] = split[i];
					// System.out.println(i+":"+split[i]);
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public void findPrincess() {
		System.out.println("Found my location " + this.myLocation[0] + ","
				+ this.myLocation[1]);
		System.out.println("Found princess location "
				+ this.princessLocation[0] + "," + this.princessLocation[1]);
		getDirections();
	}

	private void getDirections() {
		int myX = this.myLocation[0];
		int myY = this.myLocation[1];
		int princessX = this.princessLocation[0];
		int princessY = this.princessLocation[1];

		if (!(myX == princessX && myY == princessY)) {
			if (myX < princessX) {
				System.out.println("Down");
				if (myX + 1 < this.field.length)
					this.myLocation[0] = myX + 1;
				// System.out.println("I'm at "+myLocation[0]+","+myLocation[1]);
			}
			if (myX > princessX) {
				System.out.println("Up");
				if (myX - 1 >= 0)
					this.myLocation[0] = myX - 1;
				// System.out.println("I'm at "+myLocation[0]+","+myLocation[1]);
			}
			if (myY < princessY) {
				System.out.println("Right");
				if (myY + 1 < this.field[0].length)
					this.myLocation[1] = myY + 1;
				// System.out.println("I'm at "+myLocation[0]+","+myLocation[1]);
			}
			if (myY > princessY) {
				System.out.println("Left");
				if (myY - 1 >= 0)
					this.myLocation[1] = myY - 1;
				// System.out.println("I'm at "+myLocation[0]+","+myLocation[1]);
			}
			getDirections();
		}
	}

	public void printField() {
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[i].length; j++) {
				System.out.print(this.field[i][j]);

				if (this.field[i][j].equalsIgnoreCase("m")) {
					this.myLocation = new int[2];
					this.myLocation[0] = i;
					this.myLocation[1] = j;
				}
				if (this.field[i][j].equalsIgnoreCase("p")) {
					this.princessLocation = new int[2];
					this.princessLocation[0] = i;
					this.princessLocation[1] = j;
				}
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SavePrincessMain program = new SavePrincessMain();
		program.feedData("C:\\Work\\Bot_saves_princess.txt");
		program.printField();
		program.findPrincess();
	}

}