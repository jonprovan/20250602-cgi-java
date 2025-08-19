/**
 * ASYNC-AWAIT AND OTHER ASYNCHRONOUS FUNCTIONS IN JS
 * 
 * Since JS is single-threaded, anything that's asynchronous goes onto the Event Loop
 * It's put to the side and will only be executed when there is space in the sync code
 * Two types of things go on the event loop -- callback functions and Promises
 * 
 * Callback Functions = functions to be executed after a certain period of time, like setTimeout and setInterval
 * Promises = represent the eventual success/failure of an async operation like an API call
 * - whenever our React app reaches out to our backend, it will return a Promise
 * 
 * Order of priority = Sync Code > Promises > Callback Functions
 * 
 * Promises also have the ability to be error-handled -- you can include different behavior for a successful response vs. a failed one
 * 
 * The fetch API, which we'll use here, returns Promises
 * In React, we'll be using Axios, which is actually an abstraction layered over fetch, and it returns Promises, too
 * 
 * Lastly, we can control whether or not sync code will wait until after an async operation completes before running
 * This can only be done via async functions and the await keyword
 */

// some callback functions

// setTimeout executes a function (the callback function) after a certain period of time
// the first parameter of setTimeout is the function you want to execute after the time stated
// the second parameter is the time to wait in milliseconds
// setTimeout(() => {
//     console.log('Timeout Returned!');
// }, 0);

// if there is never a space in the sync code, like here with this infinite loop
// the timeout will NEVER return
// this is true for ALL async operations
// for (;;) {}

// if sync code takes a while, async ops will come back after it's done, even if it's later than the timeout said it should be!
// for (let i = 0; i < 10000; i++)
//     for (let i = 0; i < 10000; i++)
//         for (let i = 0; i < 10000; i++)
//             i = Math.pow(i, i);

// order
setTimeout(() => {
    console.log('Timeout Returned!\n\n');
}, 0);

// if we have a Promise in the event loop, ready to come back, it will go to the front of the line
Promise.resolve('Promise Resolved!').then(message => console.log(message));

// note that this executes first, then the Promise, then the timeout
console.log('Sync Code Executed!');

// setInterval is like setTimeout, except it does the callback function EVERY <time interval>
// it will continue to do it until the interval is canceled
// same parameter structure
// here, we're also using arguments after the time interval
// all other args entered afterward will be collected using the rest operator, so you can add local variables like this counter
// const interval = setInterval(() => {
//     console.log(`Interval Counter = ${counter++}`);
//     if (counter === 4) clearInterval(interval); // clearing the interval after a certain number of iterations, since counter is only local
// }, 1000, counter = 0);

// clearInterval will stop the iteration of an interval, but you need to store the interval in something first
// setTimeout(() => {
//     clearInterval(interval);
//     console.log('Interval Cleared!');
// }, 5200);

// manually creating a Promise with resolve/reject
const promise = new Promise((resolve, reject) => {
    const random = Math.random();

    if (random > 0.5)
        resolve('Number Greater than 0.5!');
    else
        reject('Number LESS than 0.5...');
})

// just like a Promise from an HTTP request, the Promise stays a Promise until we unpack it, find out if it was successful, and do something with the data
// we can account for all possibilities with then/catch/finally
// then = contains a callback function to execute if the Promise was resolved
// - this is what will handle a 100-, 200-, or 300-level HttpResponse
// catch = contains a callback function to execute if the Promise was rejected
// - this is what will handle a 400- or 500-level HttpErrorResponse
// finally = contains a no-args callback function to execute after then OR catch, regardless of success/failure
promise.then(data => {
    console.log(data);
}).catch(error => {
    console.log('An error occured:', error);
}).finally(() => {
    console.log('Promise Handled, for better or for worse.');
})

// the fetch API is a simple, clean way to request data from a source on the web
// in React, we'll use Axios, which is another syntax but the same functionality

// a get request
// fetch('https://reqres.in/api/users', {
//     method: 'GET',
//     headers: {
//         'x-api-key': 'reqres-free-v1'
//     }
// }).then(response => {
//     return response.json();
// }).then(json => {
//     json.data.forEach(element => {
//         console.log(element.email);
//     });
// })

// if we want to control when sync code is happening relative to our API calls, we must use async/await
// a function can be designated as async, and then, within it, we can use the keyword await
// await will force following sync code to wait until the async action is done
// also, await returns and unpacks the promise generated, so we can store it in a variable if we want

// you designate a function as async
async function getAllUsers() {
    // then you can use the await keyword on an async operation to force any following sync code to wait for completion
    await fetch('https://reqres.in/api/users', {
        method: 'GET',
        headers: {
            'x-api-key': 'reqres-free-v1'
        }
    }).then(response => {
        return response.json();
    }).then(json => {
        json.data.forEach(element => {
            console.log(element.email);
        });
    });

    // this will no longer happen until the fetch and its handling are complete
    console.log('Fetch Complete!');
}

// you can also declare an async function like this
const register = async () => {

    // JS objects will often look this way in your program
    const body = {
        username: 'george.bluth@reqres.in',
        email: 'george.bluth@reqres.in',
        password: 'abcde'
    }

    // we can assign the result of the fetch operation to a variable
    // this doesn't do much for error handling, though
    const response = await fetch('https://reqres.in/api/register', {
        method: 'POST',
        headers: {
            'x-api-key': 'reqres-free-v1',
            // this particular API requires this header for any request with a body
            // it needs to know the incoming body object is JSON
            // you may or may not need it with other applications
            'Content-Type': 'application/json'
        },
        // the body object will then need to be JSON.stringified to work with fetch (not an issue with Axios)
        body: JSON.stringify(body)
    })

    // we're assuming here that the first step worked okay
    const json = await response.json();

    console.log(json);
}

getAllUsers();
register();