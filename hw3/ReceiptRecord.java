package hw3;
/*
 * Author: LEIBNIZ H. BERIHUETE
 * Course: CISC 3130-W6
 * Last Modification: 05/12/2016
 * 
 * Homework #3
 */
public class ReceiptRecord extends Node{
	private double price;
	private int quantity;
	
	// Constructor:
	public ReceiptRecord(int quantity, double price) {
		setPrice(price);
		setQuantity(quantity);
		super.setType('R');
	}
	
	// price Setter:
	public void setPrice(double price) {
		this.price = price;
	}
	
	// quantity Setter:
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// price Getter:
	public double getPrice() {
		return this.price;
	}
	
	// quantity Getter:
	public int getQuantity() {
		return this.quantity;
	}
	
	// print record
	public void print() {
		System.out.println(super.getType()+ "\t" + quantity +
				"\t" + price);
	}	
}
