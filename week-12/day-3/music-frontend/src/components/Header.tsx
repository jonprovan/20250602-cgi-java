import { Nav } from "./Nav"

// another way to structure the exporting of a component
export const Header = () => {

    return (
        <>
            <header>
                MUSIC API FRONTEND
            </header>
            
            <Nav />
        </>
    )

}