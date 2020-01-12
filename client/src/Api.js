import axios from 'axios'

const SERVER_URL = 'http://localhost:8080';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    getGenres: () => instance.get('genre/', {
        transformResponse: [function (data) {
            return data ? JSON.parse(data) : data;
        }]
    }),

    getPictures: (comicsName,num,name) => instance.get('comics/'+comicsName+'/vol/'+num+'/chapter/'+name+'/', {
        transformResponse: [function (data) {
            return data ? JSON.parse(data) : data;
        }]
    }),

    getCollection: () => instance.get("comics/",{
        transformResponse: [function (data) {
            return data ? JSON.parse(data) : data;
        }]
    }),

    getImg:(comicsName) =>instance.get("comics/"+comicsName+"/image",{
        transformResponse: [function (data) {
            return data ? JSON.parse(data) : data;
        }]
    }),

    getChapters:(comicsName) => instance.get("comics/"+comicsName+"/chapters/",{
    transformResponse: [function (data) {
        return data ? JSON.parse(data) : data;
    }]
}),
}