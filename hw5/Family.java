package hw5;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/24/2016
 *  
 *  Homework# 5
 *  
 *  Family Class
 *   - this is the main class.
 */
public class Family {
	private static final int JONES = 0;
	private static final int BOB = 1;
	private static final int DAN = 2;
	private static final int BRIAN = 3;
	private static final int RICHARD = 4;
	private static final int JAKE = 5;
	private static final int MICHAEL = 6;
	private static final int BILL = 7;
	private static final int DEVILLE = 8;
	
	
	
/* ****************
 * 	    MAIN
 * ****************/
	public static void main(String [] args) {
		
		// Create list of persons
		Person [] person = {
			new Person("Jones"),
			new Person("Bob"),
			new Person("Dan"),
			new Person("Brian"),
			new Person("Richard"),
			new Person("Jake"),
			new Person("Michael"),
			new Person("Bill"),
			new Person("Deville")
		};
		
		// Indicate relationships:
		
		// JONES: 3 Children: BOB, DAN, BRIAN
		person[JONES].setChildren(person[BOB],person[DAN], person[BRIAN]);
		
		// BOB: 2 Children: RICHARD, JAKE
		person[BOB].setChildren(person[RICHARD], person[JAKE]);
		
		// BRIAN: 1 Child: MICHAEL
		person[BRIAN].setChildren(person[MICHAEL]);
		
		// JAKE: 1 Child: BILL
		person[JAKE].setChildren(person[BILL]);
		
		// MICHAEL: 1 Child: DEVILLE
		person[MICHAEL].setChildren(person[DEVILLE]);
		
		// Build Trees
		FamilyTree [] familyTrees = {
				new FamilyTree(person[JONES]),   // 0
				new FamilyTree(person[BOB]),     // 1
				new FamilyTree(person[DAN]),     // 2
				new FamilyTree(person[BRIAN]),   // 3
				new FamilyTree(person[RICHARD]), // 4
				new FamilyTree(person[JAKE]),    // 5
				new FamilyTree(person[MICHAEL]), // 6
				new FamilyTree(person[BILL]),    // 7
				new FamilyTree(person[DEVILLE]), // 8
				
		};
		
		// Connect Trees		
		familyTrees[1].setParent(familyTrees[0].getRoot());
		familyTrees[2].setParent(familyTrees[0].getRoot());
		familyTrees[3].setParent(familyTrees[0].getRoot());
		
		familyTrees[4].setParent(familyTrees[1].getRoot());
		familyTrees[5].setParent(familyTrees[1].getRoot());
		
		familyTrees[6].setParent(familyTrees[3].getRoot());
		
		familyTrees[7].setParent(familyTrees[5].getRoot());
		
		familyTrees[8].setParent(familyTrees[6].getRoot());
		
		
		// print trees
		for(int i = 0; i < familyTrees.length; i++) {
			familyTrees[i].printFamilyTree();
		}		
	}
}
