import request from './request'

export const getList = (pageNum, pageSize) => {
    return request({
        url: 'blog/list',
        method: 'POST',
        params: { pageNum, pageSize }
    })
}

export const add = () => {
    return request({
        url: 'blog/add',
        method: 'POST',
        params: {}
    })
}
export const getBlog = (id) => {
    return request({
        url: 'blog/getblog',
        method: 'POST',
        params: { id }
    })
}
export const getBlogByTag = (pageNum, pageSize, search) => {
    return request({
        url: 'blog/tag/list',
        method: 'POST',
        params: { pageNum, pageSize, search }
    })
}
export const getBlogByCategory = (pageNum, pageSize, search) => {
    return request({
        url: 'blog/category/list',
        method: 'POST',
        params: { pageNum, pageSize, search }
    })
}
export const getBlogByTime = (pageNum, pageSize, search) => {
    return request({
        url: 'blog/time',
        method: 'POST',
        params: { pageNum, pageSize, search }
    })
}
export const getTimeList = () => {
    return request({
        url: 'blog/gettime',
        method: 'POST',
        params: {}
    })
}
export const getCategoryList = () => {
    return request({
        url: 'manage/category/list',
        method: 'POST',
        params: {}
    })
}
export const getTagList = () => {
    return request({
        url: 'manage/tag/list',
        method: 'POST',
        params: {}
    })
}

export const getTag = (id) => {
    return request({
        url: 'manage/tag/select',
        method: 'POST',
        params: { id }
    })
}
export const getCategory = (id) => {
    return request({
        url: 'manage/category/select',
        method: 'POST',
        params: { id }
    })
}