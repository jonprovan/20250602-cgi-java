import { useEffect, useState } from "react"
import { getAllArtists } from "../api/api";

export const Artists = () => {

    // if you set up a type in advance, like this, you can use it for your useState
    type Artist = {
        id: number;
        artistName: string;
        label: {
            id: number;
            labelName: string;
        }
        albums: []
    }

    // this syntax says that artists will hold an Artist[] ONLY!
    // you can't assign anything to artists that's not an Artist[]
    // then, you don't have to bother with a default value, just a blank initial array
    const [ artists, setArtists ] = useState<Artist[]>([]);

    const getAll = () => {
        getAllArtists().then(response => {
            setArtists(response.data);
        }).catch(err => {
            console.log(err);
        })
    }

    // remember that, if you want this to ONLY happen on page load, use an empty array
    // as the second parameter -- with no parameter, it will update infinitely
    // it changes the state of artists, which will then trigger another useEffect, etc.
    useEffect(() => {
        getAll();
    }, [])

    const [ sortType, setSortType ] = useState<string>('');

    // our sorting function
    const sort = (type: string) => {

        const artistsToSort = [ ...artists ];

        switch (type) {
            case 'id':
                artistsToSort.sort((a,b) => a.id - b.id);
                break;
            case 'name':
                artistsToSort.sort((a,b) => a.artistName.localeCompare(b.artistName));
                break;
            case 'label':
                artistsToSort.sort((a,b) => 
                    (a.label?.labelName ?? 'ZZZ').localeCompare(b.label?.labelName ?? 'ZZZ'));
                break;
            case 'count':
                artistsToSort.sort((a,b) => b.albums.length - a.albums.length);
                break;
        }

        setArtists(artistsToSort);
        setSortType(type);
    }

    return (
        <main>
            <h1>ARTISTS</h1>
            <h2>Artists in the Database</h2>
            
            <table>
                <thead>
                    <tr>
                        <th>ID <span onClick={() => sort('id')}
                            className={sortType === 'id' && 'white' || ''}>&#9660;</span></th>
                        <th>Artist Name <span onClick={() => sort('name')}
                            className={sortType === 'name' && 'white' || ''}>&#9660;</span></th>
                        <th>Label <span onClick={() => sort('label')}
                            className={sortType === 'label' && 'white' || ''}>&#9660;</span></th>
                        <th>Album Count <span onClick={() => sort('count')}
                            className={sortType === 'count' && 'white' || ''}>&#9660;</span></th>
                    </tr>
                </thead>

                <tbody>
                    { artists.map(artist => {
                        return (
                           <tr key={artist.id}>
                                <td>{artist.id}</td>
                                <td>{artist.artistName}</td>
                                <td>{artist.label?.labelName}</td>
                                <td>{artist.albums.length}</td>
                           </tr> 
                        )
                    }) }
                </tbody>
            </table>
        </main>
    )

}