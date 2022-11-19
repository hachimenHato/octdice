package com.hachimen.charsys.service;

import com.alibaba.fastjson2.JSONObject;
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
    public JSONObject getClientDownloadUpdate(String version);

    /**
     * 查询序列库更新下载信息
     *
     * @param version 人物卡模块基础设置
     * @return 人物卡模块基础设置集合
     */
    JSONObject getResourceDownloadUpdate(String version);

    /**
     * 查询人物卡模板更新下载信息
     *
     * @param version 人物卡模块基础设置
     * @return 人物卡模块基础设置集合
     */
    JSONObject getCharDownloadUpdate(String version);

    /**
     * 查询公告信息
     *
     *
     * @return 人物卡模块基础设置集合
     */
    JSONObject getNoticeDownloadUpdate();
}
