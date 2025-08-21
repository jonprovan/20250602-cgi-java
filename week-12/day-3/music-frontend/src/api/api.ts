// we'll use this file to hold all methods related to our API calls to our backend
// by storing them in a separate file, it's easy to export them and use them wherever

import axios from "axios"

const baseUrl = 'http://localhost:8080/';

export const getAllLabels = async () => {

    // we'll use axios for this request -- npm i axios
    // this library allows for easier API calls with less unpacking, better syntax, etc.
    return await axios.get(`${baseUrl}labels`);

}

export const getAllAlbums = async () => {
    return await axios.get(`${baseUrl}albums`);
} 