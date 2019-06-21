import request from '../utils/request'

export const saveBlog = (params) => {

    return request({
        url: '/manage/blog/add',
        method: 'POST',
        params: params
    })
}

export const getBlogs = (pageNum, pageSize) => {

    return request({
        url: '/manage/blog/list',
        method: 'POST',
        params: { pageNum, pageSize }
    })
}

export const deleteBlogById = (params) => {
    return request({
        url: '/manage/blog/delete',
        method: 'POST',
        params: params
    })

}