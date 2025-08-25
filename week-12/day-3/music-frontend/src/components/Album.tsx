// this component takes in properties
// properties ALWAYS come in as an object, 
// so each property you pass in will be a property of that object

import { useContext } from "react"
import type { AlbumType } from "../types/types"
import { FavoriteContext } from "../context/FavoriteContext"
import { useNavigate } from "react-router";

// you must type properties coming in like this
// this says that the albumProp property MUST be an AlbumType and have all its fields, etc.
// we're also taking in the moveToTopFunction from the parent
// the function WILL RUN IN THE PARENT when we click the button -- it's not present here
// we have to do this because the state for the albums array IS NOT HERE
// we only have access to THIS album
export const Album = ({ albumProp, moveToTopFunction }: 
                        // when typing the albumProp, we use our custom type
                        // when typing the function, we lay out its structure
                      { albumProp: AlbumType, moveToTopFunction: (id: number) => void }) => {

    // we don't need the first element in the array (favorite), so we skip it!
    const [ , setFavorite ] = useContext(FavoriteContext);

    // setting up useNavigate, which is a hook for site navigation
    // you can point to other pages from buttons, within functions etc
    const navigate = useNavigate();

    return (
        <section className="album">

            <h3>{albumProp.id}: {albumProp.albumName}</h3>
            <h4>{albumProp.releaseYear}</h4>
            <p>Artists:</p>
            <ul>
                {/*
                    Here, we're dynamically displaying an li with Unknown
                    if the artists array is empty
                    using our JS boolean shorthand,
                    the && operator will return the thing on the right
                    if the thing on the left returns true/truthy
                    here, if the artists array is empty, that's falsy, we "not it"
                    then it's truthy, and we'll return the thing on the right
                */}
                {!albumProp.artists.length && <li>Unknown</li>}
                {/* this is another way of doing the same thing, perhaps more readable */}
                {/* {albumProp.artists.length === 0 && <li>Unknown</li>} */}
                {albumProp.artists.map(artist => {
                    return (<li key={artist.id}>{artist.artistName}</li>)
                })}
            </ul>
            {/* when clicking this button, it sends this album's id to the 
                moveToTopFunction function */}
            <button onClick={() => moveToTopFunction(albumProp.id)}>Move To Top</button>
            <button onClick={() => setFavorite(albumProp.albumName)}>♥</button>
            {/* using useNavigate here to take us to the update page for this album via dynamic id */}
            <button onClick={() => navigate(`/albums/update/${albumProp.id}`)}>Update</button>

        </section>
    )

}