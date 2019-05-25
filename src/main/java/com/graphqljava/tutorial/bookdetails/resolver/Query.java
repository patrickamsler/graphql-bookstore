package com.graphqljava.tutorial.bookdetails.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookdetails.model.Author;
import com.graphqljava.tutorial.bookdetails.model.Book;
import com.graphqljava.tutorial.bookdetails.model.Order;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import com.graphqljava.tutorial.bookdetails.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;


    public Book bookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> allBooks() {
        return bookRepository.getAllBooks();
    }

    public List<Author> allAuthors() {
        return bookRepository.getAllAuthors();
    }

    public Order orderById(String id) {
        return orderRepository.findOrderById(id);
    }
}
