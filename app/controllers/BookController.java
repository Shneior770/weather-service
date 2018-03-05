package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.books.*;


import javax.inject.Inject;
import java.util.Set;

public class BookController extends Controller {

    @Inject
    private FormFactory formFactory ;


    //to showing all books
    public Result index(){
        Set<Book> books = Book.getAllBooks();
        return ok(index.render(books));
    }

    //to save book
    public Result show(int id){
        return TODO;
    }


    //to create book
    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    //to save book
    public Result save(){
        return TODO;
    }

    //to edit a book by providing his id
    public Result edit(int id){
        return TODO;
    }

    //to update a book
    public Result update(){
        return TODO;
    }

    //to delete a book
    public Result destroy(int id){
        return TODO;
    }
}
