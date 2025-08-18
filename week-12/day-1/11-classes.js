/**
 * CLASSES IN JS
 * 
 * Classes were added long after the original creation of JS
 * To make it easier for Java-based programmers to interact with the language
 * And to make inheritance and object construction more straightforward
 * A lot of this should seem familiar to you as Java folks
 */

// a class called Tea
class Tea {

    // properties
    name;
    type;
    
    // a private property for encapsulation purposes
    // add the # before the property name -- there's no private keyword in this context
    #intensity;

    // a static property
    static numberOfTeaObjects = 0;

    // constructor
    constructor(name, type, intensity) {
        this.name = name;
        this.type = type;
        this.#intensity = intensity;
        Tea.numberOfTeaObjects++;
    }

    // getter and setter for intensity
    // by using the keywords get and set
    // and by naming the method the same as the property name (without the #)
    // the user can just interact with variable AS IF IT WERE A REGULAR PROPERTY
    // this masks that validation may be going on
    // it also works great with legacy code, if you change a public property to private somewhere down the line
    get intensity() {
        return this.#intensity;
    }

    set intensity(intensity) {
        this.#intensity = intensity;
    }
}

// this class inherits from our Tea class
// just like Java, you CANNOT inherit from multiple classes, but many classes CAN inherit from one parent
// you can also continue extending in a chain as long as you like
class DecafTea extends Tea {

    fullyDecaffeinated;

    constructor(name, type, intensity, fullyDecaffeinated) {
        super(name, type, intensity);
        this.fullyDecaffeinated = fullyDecaffeinated;
    }

}

console.log(Tea.numberOfTeaObjects);

const tea1 = new Tea('Chamomile', 'Herbal', 0);

console.log(tea1);

console.log(Tea.numberOfTeaObjects);

console.log(tea1.intensity);
tea1.intensity = 1;
console.log(tea1.intensity);

const tea2 = new DecafTea('Raspberry Tea', 'Herbal', 3, true);

console.log(tea2);
console.log(Tea.numberOfTeaObjects);