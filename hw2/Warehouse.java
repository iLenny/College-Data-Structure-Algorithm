package hw2;


/*
 * Author: Leibniz H. Berihuete
 * Course: CISC 3130-W6 DataStructure
 * Last Modification: 5/9/2016 4:31 PM
 * 
 * Homework#2
 */

/* This is the Warehouse class (not the main class).
 * It contains the following information:
 * - the NAME of the city that this warehouse belongs to
 * - the STATUS of this warehouse, whether there is something being order or ship.
 * - the ITEMS AMOUNT, pretty much the array of items indicating the amount of each.
 */
public class Warehouse {
//----------------- Data Field --------------------//
	// Status value:                               //
	public static final char SHIPMENT = 'S';       //
	public static final char ORDER = 'O';          //
	public static final char NONE = 'N';           //
                                                   //	
	// Prices:                                     //
	public static final double COST1 = 2.00;       //
	public static final double COST2 = 7.00;       //
	public static final double COST3 = 8.50;       //
	                                               //
	// Warehouse info:                             //
	private String nameOfCity;                     //
	private char status;                           //
	private int [] items = new int[3];             //
//-------------------------------------------------//
	

/* *****************
 *    CONSTRUCTOR
 * ****************/
	// This constructor initializes the warehouse info: 
	public Warehouse(char status, String nameOfCity, int amt1, int amt2, int amt3) {
		setNameOfCity(nameOfCity);
		setStatus(status);
		setItems(amt1, amt2, amt3);
	}
	
/* ****************
 *    Mutators
 * ***************/
	// nameOfCity Setter:
	public void setNameOfCity(String nameOfCity) {
		this.nameOfCity = nameOfCity;
	}
	
	// status Setter:
	public void setStatus(char status) {
		this.status = status;
	}
	
	// (private) items Setter:
	private void setItems(int amt1, int amt2, int amt3) {
		items[0] = amt1;
		items[1] = amt2;
		items[2] = amt3;
	}
	
	public void setItemAmount(int index, int amount) {
		items[index] = amount;
	}
	
/* ***************
 *    ACCESSORS
 * **************/
	// nameOfCity Getter:
	public String getNameOfCity() {
		return nameOfCity;
	}
	
	// status Getter:
	public char getStatus() {
		return status;
	}
	
	// items (array) Getter:
	public int [] getArrayOfItems() {
		return items;
	}
	
	// alternative way of getting item amount
	public int getItemAmount(int index) {
		return items[index];
	}
	
	// in order to get a copy of warehouse info.
	public Warehouse getACopy() {
		return new Warehouse(status, nameOfCity, items[0], items[1], items[2]);
	}
	
/* **************
 * 	print Method
 * **************/
	public void printCard() {
		System.out.println(
				status + "  " + nameOfCity + "\t" + items[0] + "\t" + items[1] + "\t" + items[2]);
	}
	

	
	
	
}
