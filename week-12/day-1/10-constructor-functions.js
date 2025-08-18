/**
 * CONSTRUCTOR FUNCTIONS
 * 
 * JS uses something called prototypical inheritance, passing properties and methods between object using prototypes
 * However, there are MUCH simpler and easier to understand syntaxes we can use
 * Important, though, to remember, that types/objects are really just functions! 
 * 
 * We can create a function to return objects of a certain type over and over
 */

// a constructor function
// when we use the this keyword inside the function, it turns it into a constructor function
function Moose(color, gender, age) {
    this.color = color;
    this.gender = gender;
    this.age = age;
}

// to use it, use the new keyword to instantiate an object of type Moose
const moose = new Moose('Manny', 'Male', 12);
console.log(moose);

const otherMoose = new Moose('Minnie', 'Female', 13);
console.log(moose);
console.log(otherMoose);