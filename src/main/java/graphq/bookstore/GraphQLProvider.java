package graphq.bookstore;

import com.coxautodev.graphql.tools.SchemaParser;
import graphq.bookstore.resolver.AuthorResolver;
import graphq.bookstore.resolver.Mutation;
import graphq.bookstore.resolver.OrderResolver;
import graphq.bookstore.resolver.Query;
import graphq.bookstore.scalar.Timestamp;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GraphQLProvider {

    @Autowired
    private Query query;
    @Autowired
    private Mutation mutation;
    @Autowired
    private OrderResolver orderResolver;
    @Autowired
    private AuthorResolver authorResolver;

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() { 
        return graphQL;
    }

    @PostConstruct
    public void init() {
        GraphQLSchema graphQLSchema = buildSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(query, mutation, orderResolver, authorResolver)
                .scalars(Timestamp.buildScalar())
                .build()
                .makeExecutableSchema();
    }
}
