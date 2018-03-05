package models;


import java.util.HashSet;
import java.util.Set;

public class Book {

    public int id;
    public String title;
    public int price;
    public String author;

    public Book (int id, String title, int price, String author){

        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Book (){}

    private static Set<Book> books;

    static {
        books = new HashSet<>();
        books.add(new Book(1,"C++",20,"ABC"));
        books.add(new Book(2,"Java",30,"XYZ"));
    }

    public static Set<Book> getAllBooks(){
        return books;
    }

    public Book findById(int id){

        for (Book book:books) {
            if (id == book.id)
                return book;
        }
        return null;
    }

    public static void add(Book book){
        books.add(book);
    }

    public static boolean remove(Book book){
        return books.remove(book);
    }

}
