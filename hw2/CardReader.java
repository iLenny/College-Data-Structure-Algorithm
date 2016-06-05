package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * AUTHOR: Leibniz H. Berihuete
 * COUSE: CISC 3130-W6 Data Structure
 * Last Modification 5/11/2016 11:32 AM
 */

/*
 * This class reads the file, and updates
 * the warehouse!
 */
public class CardReader {
//------------ Data Field ----------//
	Warehouse [] warehouses;        //
	File file;                      //
	Scanner scanner;                //
//----------------------------------//

/* *****************
 *    CONSTRUCTOR
 * ****************/
	public CardReader(String fileLocation, Warehouse [] warehouses) {
		// Initialize data fields:
		this.file = new File(fileLocation);		
		this.warehouses = warehouses;
		
		// read-in file
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("\n\tERROR: THE FILE PROVIDED DOESN\'T EXIST");
			System.exit(0);
		}		
	}
	
	
/* *****************
 * 	 update Method
 * ****************/
	public void update() {
		String line;		
		while(scanner.hasNext()) {
			// Get current line from file:
			line = scanner.nextLine();
			
			// IF LINE = NEW YORK then UPDATE New York warehouse
			if(line.contains("New York")) {
				updateLine(WarehousesCompany.NEW_YORK, line);				
			}
			
			// IF LINE = LOS ANGELES then UPDATE Los Angeles warehouse
			else if(line.contains("Los Angeles")) {
				updateLine(WarehousesCompany.LOS_ANGELES, line);
			}
			
			// IF LINE = MIAMI then UPDATE Miami warehouse
			else if(line.contains("Miami")) {
				updateLine(WarehousesCompany.MIAMI, line);
			}
			
			// IF LINE = HOUSTON then UPDATE Houston warehouse
			else if(line.contains("Houston")) {
				updateLine(WarehousesCompany.HOUSTON, line);
			}
			
			// IF LINE = CHICAGO then UPDATE Chicago warehouse
			else if(line.contains("Chicago")) {
				updateLine(WarehousesCompany.CHICAGO, line);
			}
			
			else {
				System.out.println("INVALID LINE");
			}
		}
	}
	
