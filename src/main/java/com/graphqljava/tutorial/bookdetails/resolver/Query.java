package com.graphqljava.tutorial.bookdetails.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookdetails.model.Book;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;


    public Book bookById(String id) {
        return bookRepository.findById(id);
    }
}
