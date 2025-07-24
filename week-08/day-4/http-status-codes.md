# HTTP STATUS CODES
- when a server responds to a client, it will return an HttpResponse
- the response includes any information the user asked for
- it also includes various headers describing the response
- it also includes an HTTP Status Code
    - this describes what happened with the request in a general sense
    - it also dictates whether the response is considered:
        - a standard HttpResponse
        - an HttpErrorResponse
    - these are also just standard fare for APIs, and they're expected by people using our API

## Status Code Categories
- status codes run between 100 and 599
- they fall into five categories based on range:
    - 100-199 = Informational Responses
    - 200-299 = Successful Responses
    - 300-399 = Redirect Responses
    - 400-499 = Client Error
    - 500-599 = Server Error

### Distinguishing Between Client and Server Error
- client error encompasses MOST of the errors in well-functioning web applications
    - looking for a resource that doesn't exist (404)
    - not being properly authenticated (401)
    - being forbidden by permissions (403)
- server error is only when something's going wrong internally
    - DB crash
    - DB request conflict/constraint issue
    - not being able to find a Spring Bean the application needs

## Common Codes
- 200 OK -- GET requests, PUT requests, POST requests that don't create new DB records (login, for example)
- 201 Created -- POST requests that create DB records
- 204 No Content -- DELETE requests

- 400 Bad Request -- something about the structure of the request was incorrect (body object, etc.)
- 401 Unauthorized -- incorrect login credentials
- 403 Forbidden -- correct login credentials, but insufficient permissions
- 404 Not Found -- the resource the user wanted does not exist

- 500 Internal Server Error -- something went wrong in the app
- 502 Bad Gateway -- one microservice tried to access another, and it didn't get a response

### Status Codes Reference
https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status