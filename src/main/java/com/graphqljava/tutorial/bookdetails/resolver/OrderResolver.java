package com.graphqljava.tutorial.bookdetails.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqljava.tutorial.bookdetails.model.Book;
import com.graphqljava.tutorial.bookdetails.model.Order;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

    @Autowired
    private BookRepository bookRepository;

    public Book book(Order order) {
        return bookRepository.findById(order.getBookId());
    }
}
