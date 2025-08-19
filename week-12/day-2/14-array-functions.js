/**
 * ARRAY FUNCTIONS IN JS
 * 
 * Many Java Stream API functions are available for use on arrays in JS
 * We do not need streams for this and can operate directly on arrays
 * Syntax and functionality are almost entirely the same for:
 * 
 * forEach
 * map
 * filter
 * reduce
 */

const nums = [ 1, 2, 3, 4, 5 ];

// forEach -- takes each element, does something, returns nothing
const forEachOutput = nums.forEach(element => {
    console.log(element * element);
})

// this DOES NOT return anything!
console.log(forEachOutput);

// map -- takes each element, does something, return something to an outgoing array
// we'll see this A LOT in React as we take DB responses and map them to HTML elements
const mapOutput = nums.map(element => {
    console.log(element + 2);
    return element * element;
})

console.log(mapOutput);

// filter -- takes each element, determines if it meets criteria, then returns it to an outgoing array if it does
// can be VERY useful for conditional display of different elements based on user choices/filters/dropdowns, etc.
const filterOutput = nums.filter(element => {
    if (element % 2 !== 0)
        return true;
    else return false;
})

console.log(filterOutput);

// reduce -- takes all the elements and returns a single value
// you can include a starting/accumulator value, just like in Java
// however, it comes AFTER the callback function, not before
// and, regardless of inclusion, you will get some value, not an Optional
const names = [ 'Abe', 'Meredith', 'Johnny', 'Mo', 'Lauren' ];

const reduceOutput = names.reduce((first, second) => {
    if (first.length > second.length)
        return first;
    else
        return second;
}, 'K')

console.log(reduceOutput);