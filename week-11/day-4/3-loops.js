/**
 * LOOPS IN JS
 * 
 * loops are exactly the same as in Java, except the enhanced for with object
 * 
 * we have:
 * 
 * while
 * do-while
 * standard for
 * enhanced for
 */

// while
console.log('While Loop:');
let counter = 0;

while (counter < 5) {
    console.log(counter++);
}

// do-while
console.log('\nDo-While Loop:');
counter = 0;

do {
    console.log(counter++);
} while (counter < 0);

// standard for
// note that we instantiate the index with let, not a type like in Java -- don't use const!
console.log('\nStandard For Loop:');

for (let i = 0; i < 5; i++) {
    console.log(i);
}

// enhanced for
console.log('\nEnhanced For Loop:');

const nums = [ 1, 2, 3, 4, 5 ];

// for a regular enhanced for with an iterable array, use let <variable name> of <array name>
for (let num of nums) {
    console.log(num);
}

// objects are NOT iterable, so the above approach doesn't work
const person = {
    name: 'John',
    age: 30,
    city: 'New York'
}

// objects are enumerable, not iterable
// let <variable name> in <object name> enumerates the object
// put another way, it sort of turns the object into an array temporarily
// but this just returns the property names/keys, not their values
for (let prop in person) {
    console.log(prop);
}

// to get the values, we can use the property names/keys to access the values
// think of enumeration as temporarily turning our object into something more like a HashMap
// sort of like for (String key : map.keySet())
for (let prop in person) {
    console.log(`Property Name: ${prop}, Property Value: ${person[prop]}`);
}

// a nested example
const products = [
    { id: 1, name: 'Laptop', price: 999.99 },
    { id: 2, name: 'Phone', price: 499.99 },
    { id: 3, name: 'Tablet', price: 299.99 }
];

for (let product of products) {
    console.log('\nProduct:');
    for (let prop in product) {
        console.log(`Property Name: ${prop}, Property Value: ${product[prop]}`);
    }
}