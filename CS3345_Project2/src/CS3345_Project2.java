import java.util.*;

/*
 * Just a driver for the different parts, takes "books.txt"
 * tells FileHandler to turn it into a list of books, then 
 * makes a tree and tells it to insert each book
 */
public class CS3345_Project2{
	public static void main(String[] args) {
		doPartOne();
		doPartTwo();
	}
	public static void doPartOne() {
		FileHandler list = new FileHandler("books.txt");
		AVL_Tree tree = new AVL_Tree();
		list.debug(false);
		tree.debug(false);
		for(int i = 0; i < list.length(); i++) {
			tree.insert(list.getBook(i));
		}
		tree.printTree();
		tree.printInOrder();
		
	}
	public static void doPartTwo() {
		Random rand = new Random();
		int r;
		RandomTree tree = new RandomTree();
		for(int i = 0; i < 30; i++) {
			r = rand.nextInt(10000);
			tree.insert(r);
		}
		tree.printTree();
		tree.printInOrder();
	}
}