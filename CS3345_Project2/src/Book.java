public class Book{
	private String ISBN;
	private String title;
	private String author;
	public String key() {
		return ISBN;
	}
	public void setAuthor(String a) {
		author = a;
	}
	public void setTitle(String t) {
		title = t;
	}
	public Book(String i){
		ISBN = i;
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
}