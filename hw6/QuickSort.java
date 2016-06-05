package hw6;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/25/2016
 *  
 *  Homework# 6
 *  
 *  QuickSort Class
 */

public class QuickSort {
	// In order to count comparisons
	public static int count = 0;
	
	// quickSort Method:
	public static void quickSort(int [] list, int left, int right) {
		// Get left and Right
		int i = left;
		int j = right;
		
		// temp for swapping
		int temp;
		
		// pivot is going to be the mid of left and right
		int pivot = list[(left+right)/2];

		
		while(i <= j) {
			
			// Comparison count of while loop
			count++;
			
			// If current left number is less than the pivot
			while(list[i] < pivot) { 
				// Comparison count of while loop
				count++;
				i++;
			}
			
			// If current right number is greater than the pivot
			while(list[j] > pivot) {
				// Comparison count of while loop
				count++;
				j--;
			}
				
			// Over here we swap
			if(i <= j) {
				
				// Comparison count of if statement
				count++;
				// SWAP
				temp = list[j];
				list[j] = list[i];
				list[i] = temp;
				i++;
				j--;
			}
		}
		if(left < j) {
			
			// Comparison count of if statement
			count++;
			quickSort(list, left, j);
		}
		if(i < right) {
			// Comparison count of if statement
			count++;
			quickSort(list, i, right);
		}
	}	
	
	public static void reset() {
		count = 0;
	}
}
	

