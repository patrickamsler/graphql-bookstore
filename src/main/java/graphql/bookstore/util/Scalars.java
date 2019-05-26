package graphql.bookstore.util;

import graphql.schema.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Scalars {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public final static GraphQLScalarType TIME_STAMP = GraphQLScalarType.newScalar()
                .name("Timestamp")
                .coercing(new Coercing() {
                    @Override
                    public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
                        return DATE_FORMAT.format(dataFetcherResult);
                    }

                    @Override
                    public Object parseValue(Object input) throws CoercingParseValueException {
                        return serialize(input);
                    }

                    @Override
                    public Object parseLiteral(Object input) throws CoercingParseLiteralException {
                        try {
                            return DATE_FORMAT.parse((String) input);
                        } catch (ParseException e) {
                            throw new CoercingParseLiteralException(e);
                        }
                    }
                }).build();
}
