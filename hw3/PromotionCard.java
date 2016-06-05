package hw3;
/*
 * Author: LEIBNIZ H. BERIHUETE
 * Course: CISC 3130-W6
 * Last Modification: 05/12/2016
 * Homework #3
 */
public class PromotionCard extends Node {
	private int discount;
	
	// Constructor
	public PromotionCard(int discount) {
		setDiscount(discount);
		super.setType('P');
	}
	
	// discount Setter:
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	// discount Getter
	public int getDiscount() {
		return this.discount;
	}
	
	// print Method:
	public void print() {
		System.out.println(super.getType()+ "\t" + discount +"%");
	}	
}
