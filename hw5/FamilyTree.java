package hw5;
/*
 *  Author: Leibniz H. Berihuete
 *  Course: CISC 3130-W6 (Data Structures)
 *  Last Modification: 05/24/2016
 *  
 *  Homework# 5
 *  
 *  FamilyTree Class
 */
public class FamilyTree {
	private Person rootPerson;
	private TreeNode<Person> root;
	
/* ***************
 * 	 CONSTRUCTORS
 * ***************/
	// Constructor:
	public FamilyTree(Person rootPerson) {
		setRootPerson(rootPerson);
		root = new TreeNode<Person>(rootPerson);
		
		buildFamilyTree();
	}
	
	public FamilyTree(TreeNode<Person> root) {
		setRootPerson(root.getData());
		this.root = root;
	}

/* *************
 * 	 MUTATORS
 * *************/
	// family Setter:
	public void setRootPerson(Person rootPerson) {
		this.rootPerson = rootPerson;
	}
	
	// parent Setter:
	public void setParent(TreeNode<Person> parent) {
		root.parent = parent;
		parent.left = root;
	}

/* ****************
 * 	  ACCESSORS
 * ****************/
	// family Getter:
	public Person getRootPerson() {
		return this.rootPerson;
	}
	
	// root Getter:
	public TreeNode<Person> getRoot() {
		return root;
	}

/* ***************
 * 	   OTHERS
 * ***************/
	// buildFamilyTree Method:
	private void buildFamilyTree() {
		
		
		// We going to use this 'p' to create the tree.
		TreeNode<Person> p = root;
		TreeNode<Person> q = root;

		// Get current person
		Person currentPerson = p.getData();
			
		// Get the number of children of current person
		int children = currentPerson.getNumOfChildren();
		Person [] childrenList = rootPerson.getChildren();
			
		// CREATE FAMILY TREE
		for(int i = 0; i < children; i++) {
			if(i == 0) {
				// Add oldest child
				p.left = new TreeNode<Person>(childrenList[i]);
				p.left.parent = p;						
				q = p.left;
			}
			else {
				// add brothers (if any)
				q.right = new TreeNode<Person>(childrenList[i]);
				q.right.parent = q;
				
				q = q.right;
			}
		}		
	}
	
	// printFamilyTree Method:
	public void printFamilyTree() {
		TreeNode<Person> p = root;
		TreeNode<Person> q;
		
		Person currentPerson = p.getData();
		int children = currentPerson.getNumOfChildren();
		System.out.println("\n\n");
		System.out.println("------------------------------------------");
		System.out.println("       " + currentPerson.getName());
		System.out.println("------------------------------------------");
		
		// Who is the father of P?
		System.out.print("Who is the father of " + currentPerson.getName() + "?");
		if(p.parent == null) {
			System.out.println("  THIS IS THE ROOT, FATHER UNKNOWN");
		}
		else {
			Person father = p.parent.getData();			
			System.out.println("  " + father.getName());
		}
		
		
		// Who are all the sons of P?
		System.out.print("Who are all the sons of " + currentPerson.getName() + "?");
		if(children == 0) {
			System.out.println("  NO CHILDREN");
		}
		else {
			Person [] childrenList = currentPerson.getChildren();
			System.out.print("  ");
			for(int i = 0; i < children; i++) {
				if(i!= children-1) {
					System.out.print(childrenList[i].getName()+",");
				}
				else {
					System.out.println(childrenList[i].getName());
				}
			}
		}
		
		q = p.parent;
		
		
		// Who are all the brothers of p?
		System.out.print("Who are all the brothers of " + currentPerson.getName() + "?  ");
		if(q == null) {
			System.out.println("NO BROTHERS");
		}
		else {
			Person [] brothers = q.getData().getChildren();
			for(int i = 0; i < brothers.length; i++) {
				if(brothers[i].getName()!= root.getData().getName()) {
					System.out.print(brothers[i].getName() + ",");
				}
			}
			System.out.println("");
		}
		
		// Who is the youngest brother of p?
		System.out.print("Who is the youngest brother of " + currentPerson.getName() + "?  ");
		q = root.parent;

		if(q == null) {
			System.out.println("NO YOUNG BROTHER");
		}
		else if(q.getData().getNumOfChildren() <= 1) {
			System.out.println("NO YOUNG BROTHER");
		}
		else {
			int numOfChildren = q.getData().getNumOfChildren();
			System.out.println(q.getData().getChildren()[numOfChildren-1].getName());
		}
		
		// Who is the oldest son of p
		System.out.print("Who is the oldest son of " + currentPerson.getName() + "?  ");
		q = p;
		
		if(q.getData().getNumOfChildren() == 0) {
			System.out.println("NO CHILDREN");
		}		
		else {
			System.out.println(q.getData().getChildren()[0].getName());
		}
		
		// Who are the uncles of p
		System.out.print("Who is the uncles of " + currentPerson.getName() + "?  ");
		q = root.parent;
		if(root.parent == null) {
			System.out.println("NO UNCLES");
		}
		else {
			q = q.parent;
			if(q== null) {
				System.out.println("NO UNCLES");
			}
			else {
				Person [] uncles = q.getData().getChildren();
				for(int i = 0; i < uncles.length; i++) {
					if(uncles[i].getName()!= root.parent.getData().getName()) {
						System.out.print(uncles[i].getName() + ",");
					}
				}
				System.out.println("");
			}
		}
		
		// Who is the grand father?
		System.out.print("Who is the GrandFather of " + currentPerson.getName() + "?  ");
		q = root.parent;
		if(root.parent == null) {
			System.out.println("NO GRANDFATHER");
		}
		else {
			q = q.parent;
			if(q== null) {
				System.out.println("NO GRANDFATHER");
			}
			else {
				System.out.println(q.getData().getName());
			}
		}
	}
}

