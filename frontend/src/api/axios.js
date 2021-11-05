import axios from 'axios';
import {TIMEOUT ,BASE_URL } from './config'

const instance = axios.create({
    baseURL:BASE_URL,
    timeout:TIMEOUT,
    headers: {
        'Content-Type': 'multipart/form-data'
    },
})
// instance.interceptors.request.use(config => {
//     console.log('请求被拦截')
//     return config
// },error => {

// })

// instance.interceptors.response.use(res => {
//     return res.data
// },error => {
//     return error;
// })
const auth={
    username: 'test@123.com',
    password: '123456'
}
export const get = (url, params)=>{
    return new Promise((resolve,reject) => {
        instance({
            url:url,
            method:'get',
            params:params,
            auth: auth,
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err);
        })
    })
}

export const post = (url, params ,headers) =>{
    return new Promise((resolve,reject) => {
        instance({
            url:url,
            method:'post',
            data:params,
            headers: headers? headers: {},
            auth: auth
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err);
        })
    })

}