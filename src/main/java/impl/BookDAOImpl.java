package impl; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.BookDAO;
import models.Book;
import utils.HibernateUtil;

public class BookDAOImpl implements BookDAO{

	public void insert(Book book) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Book book) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		
		final String update = "(updated)";
		book.setAuthor(book.getAuthor() + update);
		book.setDescription(book.getDescription() + update);
		book.setName(book.getName() + update);
		em.merge(book);
		
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Book book) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(book) ? book : em.merge(book));
		em.getTransaction().commit();
		em.close();
	}

	public List<Book> read() {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Book> list;
		Query query = em.createQuery("SELECT e FROM Book e");
		list = (List<Book>) query.getResultList();
		em.close();
		return list;
	}
	
}
