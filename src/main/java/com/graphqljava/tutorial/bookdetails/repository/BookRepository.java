package com.graphqljava.tutorial.bookdetails.repository;

import com.graphqljava.tutorial.bookdetails.model.Author;
import com.graphqljava.tutorial.bookdetails.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("book-1", "Harry Potter and the Philosopher's Stone", 223,
                new Author("author-1", "Joanne", "Rowling")));
        books.add(new Book("book-2", "Moby Dick", 635,
                new Author("author-2", "Herman", "Melville")));
        books.add(new Book("book-3", "Interview with the vampire", 371,
                new Author("author-3", "Anne", "Rice")));
    }

    public Book findById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
