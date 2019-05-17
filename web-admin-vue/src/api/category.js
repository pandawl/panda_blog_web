import request from '../utils/request'

export const getList = () => {
    return request({
        url: '/manage/category/list',
        method: 'POST',
    })
}

export const add = () => {
    return request({
        url: '/manage/category/add',
        method: 'POST',
        params: {}
    })
}