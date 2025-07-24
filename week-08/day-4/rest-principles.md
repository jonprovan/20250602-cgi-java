# REST PRINCIPLES

## What is REST?
- REST = REpresentational State Transfer
- state is the current data we're looking at
    - in our database, state is represented as a record in a table, with columns for properties, etc.
    - in our Spring Boot (Java) application, state is represented as a Java Object
    - in between our Spring Boot application and our fronted, state is represented as a JSON object
        - JSON = JavaScript Object Notation
    - in our React frontend application, state is represented as a JavaScript object
- we transfer state between these types
- our REST API, in a very broad sense, transfers state from database records into, eventually, JSON
- in full-stack applications, generally-speaking, REST APIs comprise the backend

## The 6 REST Principles
- Client-Server Structure
    - client = any computer making a request
    - server = any server responding to a request
    - mainly, this structure is to separate concerns
    - primarily, to separate the user interface (visuals, etc.) from the backend functionality

- Uniform Interface
    - endpoints should be structured in a consistent and sensible way
    - there are some best practices for this
    - but regardless of whether you follow them exactly, there should be a consistency across your API
        - GET <baseurl>/albums
        - GET <baseurl>/artists
        - GET <baseurl>/songs
        - GET <baseurl>/artists/{id}
        - GET <baseurl>/artists/{id}/songs
        - GET <baseurl>/labels/{id}/artists
        - POST <baseurl>/artists
    - in addition to uniformity of endpoints, you should also return other uniform characteristics
        - the data structure for each artist should be the same
        - the structure of the response should be the same for a given endpoint whether there are many items, one, or none
        - HTTP response/status codes

- Stateless Architecture
    - the REST API does not remember or keep ANY information on state from EITHER side
    - it does not hold any database information OR session information about the client
    - each request to the API is totally independent from ALL others, including previous ones from the same client
    - as such, each request MUST contain ALL information required to process that request AS IF IT WERE THE FIRST EVER REQ!
        - URL
        - any body information (form data, JSON objects, other information)
        - any and all required headers
        - all authentication data

- Layered Architecture
    - within the actual application, we want to split up concerns as well
    - the app will have separate layers, each of which cares about only a certain type of functionality
    - other functionality is left to the other layers
    - one good example of this is the MVC pattern (see whiteboard PDF)
    - another is the Entity/Repository/Service/Controller structure we'll use in Spring Boot

- Cacheable
    - the API can state whether or not a particular resource should be cacheable

- Code On Demand
    - REST APIs can serve up code snippets/applets that can be run on client-side