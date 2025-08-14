/*
    DATA TYPES IN JS

    Numeric Data Types:
    - number -- most numbers you'll use will be this type, including whole numbers AND decimals
    - bigint -- for very large numbers, impractical for most uses

    Alphanumeric Data Types
    - string -- any and all text, whether it's a single character or more or even an empty string

    Other Types:
    - boolean -- true/false values
    - null -- intentional absence of any value, shows up as object when getting type but is its own thing
    - undefined -- variable declared but not assigned a value
    - object -- complex data structures, INCLUDING ARRAYS AND FUNCTIONS
    - symbol -- unique and immutable value, often used as object keys

*/

console.log(typeof 123);
console.log(typeof 'abc');
// making this a bigint by adding an n at the end
console.log(typeof 123123123123123123123123123123123123123123123123123123n);
console.log(typeof false);
console.log(typeof null);
console.log(typeof undefined);
console.log(typeof { name: 'John', age: 30 });
console.log(typeof [ 3, 4, 5 ]);
console.log(typeof Symbol('X'));
// one of my favorite little JS quirks
console.log(typeof NaN);

let variable = 'xyz';
console.log(typeof variable);

