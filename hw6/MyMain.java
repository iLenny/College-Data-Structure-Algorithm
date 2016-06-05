package hw6;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/25/2016
 *  
 *  Homework# 6
 *  
 *  MyMain Class
 *    - This is the main class
 */
public class MyMain {
	// FINAL VALUES TO INDENTIFY SORTS
	private static final int BUBBLE_SORT = 0;
	private static final int QUICK_SORT = 1;
	private static final int MERGE_SORT = 2;
	
	// FOR  COMPARISONS
	static int [] bubbleComparison = new int [3];
	static int [] quickComparison = new int [3];
	static int [] mergeComparison = new int [3];
	
	public static void main (String [] args) {
		
		
		Group g1 = new Group("10 numbers in almost sorted order");
		Group g2 = new Group("20 numbers in reverse order");
		Group g3 = new Group("30 numbers in random order");
		
		
		
		
		System.out.println("\t" + g1.getHeader());
		int [] num1 = g1.generateNumbers(10, Group.ALMOST_SORTED);
		
		System.out.println("\t" + g2.getHeader());
		int [] num2 = g2.generateNumbers(20, Group.REVERSE);
		
		System.out.println("\t" + g3.getHeader());
		int [] num3 = g3.generateNumbers(30, Group.RANDOM);
		
		
		int [] bubble1 = num1.clone();
		int [] bubble2 = num2.clone();
		int [] bubble3 = num3.clone();
		
		int [] quick1 = num1.clone();
		int [] quick2 = num2.clone();
		int [] quick3 = num3.clone();
		
		int [] merge1 = num1.clone();
		int [] merge2 = num2.clone();
		int [] merge3 = num3.clone();
				
		
		
		
		

		
		// BUBBLE SORT:
		
		System.out.println("-----------------------------");
		System.out.println("------- BUBBLE SORT ---------");
		System.out.println("-----------------------------");
		
		sortAndPrint(g1.getHeader(), bubble1, BUBBLE_SORT, 0);
		sortAndPrint(g2.getHeader(), bubble2, BUBBLE_SORT, 1);
		sortAndPrint(g3.getHeader(), bubble3, BUBBLE_SORT, 2);
		
		
		// QUICK SORT:
		
		System.out.println("-----------------------------");
		System.out.println("-------- QUICK SORT ---------");
		System.out.println("-----------------------------");
		
		sortAndPrint(g1.getHeader(), quick1, QUICK_SORT, 0);
		sortAndPrint(g2.getHeader(), quick2, QUICK_SORT, 1);
		sortAndPrint(g3.getHeader(), quick3, QUICK_SORT, 2);

		// MERGE SORT:
		
		System.out.println("-----------------------------");
		System.out.println("-------- MERGE SORT ---------");
		System.out.println("-----------------------------");
		
		sortAndPrint(g1.getHeader(), merge1, MERGE_SORT, 0);
		sortAndPrint(g2.getHeader(), merge2, MERGE_SORT, 1);
		sortAndPrint(g3.getHeader(), merge3, MERGE_SORT, 2);
		
		
			
	}
	
	
	// SORT AND PRINT
	public static void sortAndPrint(String header, int [] array, int sort, int x) {
		switch(sort) {
		case BUBBLE_SORT:
			BubbleSort.bubbleSort(array);
			System.out.println("\n\t" + header);
			
			// PRINT SORTED ARRAY
			for(int i = 0; i < array.length; i++) {
				if(i%10 == 0 && i!= 0) {
					System.out.println(array[i]);
				}else {
					System.out.print(array[i] + ", ");
				}
			}
			
			System.out.println("BubbleSort Comparisons: " + BubbleSort.count);
			bubbleComparison[x] = BubbleSort.count;
			BubbleSort.reset();
			break;
			
		case QUICK_SORT:
			QuickSort.quickSort(array, 0, array.length-1);
			System.out.println("\n\t" + header);
			
			// PRINT SORTED ARRAY
			for(int i = 0; i < array.length; i++) {
				if(i%10 == 0 && i!= 0) {
					System.out.println(array[i]);
				}else {
					System.out.print(array[i] + ", ");
				}
			}
			
			System.out.println("QuickSort Comparisons: " + QuickSort.count);
			quickComparison[x] = QuickSort.count;
			QuickSort.reset();
			break;
			
		case MERGE_SORT:
			int [] nArray = MergeSort.mergeSort(array);
			System.out.println("\n\t" + header);
			
			// PRINT SORTED ARRAY
			for(int i = 0; i < nArray.length; i++) {
				if(i%10 == 0 && i!= 0) {
					System.out.println(nArray[i]);
				}else {
					System.out.print(nArray[i] + ", ");
				}
			}
			
			System.out.println("MergeSort Comparisons: " + MergeSort.count);
			mergeComparison[x] = MergeSort.count;
			MergeSort.reset();
			break;
		
		}	
	}
}
