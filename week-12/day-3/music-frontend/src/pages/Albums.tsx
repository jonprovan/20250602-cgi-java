import { useEffect, useState } from "react"
import { getAllAlbums } from "../api/api";
import { Album } from "../components/Album";

export const Albums = () => {

    const [ albums, setAlbums ] = useState([
        {
            id: 0,
            albumName: '',
            releaseYear: 0,
            artists: [
                {
                    id: 0,
                    artistName: ''
                }
            ]
        }
    ]);

    const getAll = async () => {
        await getAllAlbums().then(response => setAlbums(response.data));
    }

    // useEffect is a hook that allows us to take action whenever the state of something changes, whatever we wish to "watch"
    // the first parameter is a callback function to execute
    // the second parameter is an array of things to "watch"
    // if the array is empty, it will run ONCE on component load
    // if there's NO array, it'll run whenever ANYTHING rerenders
    // or, you can place whatever state variables you want in the array to watch those
    // put simply, here, this gets all albums when you go to the page!
    useEffect(() => {
        getAll();
    }, [])

    // a function to move an album we click on to the top of the list
    // the id will be sent up from the child component
    const moveToTop = (id: number) => {
        const newOrder = albums.slice(0);
        const index = newOrder.findIndex(album => album.id === id);
        const albumToMove = newOrder.splice(index, 1)[0];
        newOrder.unshift(albumToMove);
        setAlbums(newOrder);
    }

    return (
        <main>
            <h1>ALBUMS</h1>
            <h2>Albums in the Database</h2>
            {albums.map(album => {
                return (
                    // here, we're creating an individual component for each album
                    // in the state array
                    // we pass down the album object as a property (parent-to-child)
                    // the property name on the left is whatever we want to call it in the child component
                    // the value in the curly braces is whatever we have HERE that we want to pass down
                    // "key" is not a property!
                    // we're passing our function down to be able to run the
                    // moveToTop functionality from the child
                    <Album key={album.id}
                           albumProp={album}
                           moveToTopFunction={moveToTop} />
                )
            })}
        </main>
    )

}