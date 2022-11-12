import request from '@/utils/request'

// 查询人物卡模块基础设置列表
export function listConfig(query) {
  return request({
    url: '/charsys/config/list',
    method: 'get',
    params: query
  })
}

// 查询人物卡模块基础设置详细
export function getConfig(id) {
  return request({
    url: '/charsys/config/' + id,
    method: 'get'
  })
}

// 新增人物卡模块基础设置
export function addConfig(data) {
  return request({
    url: '/charsys/config',
    method: 'post',
    data: data
  })
}

// 修改人物卡模块基础设置
export function updateConfig(data) {
  return request({
    url: '/charsys/config',
    method: 'put',
    data: data
  })
}

// 删除人物卡模块基础设置
export function delConfig(id) {
  return request({
    url: '/charsys/config/' + id,
    method: 'delete'
  })
}

// 获取客户端更新
export function clientUpdate(version) {
  return request({
    url: '/charsys/client_update/' + version,
    method: 'get'
  })
}
