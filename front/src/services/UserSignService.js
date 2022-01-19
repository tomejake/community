import axios from 'axios'

function registUser(userData) {
    const baseURL = 'http://localhost:7070';
    return axios.post(baseURL, userData);
}

export {registUser};