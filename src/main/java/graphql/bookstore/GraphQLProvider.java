package graphql.bookstore;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.bookstore.resolver.AuthorResolver;
import graphql.bookstore.resolver.Mutation;
import graphql.bookstore.resolver.OrderResolver;
import graphql.bookstore.resolver.Query;
import graphql.bookstore.scalar.Timestamp;
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
