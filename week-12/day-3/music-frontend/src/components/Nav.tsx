import { useContext } from "react"
import { Link } from "react-router"
import { FavoriteContext } from "../context/FavoriteContext"

export const Nav = () => {

    // in this component, we're merely taking in a value from the context's state
    // useContext(<context name>) pulls in the context
    // we desconstruct the array to pull out what we want
    const [ favorite ] = useContext(FavoriteContext);

    return (
        <nav>
            {/* <a href="/home">Home</a>
            <a href="/labels">Labels</a>
            <a href="/artists">Artists</a>
            <a href="/albums">Albums</a>
            <a href="/songs">Songs</a> */}

            {/* to use our Router properly, instead of using a tags, we'll use React's Link
                routing this way DOES NOT refresh the overall HTML page
                it just places the content for the route into the Outlet in the Frame */}
            <Link to={'/'}>Home</Link>
            <Link to={'/labels'}>Labels</Link>
            <Link to={'/artists'}>Artists</Link>
            <Link to={'/albums'}>Albums</Link>
            <Link to={'/songs'}>Songs</Link>
            {/* we now have direct access to the context's state,
                whenever it changes, it'll be reflected here */}
            {favorite && <span>Fave = {favorite}</span>}
        </nav>
    )

}