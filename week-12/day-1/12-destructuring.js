/**
 * DESTRUCTURING IN JS
 * 
 * It can often be helpful to "take apart" an array or object into its indices/properties
 * We can then refer to them with simple variable names
 * We can insert them easily into other arrays or objects
 * This economizes syntax greatly in many instances
 */

const student = {
    advisor: {
        name: 'Nancy The Advisor',
        courses: [
            {
                name: 'JS 101',
                students: [
                    'Marjorie',
                    'Justin',
                    'Brent'
                ]
            }
        ]
    }
}

// objects can be complex and require a lot of syntax to dig through
console.log(student.advisor.courses[0].students[2]);

const names = [ 'Al', 'Annie', 'Aretha' ];

// this takes the values for the first three slots in the array and assigns them to these variables in order
// note the spread operator on the righthand side
// if we just said const [first, second, third] = names
// we'd link the variables to the actual array values, and if we changed on, we'd change the others!
// usually, with object destructuring, you want to decouple the variables from the original array
// when destructuring arrays, the variable names DO NOT MATTER!
const [ first, second, third ] = [ ...names ];
console.log(first);

// to only grab some of the values
const [ fourth, fifth ] = [ ...names ];

console.log(fifth);

// just skip ones you don't need!
const [ sixth, , seventh] = [ ...names ];

// in JS, a console.log of multiple values with a comma between them will print both with a space between them
console.log(sixth, seventh);

// destructuring the students array
const [ studentA, studentB, studentC ] = [ ...student.advisor.courses[0].students ];
console.log(studentB);

// destructuring objects
const plant = {
    name: 'Audrey II',
    diet: 'Humans',
    mission: 'World Conquest'
}

// for objects, use curly braces on both sides instead of brackets!
const { diet, name, mission } = { ...plant };

console.log(diet);

// for objects, the names MUST MATCH EXACTLY!
// however, the order does not matter (see above)
const { fullName, regularDiet, intent } = { ...plant };

console.log(fullName);

// you can also use the spread operator to INSERT elements in to arrays or properties into objects
const nums = [ 3, 4, 5, 6, 7 ];

// inserting individual values from the array as new slots in this array
nums.splice(3, 0, ...[11, 12, 13]);
console.log(nums);

// inserting individual properties from another object as properties in this object
const myPlant = {
    price: 1.99,
    shopLocation: 'Wholesale Flower District',
    ...plant
}

console.log(myPlant);