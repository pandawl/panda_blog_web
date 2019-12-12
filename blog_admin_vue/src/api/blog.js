import request from '../utils/request'

export const saveBlog = (params) => {

  return request.post( '/manage/blog/add',params)
}

export const getBlogs = (...params) => {
  return request.post('/manage/blog/list', ...params)
}

export const deleteBlogById = (params) => {
  return request({
    url: '/manage/blog/delete',
    method: 'POST',
    params: params
  })

}

export const getBlog = (id) => {
  return request({
    url: '/manage/blog/getblog',
    method: 'POST',
    params: {id}
  })
}
export const getImg = (file) => {
  return request({
    url: '/manage/img/upload',
    method: 'POST',
    headers: {'Content-Type': 'multipart/form-data'},
    data: file,


  })
}
export const syncBlog = () => {
  return request({
    url: '/manage/blog/syncBlog',
    method: 'POST',
  })
}
export const getServer = () => {
  return request({
    url: '/manage/blog/server',
    method: 'GET',
  })
}
