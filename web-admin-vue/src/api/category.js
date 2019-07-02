import request from '../utils/request'

export const getList = () => {
    return request({
        url: '/manage/category/list',
        method: 'POST',
    })
}

export const getCategoryById = (id) => {
  return request({
      url: '/manage/category/selete',
      method: 'POST',
      params: {id}
  })
}

export const getCategory = (search) => {
  return request({
      url: '/manage/category/list',
      method: 'POST',
      params: {search}
  })
}

export const add = (category) => {
  return request({
      url: '/manage/category/add',
      method: 'POST',
      params: category
  })
}
export const deleteCategory = (id) => {
  return request({
      url: '/manage/category/delete',
      method: 'POST',
      params: {id}
  })
}
export const update = (params) => {
  return request({
      url: '/manage/category/update',
      method: 'POST',
      params
  })
}
