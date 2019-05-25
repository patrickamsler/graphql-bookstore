package com.graphqljava.tutorial.bookdetails.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqljava.tutorial.bookdetails.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

}
