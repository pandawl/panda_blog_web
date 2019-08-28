import request from '../utils/request'

export const saveBlog = (params) => {

    return request({
        url: '/manage/blog/add',
        method: 'POST',
        params: params
    })
}

export const getBlogs = (pageNum, pageSize, value, searchName) => {

    return request({
        url: '/manage/blog/list',
        method: 'POST',
        params: { pageNum, pageSize, value, searchName }
    })
}

export const deleteBlogById = (params) => {
    return request({
        url: '/manage/blog/delete',
        method: 'POST',
        params: params
    })

}

export const getBlog = (id) => {
    return request({
        url: '/manage/blog/getblog',
        method: 'POST',
        params: { id }
    })
}
export const getImg = (file) => {
    return request({
        url: '/manage/img/upload',
        method: 'POST',
        data: file,
        headers: { 'Content-Type': 'multipart/form-data' },

    })
}
export const syncBlog = () => {
    return request({
        url: '/manage/blog/syncBlog',
        method: 'POST',
    })
}
export const getServer = () => {
    return request({
        url: '/manage/blog/server',
        method: 'GET',
    })
}