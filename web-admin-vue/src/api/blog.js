import baseurl from './baseurl'
import axios from 'axios'

export const saveBlog = params => { return axios.post(`${baseurl}/manage/blog/add`, params) }

export const getBlogs = (pageNum, pageSize) => { return axios.post(`${baseurl}/manage/blog/list`, { pageNum, pageSize }) }

export const deleteBlogById = (params) => { return axios.post(`${baseurl}/manage/blog/delete`, params) }