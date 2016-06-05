package hw4;

/*
 * Author: LEIBNIZ H. BERIHUETE
 * Course: CISC 3130-W6
 * Last Modification: 05/15/2016
 * Homework #4
 */
public class ProgramHW4 {
	static BinaryTree tree1;
	static BinaryTree tree2;
	static BinaryTree tree3;
	static BinaryTree tree4;
	static BinaryTree tree5;
	static BinaryTree tree6;
	static BinaryTree tree7;
	public static void main(String [] args) {	
		// Set# 1
		int [] set1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,
				14,15,16,17,18,19,20,-999};
		
		// Set# 2
		int [] set2 = {3, 1, 5, -999};
		
		// Set# 3
		int [] set3 = {-999};
		
		// Set# 4
		int [] set4 = {2, -999};
		
		// Set# 5
		int [] set5 = {11,25,75,12,37,60,90,8,15,32,45,
			    50,67,97,95,-999};
		
		// Set# 6
		int [] set6 = {50,40,60,30,70,20,80,10,90,-999};
		
		// Set# 7
		int [] set7 = {30,40,20,10,50, -999};
		
		System.out.println("\n---@@ [CREATE BINARY TREE] @@---");
		tree1 = new BinaryTree(set1);
		tree2 = new BinaryTree(set2);
		tree3 = new BinaryTree(set3);
		tree4 = new BinaryTree(set4);
		tree5 = new BinaryTree(set5);
		tree6 = new BinaryTree(set6);
		tree7 = new BinaryTree(set7);
//		
//		System.out.println("\n--@@ [PRINT PRE,IN,POST ORDERS] @@---");
//		printOrders();
//		
//		
//		System.out.println("\n--@@ [CALL COUNT METHOD] @@--");
//		printCounts();
//		
//		System.out.println("\n--@@ [CALL CHILDREN METHOD] @@--");
//		printChildren();
		
		System.out.println("\n--@@ [INSERT AND DELETE NODES] @@--");
		insertAndDelete();
		
		// NOW LET"S REPRINT ORDERS, COUNT, and CHILDREN METHODS
		System.out.println("\n--@@ [PRINT PRE,IN,POST ORDERS AGAIN] @@---");
		printOrders();
		
		
		System.out.println("\n--@@ [CALL COUNT METHOD AGAIN] @@--");
		printCounts();
		
