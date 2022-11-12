package com.hachimen.charsys.service;

import com.hachimen.charsys.domain.ChrConfig;

import java.util.List;

/**
 * 人物卡模块客户端更新下载Service接口
 * 
 * @author hachimen
 * @date 2022-11-12
 */
public interface IClientDownloadService
{

    /**
     * 查询客户端更新下载信息
     * 
     * @param version 人物卡模块基础设置
     * @return 人物卡模块基础设置集合
     */
    public String getClientDownloadUpdate(String version);
}
