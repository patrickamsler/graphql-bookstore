#GraphQL Bookstore
Spring boot GraphQL example application.
The application uses [graphql-java-tools](https://github.com/graphql-java-kickstart/graphql-java-tools) 
with a [schema-first](src/main/resources/schema.graphql) development approach.

Build the application: `gradle build`

Start the Spring boot application: `gradle bootRun`

Access GraphQL endpoint: `http://localhost:8080/graphql`

##Queries
 
All books
```
query {
  allBooks {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```
Find book by id
```
query {
  bookById(id: "book-2") {
    	name
    }
}
```
All authors
```
query {
  allAuthors {
      firstName
      lastName
      books {
        name
      }
    }
}
```
## Mutation
Create order
```
mutation {
  createOrder(bookId: "book-2" ) {
    id
    orderDate
    book {
      id
      name
    }
  }
}
```
