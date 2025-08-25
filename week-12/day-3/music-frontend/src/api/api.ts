// we'll use this file to hold all methods related to our API calls to our backend
// by storing them in a separate file, it's easy to export them and use them wherever

import axios from "axios"

const baseUrl = 'http://localhost:8080/';

export const getAllLabels = async () => {

    // we'll use axios for this request -- npm i axios
    // this library allows for easier API calls with less unpacking, better syntax, etc.
    return await axios.get(`${baseUrl}labels`);

}

// this function takes in our form data and submits it as a post request to the backend
// for post requests in axios, the second parameter after the URL is the body
export const createLabel = async (label: { labelName: string }) => {
    return await axios.post(`${baseUrl}labels`, label);
}

// for functions requiring inputs, you have to take them in from the component
export const deleteLabelById = async (id: number) => {
    return await axios.delete(`${baseUrl}labels/${id}`);
}

export const getAllAlbums = async () => {
    return await axios.get(`${baseUrl}albums`);
}

export const getAlbumById = async (id: number) => {
    return await axios.get(`${baseUrl}albums/${id}`);
}

// since the id won't be in the form data, we need to take it in separately
export const updateAlbum = async (id: number, albumDTO: object) => {
    return await axios.put(`${baseUrl}albums/${id}`, albumDTO);
}

// getting all the artists for our album update page, but use this wherever!
export const getAllArtists = async () => {
    return await axios.get(`${baseUrl}artists`);
}