import { Link } from "react-router"

export const Nav = () => {

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
        </nav>
    )

}