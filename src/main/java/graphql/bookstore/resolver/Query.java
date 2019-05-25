package graphql.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.bookstore.model.Author;
import graphql.bookstore.model.Book;
import graphql.bookstore.model.Order;
import graphql.bookstore.repository.BookRepository;
import graphql.bookstore.repository.OrderRepository;
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
