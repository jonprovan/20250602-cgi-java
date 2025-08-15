/**
 * FUNCTIONS IN JS
 * 
 * functions in JS are basically the same as methods in Java -- both words mean the same thing
 * i.e., something you can call to do something
 * 
 * JS Key Differences:
 * since JS is loosely typed, parameters CANNOT be typed
 * also, there ARE NO RETURN TYPES -- if the function returns something, whatever that is is the return type
 * also, there is no such thing as overloading!
 * and, most of the time, since we're often not using a class structure, there's no overriding, either!
 * 
 * one other thing is that it's very easy to treat functions as variables, i.e., store them, pass them in/out of other functions, etc.
 */

// declaring a function
// note that functions, however they're declared, are fully and propertly hoisted
// so, we can call them before and/or after they're declared
printSomething();

function printSomething() {
    console.log("Here's a thing that I printed.");
}

printSomething();

// another way to declare a function
const printSomethingElse = function () {
    console.log("Here's something else I printed.");
}

printSomethingElse();

// yet another way, common to React, as we'll see
const printAnotherThing = () => {
    console.log("Here's another thing I printed.");
}

// note that the functions are being stored in the variable names
console.log(printAnotherThing);
// you need the parentheses to actually run the function
printAnotherThing();

// taking in parameters
// we don't provide types, but the order still matters
function addTwoNumbers(x, y) {
    console.log(x);
    console.log(y);
    console.log('Sum = ' + (x + y));
}

// this works great with numbers...
// but since the parameters are untyped, be careful!!
// you may need some logic checks to validate variable types
addTwoNumbers(3, 7);
addTwoNumbers('3', 7);
addTwoNumbers('James', 'Jill')
addTwoNumbers({}, []);

// returning something
// note the lack of return type
// note also that this function returns DIFFERENT types, depending on what happens!
function returnSomething() {
    const random = Math.random();

    if (random > 0.75)
        return;
    else if (random < 0.25)
        return 'Low Number';
    else
        return random;
}

console.log(returnSomething());

// overloading...???
function add(x, y, z) {
    console.log(x + y + z);
}

function add(x, y) {
    console.log(x + y);
}

// we expect 3 and 6 here but get 3 and 3
add(1, 2);
add(1, 2, 3);

// this is because the functions are stored in variables (add), and the second one overwrites the value of the first
// we CAN redeclare variables in JS, unlike in Java...look below!
var v = 5;
var v = 7;

// there's no real overloading, but there are some tricks we can use!
// here, we're giving x and default values to use if the user doesn't provide them
function addAll(x = 10, y, z = 0) {
    console.log(x + y + z);
}

addAll(1, 2, 3);
addAll(1, 2);
// this is the same as:
addAll(1, 2, undefined);
// we can also "skip" a parameter by using undefined, and it will use its default value if it has one
addAll(undefined, 5);

// you can set default values based on the values of PREVIOUS parameters
function calculateArea(width, height = width) {
    console.log('Area = ' + (width * height));
}

// if it's a rectangle, we want to put in two numbers
calculateArea(5, 4);
// if it's a square, we want to just put in one
calculateArea(5);

// how do we add up ANY number of numbers and get a sum?
// we can use the rest operator!
// the rest operator takes all remaining arguments and inserts them into an array
// if there ARE NO remaining arguments, you'll still get an empty array
// you can only have ONE rest operator per parameter set
// AND it MUST be last!
function sumUpAllNumbers(x, y, ...z) {
    console.log(x);
    console.log(y);
    console.log(z);

    let sum = x + y;
    for (let num of z)
        sum += num;

    console.log(sum);
}

sumUpAllNumbers(1, 2, 3, 4, 5, 6, 7);

// the rest operator CAN be the only thing in the parameter list
function sumUpAllNumbersSimpler(...z) {
    console.log(z.reduce((a, b) => a + b));
}

sumUpAllNumbersSimpler(1, 2, 3, 4, 5);