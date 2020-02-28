/*
 * Just a driver for the different parts, takes "books.txt"
 * tells FileHandler to turn it into a list of books, then 
 * makes a tree and tells it to insert each book
 */
public class CS3345_Project2{
	public static void main(String[] args) {
		FileHandler list = new FileHandler("books.txt");
		AVL_Tree tree = new AVL_Tree();
		tree.debug(true);
		for(int i = 0; i < list.length(); i++) {
			tree.insert(list.getBook(i));
		}
	}
}