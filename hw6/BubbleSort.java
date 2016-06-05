package hw6;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/25/2016
 *  
 *  Homework# 6
 *  
 *  BubbleSort Class
 */
public class BubbleSort {
	// For comparisons
	public static int count = -1;
	
	// Bubble sort Method
	public static void bubbleSort(int [] list) {
		// For swapping
		int temp;
		
		// To know when to stop sorting
		boolean thereIsSwap = false;
		do{
			count++;
			thereIsSwap = false;
			for(int i = list.length-1; i > 0; i--) {
				for(int j = 0; j < i; j++) {
					// for-loop comparison count
					count++;
					if(list[j] > list[j+1]) {
						// if-statement comparison count
						count++;					
						temp = list[j];
						list[j] = list[j+1];
						list[j+1] = temp;	
						thereIsSwap = true;
					}
				}
			}
		} while(thereIsSwap);
	}
	
	public static void reset() {
		count = 0;
	}
}
