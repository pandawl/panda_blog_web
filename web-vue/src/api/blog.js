import request from './request'

export const getList = () => {
    return request({
        url: 'blog/list',
        method: 'POST',
    })
}

export const add = () => {
    return request({
        url: 'blog/add',
        method: 'POST',
        params: {}
    })
}