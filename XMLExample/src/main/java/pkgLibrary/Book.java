package pkgLibrary;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private Date publish_date;
	private String description;
	private double Cost;

	public Book() {

	}

	public Book(String id, String author, String title, String genre, double price, Date publish_date, String description, double Cost)
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;
		this.Cost = Cost;
	}
	
 

	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getCost(){
		return Cost;
	}
	
	@XmlElement
	public void setCost(double Cost){
		this.Cost = Cost;
	}
	
	
	
	public static Book GetBook(Catalog cat, String Bookid) throws BookException{
		try {
			for (Book b: cat.getBooks())
				
			{
				if (b.getId() == Bookid)
					return b;
			}
			
			throw new BookException(cat, Bookid);
		} catch (BookException BE) {
			throw BE;
		}
		catch (Exception e)
		{
			throw e;
		}
	}


}
