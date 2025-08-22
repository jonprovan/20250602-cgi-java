import { useState } from "react";
import { getAllLabels, deleteLabelById, createLabel } from "../api/api"
import { useForm, type SubmitHandler } from "react-hook-form";

export const Labels = () => {

    // this component, like all components, manages its own state
    // state = the values of variables stored locally
    // in order for things on the page to reflect things in the state
    // we use React's useState hook
    // useState creates a tracked variable and a method for changing it
    // whenever we change the variable, ANYTHING using it will update
    // this uses array destructuring
    // first one = the variable to hold the state, second one = the method to set it
    // you can include a default starting value in the parentheses
    const [ labels, setLabels ] = useState([
        {
            id: 10,
            labelName: 'Test Label Name',
            labelHistory: {
                history: 'Test History'
            }
        }
    ]);

    // you can include functions inside your component for local use
    function getAll() {
        getAllLabels().then(response => setLabels(response.data));
    }

    function deleteOne(id: number) {
        deleteLabelById(id).then(() => getAll());
    }

    // a multi-use function to sort the labels in different ways
    // note the typed parameter here, something we couldn't do in plain JS
    function sortLabels(type: string) {
        if (type === 'id') {
            // deconstructing our state to sort it
            const idSortedLabels = [ ...labels ];
            // using a custom sort to sort by id, in this case
            // syntax is similiar to a custom comparator in Java
            // when we're looking at an element, if we want it to move "to the left"
            // we need to return a negative value
            idSortedLabels.sort((labelOne, labelTwo) => labelOne.id - labelTwo.id);
            setLabels(idSortedLabels);
        }

        if (type === 'name') {
            // shorthand version
            // .localeCompare is the JS equivalent to Java's compareTo for strings
            setLabels([ ...labels ].sort((labelOne, labelTwo) => 
                labelOne.labelName.localeCompare(labelTwo.labelName)));
        }

        // our previous version of this didn't work if labels don't have a history
        // here, we're replacing the "undefined" result for labels with no history
        // with 'ZZZ' which will sort last
        if (type === 'history') {
            setLabels([ ...labels ].sort((labelOne, labelTwo) => 
                (labelOne.labelHistory?.history || 'ZZZ')
                .localeCompare(labelTwo.labelHistory?.history || 'ZZZ')));
        }
            
    }

    /**
     * Setting up react-hook-form
     * this package provides an easy-to-use framework for dynamic, reactive forms
     * as the user enters input, we can give them live feedback
     * it's straightforward to set up requirements for fields,
     * block form submission until the fields meet the requirements, etc.
     * 
     * it does involve a little setup...
     */

    // set up a type that includes all the fields you want on your form
    // when the form submits, its data will be an object matching this structure
    type Inputs = {
        labelName: string;
    }

    // useForm comes from the react-hook-form package
    // we deconstruct everything we need from there
    // register = allows us to register input with the hook
    // handleSubmit = allows us to validate submission before sending
    // formState = contains various live properties of the form
    // - in our case, we want to know if there are any errors 
    //   and if the overall form is valid
    // lastly, you type the useForm hook with your Inputs type
    // with no mode in the options block, you'll only get feedback after attempted submit
    // with 'all', you'll get feedback immediately if you
    // edit, click in and out, tab in and out, submit, etc.
    // reset lets us clear the form inputs
    const { register, handleSubmit, formState: { errors, isValid }, reset } = useForm<Inputs>({
        mode: 'all'
    });

    // this handler will use the form validation when you submit
    // the onSubmit variable has this specific type
    // the variable in the lambda can be called whatever you want,
    // but it will be automatically filled with the submitted form data
    const onSubmit: SubmitHandler<Inputs> = formData => {
        createLabel(formData).then(() => getAll());
        // calling the hook's reset to blank the form out after submission
        reset();
    }

    return (
        <main>
            <h1>LABELS</h1>

            {/* here's our actual react-hook-form on the page */}
            {/* we use the handleSubmit method from the hook, giving it our handler */}
            <form onSubmit={handleSubmit(onSubmit)}>
                <h3>Create a New Label</h3>
                {/* if you want to connect your labels to fields, use htmlFor
                    "for" is a reserved keyword in React */}
                
                <div>
                    <label htmlFor="labelName">Label Name: </label>
                    {/*
                        we register each field with the hook form
                        the first parameter of register is the field name,
                        which MUST match with the one in the type
                        the second parameter of register is all the validation
                    */}
                    <input id="labelName" {...register('labelName', {
                        required: {
                            value: true,
                            message: 'Label Name is required!'
                        },
                        minLength: {
                            value: 3,
                            message: 'Label Name must be at least 3 characters!'
                        },
                        maxLength: {
                            value: 20,
                            message: 'Label Name must be at most 20 characters!'
                        }
                    })} />
                    {/* we can use the errors object to see if there are errors for a field,
                    then dynamically show that information if the error exists */}
                    {errors.labelName && <span className="error">{errors.labelName.message}</span>}
                </div>
                
                {/* we can use isValid to disable the form if there are ANY errors
                    in ANY field */}
                <input type="submit" disabled={!isValid} />
            </form>

            <h2>Record Labels in the Database</h2>
            
            {/* when triggering a function from a click, use a lambda
                if you just type the function name with no parentheses, it works...
                BUT, you don't have the option to insert parameters
                So use the lambda!! */}
            <button onClick={() => getAll()}>Get All Labels</button>
            <button onClick={() => sortLabels('id')}>Sort By ID</button>
            <button onClick={() => sortLabels('name')}>Sort By Name</button>
            <button onClick={() => sortLabels('history')}>Sort By History</button>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Label Name</th>
                        <th>Label History</th>
                        <th>Delete?</th>
                    </tr>
                </thead>

                <tbody>
                    {/* to loop through an array and display something for each one
                        map is the easiest route
                        for each label in the labels state array, create a tr
                        we then dynamically pass data to the tds based on the current label 
                        
                        React will ask you to add a unique key to each looped element
                        This is so it can identify which elements have changed
                        for the purpose of rerendering them
                        you'll often use the id for DB elements, because it's already unique
                    */}
                    {
                        labels.map(label => {
                            return (
                                <tr key={ label.id }>
                                    <td>{ label.id }</td>
                                    <td>{ label.labelName }</td>
                                    {/* if a label is added with no labelHistory,
                                        this line will crash the app because 
                                        we're trying to get the history prop of a null
                                        so we can use the optional chaining operator here */}
                                    <td>{ label.labelHistory?.history }</td>
                                    <td>
                                        <button onClick={() => deleteOne(label.id)}>X</button>
                                    </td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>

        </main>
    )

}