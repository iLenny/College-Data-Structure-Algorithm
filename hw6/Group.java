package hw6;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/25/2016
 *  
 *  Homework# 6
 *  
 *  Group Class
 *    
 */
public class Group {
	public static final int SORTED = 0;
	public static final int ALMOST_SORTED = 1;
	public static final int RANDOM = 2;
	public static final int REVERSE = 3;
	
	private String header;
	
/* *****************
 * 	  CONSTRUCTOR
 * *****************/
	public Group(String header) {
		setHeader(header);
	}
	
/* *****************
 * 	   MUTATORS
 * *****************/
	public void setHeader(String header) {
		this.header = header;
	}
	
/* ****************
 *   ACCESSORS
 * ****************/
	public String getHeader() {
		return this.header;
	}
	
	
/* ******************
 * 	    OTHERS
 * ******************/
	public int [] generateNumbers(final int quantity, int state) {
		int [] numbers = new int[quantity];
		
		switch(state) {
		
		// WHEN STATE IS SORTED
		case SORTED:
			for(int i = 0; i < quantity; i++) {
				numbers[i] = i*2;
				if(i%10 == 0 && i!= 0) {
					System.out.println(numbers[i]);
				}else {
					System.out.print(numbers[i] + ", ");
				}
			}
			break;
			
		// WHEN STATE IS ALMOST_SORTED
		case ALMOST_SORTED:
			for(int i = 0; i < quantity; i++) {	
				
				if(i == quantity-2) {
					numbers[i] = numbers[0];
				}
				else if(i >= quantity-3 && i < quantity-2) {
					numbers[i] = new java.util.Random().nextInt(200);
				}
				
				else{
					numbers[i] = i*2;
				}				
				if(i%10 == 0 && i!= 0) {
					System.out.println(numbers[i]);
				}else {
					System.out.print(numbers[i] + ", ");
				}
			}
			break;
			
		// WHEN STATE IS RANDOM	
		case RANDOM:
			for(int i = 0; i < quantity; i++) {
				numbers[i] = new java.util.Random().nextInt(quantity*2);
				if(i%10 == 0 && i!= 0) {
					System.out.println(numbers[i]);
				}else {
					System.out.print(numbers[i] + ", ");
				}
			}
			break;
			
		// WHEN STATE IS REVERSE
		case REVERSE:
			for(int i = quantity-1; i > 0; i--) {
				numbers[i] = i*2;
				if(i%10 == 0 && i!= 0) {
					System.out.println(numbers[i]);
				}else {
					System.out.print(numbers[i] + ", ");
				}
			}
			break;
			
		default:
			System.out.println("Invalid state");
		}
		
		System.out.println("\n");
		return numbers;	
	}
}
