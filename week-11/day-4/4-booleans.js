/**
 * BOOLEANS IN JS
 * 
 * we have the boolean type and its true/false values
 * 
 * we also have all the standard comparison and logical operators, like:
 * ==, <, >, <=, >=, !=
 * &&, ||, &, |, !
 * 
 * However, we have some new variations to pay attention to...
 */

console.log(3 == 3);
console.log('3' == '3');
// we'd think this wouldn't return true, but JS uses type 'coercion' to assess them as equal
// this is because it's browser-based and is looking to eliminate errors and keep things running
console.log(3 == '3');

// to solve this, we have === and !==
// these are called strict equality and strict inequality operators
console.log(3 === '3');
// equivalent to saying this:
console.log(3 == '3' && typeof 3 == typeof '3');

console.log(3 != '3');
console.log(3 !== '3');

// something else weird...
if (true) {
    console.log('true was true!');
}

if ('abc') {
    console.log('abc was true!');
}

if (!0) {
    console.log('!0 was true!');
}

/**
 * TRUTHY AND FALSY IN JS
 * 
 * ALL things in JS are either truthy or falsy
 * This means they either evaluate to a true boolean or a false boolean
 * 
 * FALSY VALUES
 * any version of 0 -- 0, -0, 0n, 0.0, etc.
 * any empty string -- '', "", ``
 * null
 * undefined
 * NaN
 * false
 * !true
 * 
 * TRUTHY VALUES
 * anything that's not falsy, including empty arrays and objects
 */

// ternary operators with truthy/falsy
let username = 'loggedIn' ? 'Joe' : 'Default';
console.log(username);

// some boolean shorthands
let namePosted = '';
// this will assign the first value to loggedInName if the first value is truthy; otherwise it'll assign the second one
let loggedInName = namePosted || 'Guest';

console.log(loggedInName);

namePosted = 'Germaine';
// this will assign the second value if the first is truthy
loggedInName = namePosted && 'Guest';

console.log(loggedInName);

let currentAmount = 0;

// this will never return currentAmount if it's 0, even though zero might be a value amount
// let total = currentAmount || 'No recorded balance';

// this uses the nullish coalescing operator
// it returns the first value, even if it's falsy, as long as it isn't null or undefined
// if it's null or undefined, it returns the second value
let total = currentAmount ?? 'No recorded balance';
console.log(total);