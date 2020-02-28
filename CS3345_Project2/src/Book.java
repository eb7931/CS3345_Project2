public class Book{
	private boolean debug = true;
	private String ISBN = "";
	private String title = "";
	private String author = "";
	private String seed = "";
	/*
	 * I set the ISBN, title, and author last name by starting from
	 * line start until the first space for ISBN, from the end until
	 * last space for author, then assume everything between the first
	 * and last space is the title. The title will often include spaces
	 * and we have the format
	 * ISBN<space>Title<space>Author
	 * So this assume ISBN and author contain no spaces but title may.
	 */
	public Book(String line){
		seed = line;
		String reverseAuthor = "";
		int titleStart = 0;
		int titleEnd = line.length()-1;
		while(line.charAt(titleStart) != ' ') {
			ISBN += line.charAt(titleStart);
			titleStart++;
		}
		titleStart++;
		while(line.charAt(titleEnd) != ' ') {
			reverseAuthor += line.charAt(titleEnd);
			titleEnd--;
		}
		for(int i = reverseAuthor.length() - 1; i >= 0; i--) {
			author += reverseAuthor.charAt(i);
		}
		for(int i = titleStart; i < titleEnd; i++) {
			title += line.charAt(i);
		}
		if(debug) {
			print();
		}
	}
	private void print() {
		System.out.println(seed);
		System.out.println(ISBN);
		System.out.println(title);
		System.out.println(author);
	}
	public String key() {
		return ISBN;
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
}