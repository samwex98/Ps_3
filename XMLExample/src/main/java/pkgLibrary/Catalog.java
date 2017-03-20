package pkgLibrary;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book GetBook(String Bookid) throws BookException{
		try {
			for (Book b: this.getBooks())
				
			{
				if (b.getId().equals(Bookid))
					return b;
			}
			
			throw new BookException(this, Bookid);
		} catch (BookException BE) {
			throw BE;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	
	public void AddBook(Book b) throws BookException{
		try {
			for (Book catBook: this.getBooks())
				
			{
				if (b.getId().equals(catBook.getId()))
				{
					throw new BookException(this, b);
				}
			}
		
			
		} catch (BookException BE) {
			throw BE;
		}
		catch (Exception e)
		{
			throw e;
		}
		
		this.getBooks().add(b);
		
	}
	
}
