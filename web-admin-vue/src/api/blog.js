import baseurl from './baseurl'
import axios from 'axios'

export const saveBlog = params => { return axios.post(`${baseurl}/manage/blog/add`, params) }

export const getBlogs = () => { return axios.post(`${baseurl}/manage/blog/list`) }

export const deleteBlogById = (params) => { return axios.post(`${baseurl}/manage/blog/delete`, params) }