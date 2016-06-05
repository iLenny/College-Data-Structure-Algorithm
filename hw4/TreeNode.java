package hw4;
/*
 * Author: LEIBNIZ H. BERIHUETE
 * Course: CISC 3130-W6
 * Last Modification: 05/15/2016
 * Homework #4
 */
public class TreeNode {
	TreeNode left;
	TreeNode right;
	private int number;
	
	// Constructor
	public TreeNode(int number) {
		setNumber(number);
		left = null;
		right = null;
	}
	
	// number Setter:
	public void setNumber(int number) {
		this.number = number;
	}
	
	// number Getter:
	public int getNumber() {
		return this.number;
	}
}
