import models.Book;
import services.BookService;

public class Runner {
	public static void main(String[] args) {
		BookService bs = new BookService();
		
		Book b1 = new Book("Fahrenheit 451", "R. Bradbury", "fiction");
		Book b2 = new Book("Murder on the Orient Express", "A. Christie", "detective");
		Book b3 = new Book("I, Robot", "I. Asimov", "ficiton");
		Book b4 = new Book("Advance Grammar in Use", "B. Hewings", "education");
		
		bs.insertBook(b1);
		bs.insertBook(b2);
		bs.insertBook(b3);
		bs.insertBook(b4);

		bs.printBooks();
		System.out.println("-------------------------------------");
		
		bs.updateBook(b4);
		bs.printBooks();
		
		System.out.println("-------------------------------------");
		
		bs.deleteBook(b4);
		bs.printBooks();
		
		System.out.println("-------------------------------------");
		System.out.println("Check method filter:");
		bs.filterBookByAuthor("A. Christie");
	}
}
