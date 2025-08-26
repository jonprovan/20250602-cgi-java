import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { getAlbumById, getAllArtists, updateAlbum } from "../api/api";
import { useForm, type SubmitHandler } from "react-hook-form";
import { Link } from "react-router";

export const UpdateAlbum = () => {

    // getting access to our album ID with useParams()
    const params = useParams();

    const navigate = useNavigate();

    // setting up local state for the album we'll get from the DB
    const [ album, setAlbum ] = useState(
        {
            id: Number.parseInt(params.albumId as string),
            albumName: '',
            releaseYear: undefined,
            artists: [
                {
                    id: 0,
                    artistName: ''
                }
            ]
        });

    // state for our artists select dropdown
    const [ artists, setArtists ] = useState([
        {
            id: 0,
            artistName: ''
        }
    ]);

    // setting up some state to use with our error handling
    const [ error, setError ] = useState<string>('');

    // using our API method to retrieve the album based on the URL param
    // the param comes in as a string, so we need to cast it as a number
    function getAlbum() {
        getAlbumById(album.id).then(response => {
            setAlbum(response.data);
        }).catch(err => {
            console.log(err);
            if (err.status === 404)
                setError(`Album with ID ${album.id} does not exist!`);
        })
    }

    // using our API method to get all artists for our select dropdown
    function getArtists() {
        getAllArtists().then(response => {
            setArtists(response.data);
        })
    }

    // running the API call when this component loads
    // this will load the album in question and also all the artists
    useEffect(() => {
        getAlbum();
        getArtists();
    }, [])

    // setting up our React Hook Form
    type Inputs = {
        albumName: string,
        releaseYear: number
        artist: number
    }

    const { register, 
            handleSubmit } = useForm<Inputs>({ mode: 'all'});

    const onSubmit: SubmitHandler<Inputs> = formData => {

        // copying the state of the current artists for this album
        const newArtistsList = album.artists;
        
        // getting the full artist object from the existing full artists array
        // using a predicate to match the form's artist ID with the correct artists
        const artistToAdd = artists.find(artist => artist.id == formData.artist);

        // we need to check if the artist exists, or TypeScript will complain
        // if it exists, we add it to the copied array of artists for this album
        if (artistToAdd)
            newArtistsList.push(artistToAdd);

        // assembling the body object
        // for albumName and releaseYear, if the user doesn't change the form values
        // they'll be blank in formData
        // so we use the default values from the existing object if so
        // for artists, we use our new array of artists with possibly one added
        const bodyObject = {
            albumName: formData.albumName || album.albumName,
            releaseYear: formData.releaseYear || album.releaseYear,
            artists: newArtistsList
        }

        // now, we call our put method and head back to the Albums page
        updateAlbum(album.id, bodyObject)
            .then(() => navigate('/albums'))
            .catch(err => {
                console.log(err);
                if (err.status === 404)
                    setError('Album not updated!');
            });
    }

    return (
        <main>
            <Link to='/albums'>{'<< Back to Albums'}</Link>
            <h1>Update Album</h1>
            <h2>Update the Album from the Albums page here!</h2>

            <form onSubmit={handleSubmit(onSubmit)}>

                <h3>Update Album with ID {album.id}
                    {error && <span>{error}</span>}
                </h3>

                <div>
                    <label>Album Name: </label>
                    <input defaultValue={album.albumName}
                           {...register('albumName')} />
                </div>
                <div>
                    <label>Release Year: </label>
                    <input defaultValue={album.releaseYear}
                           {...register('releaseYear')}
                           type="number" />
                </div>
                <div>
                    <label>Select First Artist: </label>
                    {/* using a select to show all valid artists
                        this uses all the artists from the DB
                        the user MUST choose a valid artists and
                        cannot insert their own */}
                    <select {...register('artist')} >
                        <option value={0}>Select an artist to add...</option>
                        {/* we map the artists into select options */}
                        {artists.map(artist => {
                            return (
                                // value is what will be stored in the form
                                // the name goes as text within the option
                                <option value={artist.id}
                                        key={artist.id}>{artist.artistName}</option>
                            )
                        })}
                    </select>
                </div>
                <input type="submit" />

            </form>
            
        </main>
    );
}