import axios  from "axios";

const baseURL='http://localhost:8080/api/v1';
// const baseURL='http://localhost:5173/';
export const customAxios=axios.create({
    baseURL: baseURL,
})