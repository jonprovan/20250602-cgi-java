import { useState } from "react";
import { getAllLabels } from "../api/api"

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
    function addLabelsToTable() {
        getAllLabels().then(response => setLabels(response.data));
    }

    return (
        <main>
            <h1>LABELS</h1>
            <h2>Record Labels in the Database</h2>
            
            {/* when triggering a function from a click, use a lambda
                if you just type the function name with no parentheses, it works...
                BUT, you don't have the option to insert parameters
                So use the lambda!! */}
            <button onClick={() => addLabelsToTable()}>Get All Labels</button>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Label Name</th>
                        <th>Label History</th>
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
                                    <td>{ label.labelHistory.history }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>

        </main>
    )

}