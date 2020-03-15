import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
	
	// properties
	Map<String, Book> bookCollection = new HashMap<String, Book>();
	int currentDay = 0;
	int checkoutPeriodLength = 21;
	double lateFeeInitial = 0.50;
	double lateDayFee = 0.30;
	
	
	// constructor
	public LibraryCatalogue(Map<String, Book> collection) {
		this.bookCollection = collection;
	}
	
	public LibraryCatalogue(Map<String, Book> collection, int checkoutPeriodLength, double lateFeeInitial, double lateDayFee) {
		this.bookCollection = collection;
		this.checkoutPeriodLength = checkoutPeriodLength;
		this.lateFeeInitial = lateFeeInitial;
		this.lateDayFee = lateDayFee;
	}
	
	// getters
	public int getCurrentDay() {
		return this.currentDay;
	}
	
	public Map getBookCollection() {
		return this.bookCollection;
	}
	
	public Book getBook(String title) {
		return this.bookCollection.get(title);
	}
	
	public int getCheckoutPeriodLength() {
		return this.checkoutPeriodLength;
	}
	
	public double getLateFeeInitial() {
		return this.lateFeeInitial;
	}
	
	public double getLateDayFee() {
		return this.lateDayFee;
	}
	
	// setters
	public void setNextDay() {
		this.currentDay++;
	}
	
	public void setDay(int day) {
		this.currentDay = day;
	}
	
	// instance methods
	public void checkOutBook(String title) {
		Book book = getBook(title);
		if(book.getIsCheckedOut()) {
			alreadyCheckedOut(book);
		} else {
			book.setIsCheckedOut(true, currentDay);
			System.out.println("You just checked out the book: " + title 
					+ ". Due day is: " + (getCurrentDay() + getCheckoutPeriodLength()));
		}
	}
	
	public void returnBook(String title) {
		Book book = getBook(title);
		int lateDays = getCurrentDay() - book.getDayCheckOut() - getCheckoutPeriodLength();
		if (lateDays > getCheckoutPeriodLength()) {
			System.out.println("You should pay $" + (lateDays * getLateFeeInitial() + 
					getLateFeeInitial()) + " to the library for " + lateDays 
					+ " days overdue.");
		} else {
			System.out.println("You returned " + title + " . Thank you.");
		}
		book.setIsCheckedOut(false, -1);
	}
	
	public void alreadyCheckedOut(Book book) {
		System.out.printf("Sorry, \"%s\" is already checked out. It might be back on the day: %d. Current day is %d%n" , book.getTitle()  
				, book.getDayCheckOut() + getCheckoutPeriodLength(), getCurrentDay());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Book> bookCollection = new HashMap<String, Book>();
		Book javaBeginner = new Book("Java: A Beginner’s Guide", "Herbert Schildt", 720, 978-1260440218);
		bookCollection.put("Java: A Beginner’s Guide" , javaBeginner);
		
		LibraryCatalogue library = new LibraryCatalogue(bookCollection);
		library.checkOutBook("Java: A Beginner’s Guide");
		library.setNextDay();
		library.checkOutBook("Java: A Beginner’s Guide");
		library.setDay(19);
		library.checkOutBook("Java: A Beginner’s Guide");
		library.setNextDay();
		library.setNextDay();
		library.checkOutBook("Java: A Beginner’s Guide");
		library.returnBook("Java: A Beginner’s Guide");
		library.checkOutBook("Java: A Beginner’s Guide");
	}

}
