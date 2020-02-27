/*
 * This class will be responsible for inserting and deleting nodes
 * during which processes it will also check heights and determine
 * balance of the tree and rotate branches as needed
 * 
 * Important to note that balance is determined, not tracked
 * as the balance is corrected on each for each node which is
 * involved in insertion, which equates to each node which
 * is affected in height/balance from the insertion
 */

public class AVL_Tree{
	public void insert() {
	}	
			
			
			
			
			
			
			
	/*
	 * AVLNode is added as a class inside the tree as it is a 
	 * component of the tree, where the tree is accessed in order 
	 * to retrieve information of nodes, the nodes should
	 * never be accessed directly so are private.
	 */
	private class AVLNode {
		String key; // (ISBN number)
		Book value; //create a class representing a book with minimum attributes
		int height;
		AVLNode leftPtr;
		AVLNode rightPtr;
		public AVLNode(Book b) {
			value = b;
			key = value.key();
			height = 0;
			leftPtr = null;
			rightPtr = null;
		}
		
		public int getHeight() {
			return height;
		}
		public void setHeight(int h){
			height = h;
		}
		
	}
		
			
}