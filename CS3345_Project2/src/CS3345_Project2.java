public class CS3345_Project2{
	public static void main(String[] args) {
		testBook("books.txt");
	}
	public static void testBook(String fileName) {
		FileHandler file = new FileHandler(fileName);
	}
}