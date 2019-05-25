package com.graphqljava.tutorial.bookdetails.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.tutorial.bookdetails.model.Order;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import com.graphqljava.tutorial.bookdetails.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(String bookId) {
        if (bookRepository.findById(bookId) == null) {
            throw new IllegalStateException("Invalid bookId " + bookId);
        }

        return orderRepository.createOrder(bookId);
    }
}
