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