		System.out.println("\n--@@ [CALL CHILDREN METHOD AGAIN] @@--");
		printChildren();
		
	
		
		
	}
	
	private static void printOrders() {
		// SET 1
		System.out.print("------------------------ SET# 1 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree1.printPreOrder(tree1.getRoot());
		System.out.print("\nIN:   ");
		tree1.printInOrder(tree1.getRoot());
		System.out.print("\nPOST: ");
		tree1.printPostOrder(tree1.getRoot());
		System.out.println("\n");
		
		// SET 2
		System.out.print("------------------------ SET# 2 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree2.printPreOrder(tree2.getRoot());
		System.out.print("\nIN:   ");
		tree2.printInOrder(tree2.getRoot());
		System.out.print("\nPOST: ");
		tree2.printPostOrder(tree2.getRoot());
		System.out.println();
		
		// SET 3
		System.out.print("------------------------ SET# 3 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree3.printPreOrder(tree3.getRoot());
		System.out.print("\nIN:   ");
		tree3.printInOrder(tree3.getRoot());
		System.out.print("\nPOST: ");
		tree3.printPostOrder(tree3.getRoot());
		System.out.println("\n");
		
		// SET 4
		System.out.print("------------------------ SET# 4 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree4.printPreOrder(tree4.getRoot());
		System.out.print("\nIN:   ");
		tree4.printInOrder(tree4.getRoot());
		System.out.print("\nPOST: ");
		tree4.printPostOrder(tree4.getRoot());
		System.out.println("\n");
		
		// SET 5
		System.out.print("------------------------ SET# 5 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree5.printPreOrder(tree5.getRoot());
		System.out.print("\nIN:   ");
		tree5.printInOrder(tree5.getRoot());
		System.out.print("\nPOST: ");
		tree5.printPostOrder(tree5.getRoot());
		System.out.println("\n");
		
		// SET 6
		System.out.print("------------------------ SET# 6 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree6.printPreOrder(tree6.getRoot());
		System.out.print("\nIN:   ");
		tree6.printInOrder(tree6.getRoot());
		System.out.print("\nPOST: ");
		tree6.printPostOrder(tree6.getRoot());
		System.out.println("\n");
		
		// SET 7
		System.out.print("------------------------ SET# 7 " +
		                 "------------------------");
		System.out.print("\nPRE:  ");
		tree7.printPreOrder(tree7.getRoot());
		System.out.print("\nIN:   ");
		tree7.printInOrder(tree7.getRoot());
		System.out.print("\nPOST: ");
		tree7.printPostOrder(tree7.getRoot());
		System.out.println("\n");	
	}
	
	private static void printCounts() {
		System.out.println("SET #1 COUNT:" + tree1.count());			
		System.out.println("SET #2 COUNT:" + tree2.count());		
		System.out.println("SET #3 COUNT:" + tree3.count());		
		System.out.println("SET #4 COUNT:" + tree4.count());		
		System.out.println("SET #5 COUNT:" + tree5.count());		
		System.out.println("SET #6 COUNT:" + tree6.count());		
		System.out.println("SET #7 COUNT:" + tree7.count());

	}
	
	private static void printChildren() {
		System.out.println("[SET #1]");
		tree1.children(tree1.getRoot());
		System.out.println("[END OF SET# 1\n");
		
		System.out.println("SET #2");
		tree2.children(tree2.getRoot());
		System.out.println("[END OF SET# 2\n");
		
		System.out.println("SET #3");
		tree3.children(tree3.getRoot());
		System.out.println("[END OF SET# 3\n");
		
		System.out.println("SET #4");
		tree4.children(tree4.getRoot());
		System.out.println("[END OF SET# 4\n");
		
		System.out.println("SET #5");
		tree5.children(tree5.getRoot());
		System.out.println("[END OF SET# 5\n");
		
		System.out.println("SET #6");
		tree6.children(tree6.getRoot());
		System.out.println("[END OF SET# 6\n");
		
		System.out.println("SET #7");
		tree7.children(tree7.getRoot());
		System.out.println("[END OF SET# 7\n");
		
	}
	
	private static void insertAndDelete() {
		System.out.println("\nINSERTING SET# 1-----");
		// Set#1 insert
		tree1.addNode(21);
		tree1.addNode(0);
		tree1.addNode(10);
		
		System.out.println("\nDELETING SET# 1-----");
		// Set#1 delete
		tree1.deleteNode(1);
		tree1.deleteNode(10);
		tree1.deleteNode(11);
		tree1.deleteNode(15);
		tree1.deleteNode(2);

		System.out.println("\nDELETING SET# 2-----");
		// Set#2 delete
		tree2.deleteNode(3);
		tree2.deleteNode(1);

		System.out.println("\nINSERTING SET# 3-----");
		// Set#3 insert
		tree3.addNode(30);
		tree3.addNode(5);
		tree3.addNode(10);
		tree3.addNode(20);
		
		System.out.println("\nDELETING SET# 3-----");
		// Set#3 delete
		tree3.deleteNode(15);
		tree3.deleteNode(20);
		tree3.deleteNode(10);
		tree3.deleteNode(5);
		tree3.deleteNode(15);
		tree3.deleteNode(30);	
		
		System.out.println("\nDELETING SET# 4-----");
		// Set#4 delete
		tree4.deleteNode(2);
		
		System.out.println("\nINSERTING SET# 5-----");
		// Set#5 insert
		tree5.addNode(40);
		tree5.addNode(90);
		
		System.out.println("\nDELETING SET# 5-----");
		// Set#5 delete
		tree5.deleteNode(37);
		tree5.deleteNode(15);		
	}	
}
