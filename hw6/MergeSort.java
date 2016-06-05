package hw6;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/25/2016
 *  
 *  Homework# 6
 *  
 * MergeSort Class
 */
public class MergeSort {
	public static int count = 0;
	
	// mergeSort Method:
	public static int [] mergeSort(int [] list) {
		
		// If the list of number equals to 1 or empty
		if(list.length <= 1) {
			count++;
			return list;
		}
		else {
			
			// divide array into two
			int [] left;
			int [] right;
			int mid = list.length/2;
			
			// Initialize left array
			left = new int[mid];
			
			// if the length of the list is even
			if(list.length%2 == 0) {
				count++;
				right = new int[mid];
			}
			
			// if it is odd
			else {
				count++;
				right = new int[mid+1];
			}
			
			// Copy the numbers for the left
			for(int i  = 0; i < mid; i++) {
				count++;
				left[i] = list[i];
			}
			
			// Copy the numbers for the right
			int c = 0;
			for(int i = mid; i < list.length; i++) {
				count++;
				right[c] = list[i];
				c++;
			}
			
			// Continue diving until they become 1 element
			left = mergeSort(left);
			right = mergeSort(right);			
			
			// Merge them
			return merge(left, right);
		}		
	}
	
	// Merge Method
	private static int [] merge(int [] left, int [] right) {
		// create new list:
		int arrayLength = left.length + right.length;
		int [] array = new int[arrayLength];
		
		// Indexes to travel through the arrays:
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;
		
		
		// While the left or right are not empty
		while(leftIndex < left.length || rightIndex < right.length) {
			count++;
			
			// IF both sides are not empty
			if(leftIndex < left.length && rightIndex < right.length) {
				count++;
				
				// IF Left is less than right
				if(left[leftIndex] <= right[rightIndex]) {
					count++;
					
					array[index] = left[leftIndex];
					leftIndex++;
					index++;
				}
				
				// If right is less than right
				else {
					count++;
					
					array[index] = right[rightIndex];
					rightIndex++;
					index++;
				}
			}
			// If right is empty but not left
			else if(leftIndex < left.length) {
				count++;
				
				array[index] = left[leftIndex];
				leftIndex++;
				index++;
			}
			
			// If right is empty but not left
			else if(rightIndex < right.length) {
				count++;
				
				array[index] = right[rightIndex];
				rightIndex++;
				index++;
			}			
		}
		
		return array;
	}
	
	public static void reset() {
		count = 0;
	}
	
	
}
