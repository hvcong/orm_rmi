package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.Book_dao;
import entity.Author;
import entity.Book;
import entity.Publisher;
import utils.HibernateUtils;

public class Main {
	public static void main(String[] args) throws RemoteException {
		Author a = new Author();
		
		Publisher p = new Publisher();
		Publisher p1 = new Publisher();
//		Set<Publisher> set = new HashSet<Publisher>();
//		set.add(p1);
//		set.add(p);
		Book b = new Book(1, "les miserables", 100, 1860, a);
		b.addPublisher(p);
		b.addPublisher(p1);

		Book_dao bookDao = null;
		try {
			
			bookDao = (Book_dao) Naming.lookup("rmi://localhost:3001/book");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		bookDao.getByName("les miserables");
		Book b3=null;
		try {
			b3 = bookDao.findById(5);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b3.getName());
		
		b3.setName("333");
		bookDao.update(b3);
		
		Book b4 = bookDao.findById(5);
		System.out.println(b4.getName());
		
//		bookDao.deleteBook(3);
//		Book b5 = bookDao.findById(3);
//		System.out.println(b3.getName());
		
//		bookDao.addBook(b);
//		List<Book> list =  bookDao.getAllBook();
//		
//		for(Book book : list) {
//			System.out.println(book.getAuthor().getName());
//		}
		
	}
}