/* *******************
 *   updateLine Method
 * ******************/
	private void updateLine(int index, String line) {
		int [] items = warehouses[index].getArrayOfItems();
		
		char status = line.charAt(0);
		String strAmount1 = line.substring(18, 21);
		String strAmount2 = line.substring(24,27);
		String strAmount3 = line.substring(30,33);		
		int itemAmount1 = Integer.parseInt(strAmount1);
		int itemAmount2 = Integer.parseInt(strAmount2);
		int itemAmount3 = Integer.parseInt(strAmount3);
		
		// IF SHIPMENT
		if(status == Warehouse.SHIPMENT) {
			// set status to shipment
			warehouses[index].setStatus(Warehouse.SHIPMENT);
			
			// set each item to the amount indicated from file
			items[0] = itemAmount1;
			items[1] = itemAmount2;
			items[2] = itemAmount3;
			
			// print the current warehouse info:
			warehouses[index].printCard();
		}
		
		// IF ORDER
		else if(status== Warehouse.ORDER) {
		
			// Let's check whether the order is possible
			boolean amt1Possible = (items[0] >= itemAmount1);
			boolean amt2Possible = (items[1] >= itemAmount2);
			boolean amt3Possible = (items[2] >= itemAmount3);
			
			// if the order is possible:
			if(amt1Possible && amt2Possible && amt3Possible) {
				// print order
				String nameOfCity = warehouses[index].getNameOfCity();
				new Warehouse(Warehouse.ORDER, nameOfCity, itemAmount1, itemAmount2, itemAmount3).printCard();
				
				// print price order:
				double total = (itemAmount1 * Warehouse.COST1) + (itemAmount2 * Warehouse.COST2)
						+ (itemAmount3 * Warehouse.COST3);
				System.out.println("\t\tPRICE ORDER: $" + total);
				
				
				// UPDATE WAREHOUSE'S ITEMS LEFT				
				items[0] -= itemAmount1;
				items[1] -= itemAmount2;
				items[2] -= itemAmount3;				
			}
			
			else {
				
				int cityWithMost1 = index;
				int cityWithMost2 = index;
				int cityWithMost3 = index;
				
				
				// Check other cities:
				for(int i = 0; i < warehouses.length; i++) {
					// get the city with most item1:
					if(warehouses[i].getItemAmount(0) >= warehouses[cityWithMost1].getItemAmount(0)) {
						cityWithMost1 = i;
					}
					
					// get the city with most item2;
					if(warehouses[i].getItemAmount(1) >= warehouses[cityWithMost2].getItemAmount(1)) {
						cityWithMost2 = i;
					}
						
					// get the city with most item3:
					if(warehouses[i].getItemAmount(2) >= warehouses[cityWithMost3].getItemAmount(2)) {
						cityWithMost3 = i;
					}						
				}
				
				// IF ITEM 1 IS NOT POSSIBLE WITH CURRENT CITY
				if(!amt1Possible) {
					if(itemAmount1 <= warehouses[cityWithMost1].getItemAmount(0)) {
						System.out.println("\n\t"+itemAmount1 + " of item 1 shipped from " + warehouses[cityWithMost1].getNameOfCity()+
								" to "+ warehouses[index].getNameOfCity());
						Warehouse temp = warehouses[cityWithMost1].getACopy();
						temp.setStatus(Warehouse.ORDER);
						temp.setItemAmount(0, itemAmount1);
						temp.setItemAmount(1, 0);
						temp.setItemAmount(2, 0);
						temp.printCard();
						
						// Charge 10% EXTRA
						double totalItem1Price = (itemAmount1*Warehouse.COST1) + (itemAmount1*Warehouse.COST1)*0.1;
						System.out.println("\tTotal Price for item1: $" + totalItem1Price+"\n");
						
						//update the cityWithMost1
						int currentAmountItem1 = warehouses[cityWithMost1].getItemAmount(0);
						warehouses[cityWithMost1].setItemAmount(0, currentAmountItem1 - itemAmount1);
					}
					else {
						System.out.println("item1: ORDER UNFILLED");
					}
				}
				// CHARGE THE CURRENT CITY
				else {					
					Warehouse temp = warehouses[cityWithMost1].getACopy();
					temp.setStatus(Warehouse.ORDER);
					temp.setItemAmount(0, itemAmount1);
					temp.setItemAmount(1, 0);
					temp.setItemAmount(2, 0);
					temp.printCard();
					
					// print price order:
					double total = (itemAmount1 * Warehouse.COST1);
					System.out.println("\t\tPRICE ORDER for Item1: $" + total + "[SAME CITY: NO ADDITIONAL CHARGES]");
					
					// update
					items[0] -= itemAmount1;
				}
				
				// IF ITEM 2 IS NOT POSSIBLE WITH CURRENT CITY
				if(!amt2Possible) {
					if(itemAmount1 <= warehouses[cityWithMost2].getItemAmount(0)) {
						System.out.println("\n\t"+itemAmount2 + " of item 2 shipped from " + warehouses[cityWithMost2].getNameOfCity()+
								" to "+ warehouses[index].getNameOfCity());
						Warehouse temp = warehouses[cityWithMost2].getACopy();
						temp.setStatus(Warehouse.ORDER);
						temp.setItemAmount(0, 0);
						temp.setItemAmount(1, itemAmount2);						
						temp.setItemAmount(2, 0);
						temp.printCard();
						
						// Charge 10% EXTRA
						double totalItem2Price = (itemAmount2*Warehouse.COST2)*0.1;
						System.out.println("\tTotal Price for item2: $" + totalItem2Price+"\n");
						
						//update the cityWithMost2
						int currentAmountItem2 = warehouses[cityWithMost2].getItemAmount(1);
						warehouses[cityWithMost2].setItemAmount(1, currentAmountItem2 - itemAmount2);
					}
					else {
						System.out.println("item2: ORDER UNFILLED");
					}
				}
				
				// CHARGE THE CURRENT CITY
				else {					
					Warehouse temp = warehouses[index].getACopy();
					temp.setStatus(Warehouse.ORDER);
					temp.setItemAmount(0, 0);
					temp.setItemAmount(1, itemAmount2);
					temp.setItemAmount(2, 0);
					temp.printCard();
					
					// print price order:
					double total = (itemAmount2 * Warehouse.COST2);
					System.out.println("\t\tPRICE ORDER for Item2: $" + total + "[SAME CITY: NO ADDITIONAL CHARGES]");
					
					// update
					items[1] -= itemAmount2;
				}
				
				
				// IF ITEM 3 IS NOT POSSIBLE WITH CURRENT CITY
				if(!amt3Possible) {
					if(itemAmount3 <= warehouses[cityWithMost3].getItemAmount(2)) {
						System.out.println("\n\t"+itemAmount3 + " of item 3 shipped from " + warehouses[cityWithMost3].getNameOfCity()+
								" to "+ warehouses[index].getNameOfCity());
						Warehouse temp = warehouses[cityWithMost3].getACopy();
						temp.setStatus(Warehouse.ORDER);
						temp.setItemAmount(0, 0);
						temp.setItemAmount(1, 0);
						temp.setItemAmount(2, itemAmount3);
						temp.printCard();
						
						// Charge 10% EXTRA
						double totalItem3Price = (itemAmount3*Warehouse.COST3)*0.1;
						System.out.println("\tTotal Price for item3: $" + totalItem3Price);
						
						//update the cityWithMost3
						int currentAmountItem3= warehouses[cityWithMost3].getItemAmount(2);
						warehouses[cityWithMost3].setItemAmount(2, currentAmountItem3 - itemAmount3);
					}
					else {
						System.out.println("item3: ORDER UNFILLED");
					}
				}
				
				// CHARGE THE CURRENT CITY
				else {					
					Warehouse temp = warehouses[index].getACopy();
					temp.setStatus(Warehouse.ORDER);
					temp.setItemAmount(0, 0);
					temp.setItemAmount(1, 0);
					temp.setItemAmount(2, itemAmount3);					
					temp.printCard();
					
					// print price order:
					double total = (itemAmount3 * Warehouse.COST3);
					System.out.println("\t\tPRICE ORDER for Item3: $" + total + "[SAME CITY: NO ADDITIONAL CHARGES]");
					
					// update
					items[2] -= itemAmount3;
				}				
			}			
		}
	
	}

	
	

}
