/**
 * ARRAYS IN JS
 * 
 * Arrays are very lightweight collections in JS
 * They function like hybrids of arrays and Lists in Java
 * They are UNTYPED -- you can put ANYTHING into an array
 * They also DO NOT have a fixed length!
 * They have lots of useful functions we can use to sort, cut up, etc.
 * They DO apply the same principles re: storing the same array in different variables
 * - i.e., if you store the same array in two variables and change the values in one, it will change it in the other as well
 */

// declaring an array
let myArray = [ 1, true, 'abc', null, undefined, [ 1, 2, 3 ], { id: 6 }];
console.log(myArray);

// access to individual slots is done via index bracket notation
console.log(myArray[2]);

myArray[2] = 'xyz';
console.log(myArray[2]);

// no fixed length!
// adding to the end -- push
myArray.push(1000);
console.log(myArray);

// removing from the end -- pop
console.log(myArray.pop());
console.log(myArray);

// adding to the beginning -- unshift
myArray.unshift(9999);
console.log(myArray);

// removing from the beginning -- shift
console.log(myArray.shift());
console.log(myArray);

let nums = [ 1, 2, 3, 4, 100, -3, 5, 6, 7, 8, 9, 3 ];

// getting the first index of a value
console.log(nums.indexOf(3));

// getting the last index of a value
console.log(nums.lastIndexOf(3));

// searching through to see if the array contains a certain value
console.log(nums.includes(6));
console.log(nums.includes(111));

// sorting the array by natural order
console.log(nums);
nums.sort();
console.log(nums);

// this behaves strangely with mixed types
myArray.sort();
console.log(myArray);

// you can use custom sort functions, too, just like with Comparable/Comparator
nums.sort((a, b) => a - b);
console.log(nums);

// copying arrays and inserting/removing values are made easier via slice and splice
let numbers = [ 1, 2, 3 ];
let otherNumbers = numbers;

console.log(numbers);
console.log(otherNumbers);

// this changes the value in BOTH arrays
numbers[0] = 10;

console.log(numbers);
console.log(otherNumbers);

// like this, slice will make a copy of the entire array, separated from the original
otherNumbers = numbers.slice(0);

console.log(numbers);
console.log(otherNumbers);

numbers[0] = 99;

console.log(numbers);
console.log(otherNumbers);

// with slice and a single parameter, it will copy ALL the array indices from that index (inclusive) forward
// with two parameters, the second is the ending index (exclusive)
let n = [ 5, 6, 7, 8, 9 ];
let o = n.slice(1, 3);

console.log(n);
console.log(o);

// splice allows insertion and or removal of one or more elements at any spot in the array

// with two parameters, the first is the starting index (inclusive), and second is the number of slots to delete
// removing only
n.splice(1, 2);
console.log(n);

// with three or more parameters, the first is the starting index, the second is the number of slots to remove
// all the others, however many there are, are elements to be added
// adding only
n.splice(1, 0, 11, 12, 13);
console.log(n);

// adding AND removing
n.splice(2, 2, 0, 1);
console.log(n);

// this can get tricky...
// we'll talk about the ... (the spread operator, as opposed to the rest operator) on Monday!
n.splice(3, 0, ...n.splice(2, 2));
console.log(n);

