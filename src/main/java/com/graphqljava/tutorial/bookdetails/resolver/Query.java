package com.graphqljava.tutorial.bookdetails.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.tutorial.bookdetails.model.Author;
import com.graphqljava.tutorial.bookdetails.model.Book;


public class Query implements GraphQLQueryResolver {


    public Book bookById(String id) {
        Author author = new Author("2348", "Herman", "Melville");
        return new Book("123", "Moby Dick", 653, author);
    }
}
