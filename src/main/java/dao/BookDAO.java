package dao;

import java.util.List;

import models.Book;

public interface BookDAO {
	
	public void insert(Book book);
	
	public void update(Book book);
	
	public void delete(Book book);
	
	public List<Book> read();
}
