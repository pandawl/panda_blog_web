import request from './request'

export const getList = (curPage, pageSize) => {
    return request({
        url: 'blog/list',
        method: 'POST',
        params: { curPage, pageSize }
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