start application: `gradle bootRun`
GraphQL: `http://localhost:8080/graphql`

Query books
```
{
    bookById(id: "book-1") {
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```
