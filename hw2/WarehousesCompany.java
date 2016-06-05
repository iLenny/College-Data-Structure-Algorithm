package hw2;


/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 Data Structure
 *  Last Modification: 10:15 PM 05/09/2016
 *  
 *  Homework #2
 */

// THIS IS THE MAIN CLASS
public class WarehousesCompany {
	public static final int NEW_YORK = 0;
	public static final int LOS_ANGELES = 1;
	public static final int MIAMI = 2;
	public static final int HOUSTON = 3;
	public static final int CHICAGO = 4;
	
	
	public static void main(String [] args) {
		Warehouse [] warehouses = new Warehouse[5];
		
		// Initialize warehouses[EMPTY WAREHOUSES]:
		warehouses[NEW_YORK] = new Warehouse(Warehouse.NONE, "New York", 0, 0, 0);
		warehouses[LOS_ANGELES] = new Warehouse(Warehouse.NONE, "Los Angeles", 0, 0, 0);
		warehouses[MIAMI] = new Warehouse(Warehouse.NONE, "Miami", 0, 0, 0);
		warehouses[HOUSTON] = new Warehouse(Warehouse.NONE, "Houston", 0, 0, 0);
		warehouses[CHICAGO] = new Warehouse(Warehouse.NONE, "Chicago", 0, 0, 0);
		
		System.out.println("\n\n");
		
		CardReader x = new CardReader("hw2data.txt",warehouses);
		x.update();
		
		System.out.println("\n");
		for(int i = 0; i < warehouses.length; i++) {
			warehouses[i].printCard();		
		}
	}
	
}
