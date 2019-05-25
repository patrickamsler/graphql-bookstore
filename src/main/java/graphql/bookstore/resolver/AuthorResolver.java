package graphql.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.bookstore.model.Author;
import graphql.bookstore.model.Book;
import graphql.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> books(Author author) {
        return bookRepository.findBooksByAuthor(author.getId());
    }
}
