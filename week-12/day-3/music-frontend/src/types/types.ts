// this file contain custom types we can use 
// to ensure properties are being passed correctly
// we can also set our useState default value to something of this type

export type AlbumType = {
    id: number;
    albumName: string;
    releaseYear: number;
    artists: AlbumArtistType[];
}

export type AlbumArtistType = {
    id: number;
    artistName: string;
}