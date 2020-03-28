package sanjeev.practice.springboot.models;

public class Book {

	private String name;
	private float price;
	private String author;
	
	
	public Book(String name, float price, String author) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public String getAuthor() {
		return author;
	}
	
	
}
