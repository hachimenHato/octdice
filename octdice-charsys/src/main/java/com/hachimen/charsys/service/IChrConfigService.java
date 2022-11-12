package com.hachimen.charsys.service;

import java.util.List;
import com.hachimen.charsys.domain.ChrConfig;

/**
 * 人物卡模块基础设置Service接口
 * 
 * @author hachimen
 * @date 2022-11-12
 */
public interface IChrConfigService 
{
    /**
     * 查询人物卡模块基础设置
     * 
     * @param id 人物卡模块基础设置主键
     * @return 人物卡模块基础设置
     */
    public ChrConfig selectChrConfigById(Long id);

    /**
     * 查询人物卡模块基础设置列表
     * 
     * @param chrConfig 人物卡模块基础设置
     * @return 人物卡模块基础设置集合
     */
    public List<ChrConfig> selectChrConfigList(ChrConfig chrConfig);

    /**
     * 新增人物卡模块基础设置
     * 
     * @param chrConfig 人物卡模块基础设置
     * @return 结果
     */
    public int insertChrConfig(ChrConfig chrConfig);

    /**
     * 修改人物卡模块基础设置
     * 
     * @param chrConfig 人物卡模块基础设置
     * @return 结果
     */
    public int updateChrConfig(ChrConfig chrConfig);

    /**
     * 批量删除人物卡模块基础设置
     * 
     * @param ids 需要删除的人物卡模块基础设置主键集合
     * @return 结果
     */
    public int deleteChrConfigByIds(Long[] ids);

    /**
     * 删除人物卡模块基础设置信息
     * 
     * @param id 人物卡模块基础设置主键
     * @return 结果
     */
    public int deleteChrConfigById(Long id);
}
