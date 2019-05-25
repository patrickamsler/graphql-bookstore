package graphq.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphq.bookstore.model.Order;
import graphq.bookstore.repository.BookRepository;
import graphq.bookstore.repository.OrderRepository;
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
