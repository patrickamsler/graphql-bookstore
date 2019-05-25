#GraphQL Bookstore

start application: `gradle bootRun`

GraphQL endpoint: `http://localhost:8080/graphql`

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
