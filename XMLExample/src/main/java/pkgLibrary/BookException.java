package pkgLibrary;

public class BookException extends Exception{
	
	private Catalog cat;
	private Book b;
	private String BookID;
	public BookException(Catalog cat, String bookID) {
		super();
		this.cat = cat;
		BookID = bookID;
	}
	public BookException(Catalog cat, Book b) {
		super();
		this.cat = cat;
		this.b = b;
	}
	public Catalog getCat() {
		return cat;
	}
	public Book getB() {
		return b;
	}
	public String getBookID() {
		return BookID;
	}
	
	

}
