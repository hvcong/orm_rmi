package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.SessionFactory;

import entity.Book;
import utils.HibernateUtils;

public interface Book_dao extends Remote {
	public List<Book> getAllBook() throws RemoteException;
	public void addBook(Book b) throws RemoteException;
	public void deleteBook(int bookId) throws RemoteException;
	public List getByName(String name) throws RemoteException;
	public Book findById(int id) throws RemoteException;
	public void update(Book b) throws RemoteException;
}
