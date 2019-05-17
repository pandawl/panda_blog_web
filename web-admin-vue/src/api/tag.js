import request from '../utils/request'

export const getTagList = () => {
    return request({
        url: '/manage/tag/list',
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