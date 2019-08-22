package services;

import java.util.List;

import impl.BookDAOImpl;
import models.Book;

public class BookService {
	private BookDAOImpl bookDAOImpl = new BookDAOImpl();
	private static List<Book> list;
	
	public BookService() {
		
	}
	
	public void insertBook(Book book) {
		bookDAOImpl.insert(book);
		System.out.println("The book is inserted in DB successfully!");
		readBooks();
	}
	
	public void deleteBook(Book book) {
		bookDAOImpl.delete(book);
		System.out.println("The book is deleted from DB successfully!");
		readBooks();
	}
	
	public void readBooks() {
		list = bookDAOImpl.read();
	}
	
	public void printBooks() {
		if (list != null) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		else {
			System.out.println("List is empty!");
		}
	}
	
	public void updateBook(Book book) {
		bookDAOImpl.update(book);
		System.out.println("The book is updated in DB successfully!");
		readBooks();
	}
	
	public void filterBookByAuthor(String author) {
		readBooks();
		list.stream().filter(x -> x.getAuthor().equals(author)).forEach(System.out::println);
	}
}
