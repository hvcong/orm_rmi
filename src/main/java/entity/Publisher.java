package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Publisher implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisherId")
	private long id;
	private String name;
	private String phonenumber;
	private String address;
	
	@ManyToMany(mappedBy = "publishers",cascade = {CascadeType.ALL})
	private List<Book> books = new ArrayList<Book>();
	
	public Publisher() {
		
	}

	public Publisher(long id, String name, String phonenumber, String address, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.books = books;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", books=" + books + "]";
	}
	
	

}
