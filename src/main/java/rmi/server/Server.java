package rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import impl.BookImpl;

public class Server {
	public static void main(String[] args) {
		try {

			Registry rgsty = LocateRegistry.createRegistry(3001);

			// rebind stub
			BookImpl book_dao = new BookImpl();

			rgsty.rebind("book", book_dao);

			System.out.println("Rebind stub ok!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
