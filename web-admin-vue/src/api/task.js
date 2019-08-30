import request from '../utils/request'

export const getTask = (pageNum, pageSize, value, searchName) => {
    return request({
        url: '/task/list',
        method: 'POST',
        params: { pageNum, pageSize, value, searchName }
    })
}