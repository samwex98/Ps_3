package pkgLibrary;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class CatalogTest {

	@Test
	public void testGetBook() {
		boolean bool = false;
		Catalog cat = ReadXMLFile();
		try {
			Book b = cat.GetBook("bk101");
			if(b.getId().equals("bk101"))
					bool = true;
		} catch (BookException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find " + e.getBookID());
		} catch (Exception e){
			e.printStackTrace();
		}
		assertEquals(bool,true);
	}

	@Test
	public void testGetBook2() {
		boolean bool = false;
		Catalog cat = ReadXMLFile();
		try {
			Book b = cat.GetBook("bk991");
			if(b.getId().equals("bk101"))
					bool = true;
		} catch (BookException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find " + e.getBookID());
		} catch (Exception e){
			e.printStackTrace();
		}
		assertEquals(bool,false);
	}
	@Test
	public void testAddBook() {
		boolean bool = false;
		Catalog cat = ReadXMLFile();
		int size = cat.books.size();
		Date d = new Date();
		Book newBook = new Book("bk101", "Gambardella, Mathew", "XML Developer's Guide", "Computer", 42.00, d, "stuff", 69.69);
		try {
			cat.AddBook(newBook);
		} catch (BookException e) {
			System.out.println("Book already exists with id " + e.getBookID());
		}catch (Exception e){
			e.printStackTrace();
		}
		WriteXMLFile(cat);
		cat = ReadXMLFile();
		if(cat.getBooks().size()==size){
			bool = true;
		}
		assertEquals(bool, true);
	}
	
	@Test
	public void testAddBook2() {
		boolean bool = false;
		Catalog cat = ReadXMLFile();
		int size = cat.books.size();
		Date d = new Date();
		Book newBook = new Book("bk991", "Gambardella, Mathew", "XML Developer's Guide", "Computer", 42.00, d, "stuff", 69.69);
		try {
			cat.AddBook(newBook);
		} catch (BookException e) {
			System.out.println("Book already exists with id " + e.getBookID());
		}catch (Exception e){
			e.printStackTrace();
		}
		WriteXMLFile(cat);
		cat = ReadXMLFile();
		if(cat.getBooks().size()==size){
			bool = true;
		}
		assertEquals(bool, false);
	}
	
	private Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
	private void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
