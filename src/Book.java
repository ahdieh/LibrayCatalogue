
public class Book {
	// properties
	String title;
	int ISBN;
	int pageCount;
	boolean isCheckedOut;// whether it is checked out
	int dateCheckedOut = -1;
	
	// constructor
	public Book(String title, int pageCount, int ISBN) {
		this.title = title;
		this.pageCount = pageCount;
		this.ISBN = ISBN;
		this.isCheckedOut = false;
	}
	
	// Getters
	public String getTitle() {
		return this.title;
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
	
	// setters
	public void setIsCheckedOut(boolean isNewCheckedOut, int currentDateCheckedOut) {
		this.isCheckedOut = isNewCheckedOut;
		setDateCheckedOut(currentDateCheckedOut);
	}
	
	private void setDateCheckedOut(int date) {
		this.dateCheckedOut = date;
	}

	
	
}
