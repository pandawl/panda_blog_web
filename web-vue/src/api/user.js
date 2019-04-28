import axios from './index'

export const getUserInfo = (id) => {
    return axios.request({
        url: '/panda/user/getUser',
        method: 'post',
        data: { id }
    })
}