import java.util.*;

public class RandomTree{
	public Node head = null;
	public void insert(int i) {
		if(head == null){
			head = new Node(i);
		}
		else 
			insert(i, head);
	}
	private void insert(int i, Node n) {
		Random rand = new Random();
		boolean left = false;
		if(rand.nextInt(2) == 0)
			left = true;
		if(left)
			if(n.leftPtr() == null)
				n.setLeft(i);
			else
				insert(i, n.leftPtr());
		else
			if(n.rightPtr() == null)
				n.setRight(i);
			else
				insert(i, n.rightPtr());
	}
	public void printTree() {
		System.out.print(head.toString());
	}
	public void printInOrder() {
		printInOrder(head);
	}
	public void printInOrder(Node n) {
		if(n.leftPtr != null) {
			printInOrder(n.leftPtr());
		}
		System.out.println(n.key() + " Height: " + n.getHeight());
		if(n.rightPtr() != null) {
			printInOrder(n.rightPtr());
		}
	}
	
	private class Node{
		int key;
		Node leftPtr;
		Node rightPtr;
		private int height;
		private List<Node> children;
	    public String toString() {
	        StringBuilder buffer = new StringBuilder(50);
	        print(buffer, "", "");
	        return buffer.toString();
	    }    
	    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
	    	children = new ArrayList<>();
	    	if(leftPtr != null)
	    		children.add(leftPtr);
	    	if(rightPtr != null)
	    		children.add(rightPtr);
	    	buffer.append(prefix);
	        buffer.append(key);
	        buffer.append('\n');
	        for (Iterator<Node> it = children.iterator(); it.hasNext();) {
	            Node next = it.next();
	            if (it.hasNext()) {
	                next.print(buffer, childrenPrefix + "|__ ", childrenPrefix + "|   ");
	            } else {
	                next.print(buffer, childrenPrefix + "\\__ ", childrenPrefix + "    ");
	            }
	        }
	    }
		private int max(int a, int b) {
			if(a <= b) {
				return b;
			}
			else {
				return a;
			}
		}
	    private int getHeight() {
	    	height = max(leftHeight(), rightHeight()) + 1;
	    	return height;
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
	    private int key() {
	    	return key;
	    }
		private Node(int i) {
			key = i;
		}
		private Node leftPtr() {
			return leftPtr;
		}
		private Node rightPtr() {
			return rightPtr;
		}
		private void setLeft(int i) {
			setLeft(new Node(i));
		}
		private void setLeft(Node n) {
			leftPtr = n;
		}
		private void setRight(int i) {
			setRight(new Node(i));
		}
		private void setRight(Node n) {
			rightPtr = n;
		}
	}
}