import request from '../utils/request'

export const getTask = (pageNum, pageSize, value, searchName) => {
    return request({
        url: '/task/list',
        method: 'POST',
        params: { pageNum, pageSize, value, searchName }
    })
}
export const startTask = (id) => {
    return request({
        url: '/task/start',
        method: 'POST',
        params: id
    })
}
export const stopTask = (id) => {
    return request({
        url: '/task/stop/one',
        method: 'POST',
        params: id
    })
}
