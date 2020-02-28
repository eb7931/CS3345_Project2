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
	private boolean debug = false;
	public void insert(Book b) {
		balancedInsert(head, new AVLNode(b));
	}	
	private void balancedInsert(AVLNode parent, AVLNode n) {
		if(parent == null) {
			parent = n;
		}
		else if(parent.key().compareTo(n.key()) < 0) {
			if(parent.leftPtr() != null) 
				balancedInsert(parent.leftPtr(), n);
			else
				parent.setLeft(n);
		}
		else if(parent.key().compareTo(n.key()) > 0) {
			if(parent.rightPtr() != null)
				balancedInsert(parent.rightPtr(), n);
			else
				parent.setRight(n);
		}
		if(parent.getHeight() == max(parent.leftHeight(), parent.rightHeight())) {
			parent.setHeight(parent.getHeight() + 1);
		}
		balance(parent, n);
		print(parent);
	}
	/*
	 * In order to make it possible to rearrange all the nodes related to a given
	 * rotation, I am going to call balance when a nodes CHILDREN are out of balance
	 * this will make it easier to adjust the point from the parent
	 * of the imbalanced node to its new child. Other nodes can be found indirectly
	 * using balance numbers and comparisons so are lower priority
	 * 
	 * I call here z the parent of the imbalanced, g the imbalanced, 
	 * p the parent of x and child of g, x the inserted
	 */
	private void balance(AVLNode z, AVLNode x) {
		AVLNode g = null;
		AVLNode p = null;
		int leftChildBalance = z.leftPtr().leftHeight() - z.leftPtr().rightHeight();
		int rightChildBalance = z.rightPtr().leftHeight() - z.rightPtr().rightHeight();
		boolean leftChild = false;
		boolean imbalanced = false;
		boolean leftHeavy = false;
		if(leftChildBalance < -1 ) {
			imbalanced = true;
			leftHeavy = false;
			leftChild = true;
			g = z.leftPtr();
			p = g.rightPtr();
		}
		else if(leftChildBalance > 1) {
			imbalanced = true;
			leftHeavy = true;
			leftChild = true;
			g = z.leftPtr();
			p = g.leftPtr();
		}
		else if(rightChildBalance < -1) {
			imbalanced = true;
			leftHeavy = false;
			leftChild = false;
			g = z.rightPtr();
			p = g.rightPtr();
		}
		else if(rightChildBalance > 1) {
			imbalanced = true;
			leftHeavy = true;
			leftChild = false;
			g = z.rightPtr();
			p = g.leftPtr();
		}
		if(imbalanced) {
			if(p.rightPtr() == x) {
				if(leftHeavy) 
					fixLR(leftChild,z,g,p,x);
				else
					fixRR(leftChild,z,g,p);
			}
			else if(p.leftPtr() == x) {
				if(leftHeavy)
					fixLL(leftChild,z,g,p);
				else
					fixRL(leftChild,z,g,p,x);
			}
		}
	}
	private void fixLL(boolean l, AVLNode z, AVLNode g, AVLNode p) {
		if(l)
			z.setLeft(p);
		else
			z.setRight(p);
		g.setLeft(p.rightPtr());
		p.setRight(g);
	}
	private void fixRR(boolean l, AVLNode z, AVLNode g, AVLNode p) {
		if(l)
			z.setLeft(p);
		else
			z.setRight(p);
		g.setRight(p.leftPtr());
		p.setLeft(g);
	}
	private void fixLR(boolean l, AVLNode z, AVLNode g, AVLNode p, AVLNode x) {
		if(l)
			z.setLeft(x);
		else
			z.setRight(x);
		g.setLeft(x.rightPtr());
		p.setRight(x.leftPtr());
		x.setRight(g);
		x.setLeft(p);		
	}
	private void fixRL(boolean l, AVLNode z, AVLNode g, AVLNode p, AVLNode x) {
		if(l)
			z.setLeft(x);
		else
			z.setRight(x);
		g.setRight(x.leftPtr());
		p.setLeft(x.rightPtr());
		x.setLeft(g);
		x.setRight(p);			
	}
	private int max(int a, int b) {
		if(a <= b) {
			return b;
		}
		else {
			return a;
		}
	}
	private void print(AVLNode n) {
		if(debug) {
			System.out.println("ParentKey: " + n.key());
			if(n.leftPtr() != null)
				System.out.println("LeftKey: " + n.leftPtr.key());
			else
				System.out.println("LeftKey: null");
			if(n.rightPtr() != null)
				System.out.println("RightKey: " + n.rightPtr.key());
			else
				System.out.println("RightKey: null");
		}
	}
	public void debug(boolean b) {
		debug = b;
	}
	/*
	 * AVLNode is added as a class inside the tree as it is a 
	 * component of the tree, where the tree is accessed in order 
	 * to retrieve information of nodes, the nodes should
	 * never be accessed directly so are private.
	 */
	private class AVLNode {
		private String key; // (ISBN number)
		private Book value; //create a class representing a book with minimum attributes
		private int height;
		private AVLNode leftPtr;
		private AVLNode rightPtr;
		
		public void setLeft(AVLNode n) {
			leftPtr = n;
		}
		public void setRight(AVLNode n) {
			rightPtr = n;
		}
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
		public String key() {
			return key;
		}
	}
		
			
}