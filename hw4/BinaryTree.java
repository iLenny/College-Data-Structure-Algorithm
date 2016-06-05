package hw4;

/*
 * Author: Leibniz H. Berihuete
 * Course: CISC 3130 (DataStructure) * 
 * HomeWork# 4
 * 
 * Binary Tree Class
 */
public class BinaryTree {
	private static int id = 0;
	public int ID;
	private int count = 0;
	private TreeNode root;
	
	
	// CONSTRUCTOR
	public BinaryTree(int [] list) {		
		root = null;
		ID = ++id;
		// Create binary tree with the list of numbers
		createBinaryTree(list);
		System.out.println("Tree "+ ID + " created..");
	}
	
	// CREATE BINARY TREE
	private void createBinaryTree(int [] list) {
		for(int i = 0; i < list.length; i++) {
			if(list[i]!= -999)
				addNode(list[i]);
		}
	}
	
	// ADD NODE
	public void addNode(int num) {
		TreeNode node = root;
		while(true) {
			// FIRST TIME
			if(root == null) {
				TreeNode temp = new TreeNode(num);
				root= temp;
				node = root;
				break;
				
			}
			// IF NUM IS LESS THAN CURRENT NODE
			else if(num <= node.getNumber()){
				if(node.left == null) {
					TreeNode temp = new TreeNode(num);
					node.left = temp;
					break;
				}
				else {
					node = node.left;
				}				
			}			
			// IF NUM IS GREATER THAN CURRENT NODE
			else if(num > node.getNumber()){
				if(node.right == null) {
					TreeNode temp = new TreeNode(num);
					node.right = temp;
					break;
				}
				else {
					node = node.right;
				}				
			}
		}
	}
	
	// DELETE NODE
	public void deleteNode(int num) {
		TreeNode node = findNode(num);
		if(node==null) {
			System.out.println("THE NODE DOESN\'T EXIST");
		}
		else if(node == root) {
			// If root don't have children
			if(root.left == null && root.right == null) {
				root = null;
				System.out.println("Number: " + num + " (root) has been deleted");
				System.out.println("THERE ARE NO MORE TREE NODES");
			}
			// if the root only have a right child
			else if(root.left == null && root.right != null) {

				root = root.right;
				System.out.println("Number: "+ num +" (root) has been deleted");
				System.out.println("Number: "+root.getNumber()+" became the new root");
			}
			// if the root have a left child
			else {
				// Get parent of the largestChild
				// provide the starting node, and the parent of that node
				TreeNode parent = getParentOfLargestChild(root.left, root);
				
				node = parent.right;
				node.right = root.right;
				node.left = root.left;	
				root = node;
				
				// Cut of the parent of that node
				parent.right = null;
				System.out.println("Number: "+ num +" (root) has been deleted");
				System.out.println("Number: "+root.getNumber()+" became the new root");
			}
		}
		else {
			if(node.left == null && node.right == null) {
				System.out.println("Number: "+ num +" has been deleted");
				node = null;
				
			}
			else if(node.left == null && node.right != null) {
				TreeNode parent = findParentNodeOf(num);
				parent.right = node.right;
				node.right = null;
				System.out.println("Number: "+ num +" has been deleted");
			}
			else {
				// Parent of the one you want to delete
				TreeNode parent = findParentNodeOf(node.getNumber());
				
				// Parent of the largest child
				TreeNode parentOfLargest = getParentOfLargestChild(node.left, node);
				
				// Largest child
				TreeNode largest = parentOfLargest.right;
				
				// Give the largest the same right & left
				// of the one that you want to delete
				largest.right = node.right;
				largest.left = node.left;
				
				// make the parent of the largest's right child null
				parentOfLargest.right = null;
				
				// Give the parent, of the one you want to delete, to the largest 
				parent.left = largest;
				
				// Delete the node
				node = null;
				
				System.out.println("Number: "+ num +" has been deleted");				
			}
		}
		
	}
	
	
	// FIND NODE
	public TreeNode findNode(int num) {
		TreeNode foundNode = root;
		while(foundNode != null) {
			if(num == foundNode.getNumber()) {
				return foundNode;
			}
			else if(num < foundNode.getNumber()) {
				foundNode = foundNode.left;
			}
			else if(num > foundNode.getNumber()) {
				foundNode = foundNode.right;
			}
			
		}	
		
		return null;
	}
	
	// FIND PARENT OF NODE
	public TreeNode findParentNodeOf(int num) {
		TreeNode foundNode = root;
		TreeNode parent = null;
		while(foundNode != null) {
			if(num == foundNode.getNumber()) {
				return parent;
			}
			else if(num < foundNode.getNumber()) {
				parent = foundNode;
				foundNode = foundNode.left;
			}
			else if(num > foundNode.getNumber()) {
				parent = foundNode;
				foundNode = foundNode.right;
			}
			
		}		
		return parent;
	}
	
	
	// GET LARGEST CHILD
	private TreeNode getTheLargestChild(TreeNode node) {
		while(node.right !=null){
			node = node.right;
		}
		return node;
	}
	
	// GET THE PARENT OF THE LARGEST CHILD
	private TreeNode getParentOfLargestChild(TreeNode node, TreeNode parent) {
		while(node.right != null) {
			parent = node;
			node = node.right;
		}
		return parent;
	}
	
	
	
	// GET ROOT
	public TreeNode getRoot() {
		return this.root;
	}
	
	
	// PRINT PRE ORDER
	public void printPreOrder(TreeNode node) {		
		if(node == null) {
			return;
		}
		else {
			System.out.print(node.getNumber()+ " ");
			printPreOrder(node.left);			
			printPreOrder(node.right);
		}		
	}
	
	// PRINT IN ORDER
	public void printInOrder(TreeNode node) {		
		if(node == null) {
			return;
		}
		else {
			printInOrder(node.left);
			System.out.print(node.getNumber()+ " ");
			printInOrder(node.right);
		}		
	}
	
	// PRINT POST ORDER
	public void printPostOrder(TreeNode node) {		
		if(node == null) {
			return;
		}
		else {
			printPostOrder(node.left);			
			printPostOrder(node.right);
			System.out.print(node.getNumber()+ " ");
		}		
	}
	
	// COUNT NODES
	private void countNodes(TreeNode node) {
		if(node == null) {
			return;
		}
		else {
			count++;
			countNodes(node.left);
			countNodes(node.right);

		}		
	}
	
	// COUNT: returns the number of Node
	public int count() {
		count = 0;
		countNodes(root);
		return count;
	}
	
	// Print Children each parent has:
	public void children(TreeNode node) {
		if(node == null) {
			return;
		}
		else {
			System.out.println("|Parent " + node.getNumber());
			if(node.left != null) {
				System.out.print("| LEFT:" + node.left.getNumber());
			}else {
				System.out.print("| LEFT: none");
			}
			
			if(node.right != null) {
				System.out.println("  RIGHT:" + node.right.getNumber());
			}else {
				System.out.println("  RIGHT: none");
			}
			System.out.println("+--------------------");
			children(node.left);			
			children(node.right);
			
		}
		
	}
	
	
	

	
}
