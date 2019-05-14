import baseUrl from './baseurl'
export function login(data) {
    return request({
        url: baseUrl + '/panda/user/getUser',
        method: 'post',
        data
    })
}