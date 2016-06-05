package hw5;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/24/2016
 *  
 *  Homework# 5
 *  
 *  Person Class
 */
public class Person {
	private String name;
	private Person [] children;
/* ***************
 * 	CONSTRUCTORS
 * ***************/
	// Default Constructor
	public Person() {
		setName("Unknown");
	}
	
	// Constructor(String)
	public Person(String name) {
		setName(name);
	}
	
/* ****************
 * 	   MUTATORS
 * ****************/
	// name Setter:
	public void setName(String name) {
		this.name = name;
	}
	
	// children Setter:
	public void setChildren(Person...children) {
		this.children = children;
	}
	
	
	
/* ****************
 * 	   ACCESSORS
 * ****************/
	// name Getter:
	public String getName() {
		return name;
	}
	
	// children Getter:
	public Person [] getChildren() {
		return this.children;
	}
	
	// numOfChildren Getter:
	public int getNumOfChildren() {
		if(children != null)
			return children.length;
		else
			return 0;
	}
}
