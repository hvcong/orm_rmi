package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.Book_dao;
import entity.Book;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import utils.HibernateUtils;

public class BookImpl  extends UnicastRemoteObject  implements Book_dao {

	SessionFactory sessionFactory = null;

	public BookImpl()  throws RemoteException {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List getAllBook() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tr = null;

		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			List<Book> list = session.createQuery("from Book", Book.class).list();
			tr.commit();
			return list;

		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
			tr.rollback();

		}
		return null;
	}

	@Override
	public void addBook(Book b) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			session.save(b);
			System.out.println("save book ok");
			tr.commit();

		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();

		}
	}

	@Override
	public void deleteBook(int bookId) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();

			Book b = session.get(Book.class, bookId);
			if (b != null) {
				session.delete(b);
			}

			tr.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();

		}

	}

	@Override
	public List getByName(String name) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();

			Query query = session.createQuery("from Book u where u.name=:name", Book.class);
			query.setParameter("name", name);
			List list = query.getResultList();

			tr.commit();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();

		}

		return null;
	}

	@Override
	public Book findById(int id) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();

			Query query = session.createQuery("from Book u where u.id=" + id, Book.class);
			Book book = (Book) query.getSingleResult();

			tr.commit();
			return book;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();

		}

		return null;
	}

	@Override
	public void update(Book b) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();

			session.merge(b);
			tr.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("err update");
			e.printStackTrace();
			tr.rollback();

		}

	}

}
