
public class Book {
	// properties
	String title;
	String author;
	int ISBN;
	int pageCount;
	boolean isCheckedOut;// whether it is checked out
	int dayCheckedOut = -1;
	
	// constructor
	public Book(String title, String author, int pageCount, int ISBN) {
		this.title = title;
		this.author = author;
		this.pageCount = pageCount;
		this.ISBN = ISBN;
		this.isCheckedOut = false;
	}
	
	// Getters
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public int getPageCount() {
		return this.pageCount;
	}
	
	public int getISBN() {
		return this.ISBN;
	}
	
	public boolean getIsCheckedOut() {
		return this.isCheckedOut;
	}
	
	public int getDayCheckOut() {
		return this.dayCheckedOut;
	}
	
	// setters
	public void setIsCheckedOut(boolean isNewCheckedOut, int currentDayCheckedOut) {
		this.isCheckedOut = isNewCheckedOut;
		setDateCheckedOut(currentDayCheckedOut);
	}
	
	private void setDateCheckedOut(int date) {
		this.dayCheckedOut = date;
	}

	
	
}
