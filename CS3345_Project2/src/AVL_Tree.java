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

/*
 * I will be determining order of the tree using compareTo since it
 * is a requirement that the key be a string here. 
 * String1.compareTo(String2) < 0 will indicate that String1 < String2
 * String1.compareTo(String2) > 0 will indicate that String1 > String2
 */
public class AVL_Tree{
	private AVLNode head = null;
	public void insert(Book b) {
		balancedInsert(head, new AVLNode(b));
	}	
	private void balancedInsert(AVLNode parent, AVLNode b) {
		if(parent == null) {
			parent = b;
		}
		else if(parent.key.compareTo(b.key) < 0) {
			balancedInsert(parent.leftPtr(), b);
		}
		else if(parent.key.compareTo(b.key) > 0) {
			balancedInsert(parent.rightPtr(), b);
		}
		if(parent.getHeight() == max(parent.leftHeight(), parent.rightHeight())) {
			parent.setHeight(parent.getHeight() + 1);
		}
		balance(parent);
	}
	private void balance(AVLNode b) {
		
	}
	private int max(int a, int b) {
		if(a <= b) {
			return b;
		}
		else {
			return a;
		}
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
		private AVLNode leftPtr;
		private AVLNode rightPtr;
		public AVLNode rightPtr() {
			return rightPtr;
		}
		public AVLNode leftPtr() {
			return leftPtr;
		}
		public AVLNode(Book b) {
			value = b;
			key = value.key();
			height = 0;
			leftPtr = null;
			rightPtr = null;
		}
		public int leftHeight() {
			if(leftPtr == null) {
				return -1;
			}
			else {
				return leftPtr.getHeight();
			}
		}
		public int rightHeight() {
			if(rightPtr == null) {
				return -1;
			}
			else {
				return rightPtr.getHeight();
			}
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int h){
			height = h;
		}
	}
		
			
}