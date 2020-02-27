import java.io.*;
/*
 * purpose of this class is to receive a file name and output a list
 * of books, the book function is responsible for interpreting the
 * string/line as a book object however. After initialization, this class
 * will represent a given file and the associated book objects
 */

class FileHandler{
	public Book[] books;
	public FileHandler(String fileName) {
		String line = "";
		int c;
		try {
			File file = new File(fileName);
			FileReader in = new FileReader(file);
			int i = 0;
			while((c = in.read()) != -1) {
				if((char)c == '\n') {
					books[i] = new Book(line);
					line = "";
					i++;
				}
				else {
					line += (char)c;
				}
			}
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public Book[] getBooks() {
		return books;
	}
	public Book getBook(int i) {
		return books[i];
	}
}