package com.graphqljava.tutorial.bookdetails;

import com.coxautodev.graphql.tools.SchemaParser;
import com.graphqljava.tutorial.bookdetails.resolver.AuthorResolver;
import com.graphqljava.tutorial.bookdetails.resolver.Mutation;
import com.graphqljava.tutorial.bookdetails.resolver.OrderResolver;
import com.graphqljava.tutorial.bookdetails.resolver.Query;
import com.graphqljava.tutorial.bookdetails.scalar.Timestamp;
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
