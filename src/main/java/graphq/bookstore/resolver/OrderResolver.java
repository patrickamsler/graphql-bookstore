package graphq.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphq.bookstore.model.Book;
import graphq.bookstore.model.Order;
import graphq.bookstore.repository.BookRepository;
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
