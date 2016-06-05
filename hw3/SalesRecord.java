package hw3;
/*
 * Author: LEIBNIZ H. BERIHUETE
 * Course: CISC 3130-W6
 * Last Modification: 05/12/2016
 * Homework #3
 */
public class SalesRecord extends Node {
	private int quantitySold;
	
	// Constructor
	public SalesRecord(int quantitySold) {
		setQuantitySold(quantitySold);
		super.setType('S');
	}
	
	// quantitySold Setter:
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	// quantitySold Getter:
	public int getQuantitySold() {
		return this.quantitySold;
	}
	
	// print Method:
	public void print() {
		System.out.println(super.getType()+ "\t" + quantitySold);
	}
}
