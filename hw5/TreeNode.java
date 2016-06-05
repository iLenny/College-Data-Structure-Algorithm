package hw5;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/24/2016
 *  
 *  Homework# 5
 *  
 *  TreeNode Class
 */
public class TreeNode<E> {
	TreeNode<E> parent;
	TreeNode<E> left;
	TreeNode<E> right;
	private E data;
	
/* ****************
 * 	 CONSTRUCTORS
 * ****************/
	// Default Constructor
	public TreeNode() {
		parent = null;
		left = null;
		right = null;
	}
	
	// Constructor(E)
	public TreeNode(E data) {
		parent = null;
		left = null;
		right = null;
		setData(data);
	}
	
	
/* ****************
 * 	  MUTATORS
 * ****************/
	// data Setter:
	public void setData(E data) {
		this.data = data;
	}
	
/* ****************
 * 	  ACCESSORS
 * ****************/
	// data Getter:
	public E getData() {
		return this.data;
	}
}
