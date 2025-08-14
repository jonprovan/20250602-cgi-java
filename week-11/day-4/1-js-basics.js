/*
    JAVASCRIPT

    JavaScript is the default scripting language for use in web browsers
    Also used for some backend servers (Express, Nest.js, etc.)
    It's also the foundation for various frontend frameworks (React, Angular, Vue.js, etc.)

    JavaScript is single-threaded, which comes up with async operations like API calls
    Usually, JS, is run by the browser
    We'll run it for testing purposes using Node.js, which is a JS runtime for running code without a browser
    Node.js also will run our React server

    JavaScript has many similarities with Java, but there are a few oddities we need to know about

    JS is loosely-typed, which means we can reassign variables with whatever types and values we want
    Also, JS is NOT compiled; it is simply interpreted by the browser at runtime
    So, you won't see many checked errors and can often run into issues without noticing them ahead of time
*/

// What you see above is a multi-line comment in JavaScript
// these are single-line comments

// console.log is the equivalent of System.out.println in Java
// when running via Node, they'll print in the terminal
// in a real-world environment, they'll print to the browser's console
console.log("Hello, World!");
console.log('Also single quotes');
console.log(`Backticks also work`);

// variables in JS
/*
    there are three ways to declare variables in JS -- var, let, and const
    var = global variable
    let = block-scoped variable
    const = block-scoped constant
*/

// bottom line = use let and const, DO NOT use var
// the declaration of x is "hoisted," meaning it happens at the beginning and can be accessed even before it shows up in the code
// however, its value is not assigned until later
console.log(x);
console.log(y);

var x = 11;
console.log(x);

if (true) {
    if (true) {
        if (true) {
            var y = 50;
        }
    }
}

console.log(y);

// let behaves how we would expect
// this will actually throw an error, because the variable is not hoisted and doesn't exist yet
// console.log(z);

let z = 44;
console.log(z);

z = 100;
console.log(z);

if (true) {
    let a = 'abc';
}

// can't do this, either, because a is block-scoped and no longer exists
// console.log(a);

// const is like final
// you CAN change object properties or array values, you just can't reassign the overall variable
const b = 99;
console.log(b);

// can't do this -- it will throw an error
// b = 199;
// console.log(b);

const c = [ 1, 2, 3, 4, 5 ];
console.log(c);

c[2] = 123;
console.log(c);

const d = {
    id: 1,
    name: 'Fred Pickles'
}

console.log(d);
d.id = 2;
d.name = 'Frederick Pickles';

console.log(d);

// semicolons after JS statements are OPTIONAL unless you want to put two statements on the same line
console.log('Animal')
console.log('First'); console.log('Second')

// variables can hold values of ANY type
// in JS, the variable itself is NEVER typed
// the values have types
let variable = 42;
console.log(variable);

variable = 'Hello, World!';
console.log(variable);

variable = [ 3, 4, 5 ];
console.log(variable);

variable = { key: 'value' };
console.log(variable);