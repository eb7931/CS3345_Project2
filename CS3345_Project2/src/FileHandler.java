import java.io.*;
/*
 * purpose of this class is to receive a file name and output a list
 * of books, the book function is responsible for interpreting the
 * string/line as a book object however. After initialization, this class
 * will represent a given file and the associated book objects
 */

class FileHandler{
	public Book[] books;
	private int arrayLength = 10;
	private int numBooks = 0;
	public FileHandler(String fileName) {
		String line = "";
		int c;
		books = new Book[arrayLength];
		try {
			File file = new File(fileName);
			FileReader in = new FileReader(file);
			int i = 0;
			while((c = in.read()) != -1) {
				if((char)c == '\n') {
					addBook(i, line);
					line = "";
					i++;
					//c = in.read();
				}
				else if((char)c == '\r') {
					
				}
				else {
					line += (char)c;
				}
			}
			addBook(i, line);
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private void addBook(int i, String s) {
		if(i == arrayLength)
			expandList();	
		books[i] = new Book(s);
		numBooks++;
	}
	private void expandList() {
		Book[] temp = new Book[arrayLength*2];
		for(int i = 0; i < arrayLength; i ++) {
			temp[i] = books[i];
		}
		arrayLength *= 2;
		books = temp;
	}
	public Book[] getBooks() {
		return books;
	}
	public Book getBook(int i) {
		return books[i];
	}
	public int length() {
		return numBooks;
	}
}