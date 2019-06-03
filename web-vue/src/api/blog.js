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