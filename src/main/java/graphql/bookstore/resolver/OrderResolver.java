package graphql.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.bookstore.model.Book;
import graphql.bookstore.model.Order;
import graphql.bookstore.repository.BookRepository;
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
