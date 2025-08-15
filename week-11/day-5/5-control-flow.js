/**
 * CONTROL FLOW IN JS
 * 
 * All the tools from Java work here as well:
 * 
 * if
 * else
 * else if
 * switch
 */

// if
if (5 < 6) {
    console.log('5 is less than 6');
}

if (9 < 8)
    console.log('7 is less than 8');

console.log('This line is "outside the braces" for the second if.');

// else
if (7 > 10)
    console.log('7 is greater than 10');
else
    console.log('7 is NOT greater than 10');

// else if
let myName = 'Francois';

if (myName === 'Charlie')
    console.log('Hi, Charlie!');
else if (myName === 'Francois')
    console.log('Hi, Francois!');
else
    console.log('Who dis?');

// switch
// syntax is exactly the same as Java
// however, you CAN switch on a boolean in JS, since variables aren't typed
// you can ALSO have cases of different types for the same reason
let myNum = 11;

switch (myNum) {
    case 10:
        console.log('Too Low!');
        break;
    case 11:
        console.log('Just Right!');
        break;
    case 12:
        console.log('Too High!');
        break;
    case true:
        console.log('It was a boolean!');
        break;
    default:
        console.log('Huh?');
        break;
}