package com.graphqljava.tutorial.bookdetails.scalar;

import graphql.schema.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Timestamp implements Coercing {

    private final SimpleDateFormat dateFormat;

    private Timestamp() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static GraphQLScalarType buildScalar() {
        return GraphQLScalarType.newScalar()
                .name("Timestamp")
                .coercing(new Timestamp())
                .build();
    }

    @Override
    public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
        return this.dateFormat.format(dataFetcherResult);
    }

    @Override
    public Object parseValue(Object input) throws CoercingParseValueException {
        return serialize(input);
    }

    @Override
    public Object parseLiteral(Object input) throws CoercingParseLiteralException {
        try {
            return dateFormat.parse((String) input);
        } catch (ParseException e) {
            throw new CoercingParseLiteralException(e);
        }
    }
}
