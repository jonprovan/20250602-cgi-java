/**
 * OBJECTS IN DEPTH
 * 
 * Last week, we laid out what basic objects look like
 * And discussed how they're lightweight and easy to work with
 * In addition to using dot/bracket notation to navigate these objects...
 * We can also ADD or REMOVE properties!
 * We can also-also store functions as properties very easily
 */

const person = {
    firstName: 'Marv',
    lastName: 'Klarv',
    age: 50,
    favoriteMovies: [
        'The Poseidon Adventure',
        'Elf',
        'Monty Python and the Life of Brian'
    ],
    sayHello: () => console.log('Hello!')
}

// accessing a property
console.log(person.firstName);

// changing a property
person.firstName = 'Marvin';
console.log(person.firstName);

// running a property function
person.sayHello();

// adding a property
person.middleName = 'Von';

console.log(person);

// removing a property
delete person.middleName;

console.log(person);

// dealing with nested objects
const student = {
    name: 'Biff',
    // teacher: {
    //     name: 'Ellen'
    // }
}

// if student.teacher exists, this works just fine
// console.log(student.teacher.name);

// however, if student.teacher is undefined, when we call for teacher.name, we get JS's version of a NullPointerException
// so, we can use the optional chaining operator (a ? before the dot)
// this indicates to ONLY call for name if teacher exists
console.log(student.teacher?.name);


// object equality is not straightforward in JS
// there's no shorthand or method to make this easy
// some external libraries (like Lodash) have methodology for this
// without those, you just have to write some method that does it for you
const person2 = {
    firstName: 'Marvin',
    lastName: 'Klarv',
    age: 50
}

console.log(checkEquality(person, person2));

function checkEquality(one, two) {
    if (one.firstName === two.firstName
        && one.lastName === two.lastName
        && one.age === two.age)
        return true;
    else
        return false;
}