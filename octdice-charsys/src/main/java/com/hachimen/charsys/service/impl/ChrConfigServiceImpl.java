package com.hachimen.charsys.service.impl;

import java.util.List;
import com.hachimen.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hachimen.charsys.mapper.ChrConfigMapper;
import com.hachimen.charsys.domain.ChrConfig;
import com.hachimen.charsys.service.IChrConfigService;

/**
 * 人物卡模块基础设置Service业务层处理
 * 
 * @author hachimen
 * @date 2022-11-12
 */
@Service
public class ChrConfigServiceImpl implements IChrConfigService 
{
    @Autowired
    private ChrConfigMapper chrConfigMapper;

    /**
     * 查询人物卡模块基础设置
     * 
     * @param id 人物卡模块基础设置主键
     * @return 人物卡模块基础设置
     */
    @Override
    public ChrConfig selectChrConfigById(Long id)
    {
        return chrConfigMapper.selectChrConfigById(id);
    }

    /**
     * 查询人物卡模块基础设置列表
     * 
     * @param chrConfig 人物卡模块基础设置
     * @return 人物卡模块基础设置
     */
    @Override
    public List<ChrConfig> selectChrConfigList(ChrConfig chrConfig)
    {
        return chrConfigMapper.selectChrConfigList(chrConfig);
    }

    /**
     * 新增人物卡模块基础设置
     * 
     * @param chrConfig 人物卡模块基础设置
     * @return 结果
     */
    @Override
    public int insertChrConfig(ChrConfig chrConfig)
    {
        return chrConfigMapper.insertChrConfig(chrConfig);
    }

    /**
     * 修改人物卡模块基础设置
     * 
     * @param chrConfig 人物卡模块基础设置
     * @return 结果
     */
    @Override
    public int updateChrConfig(ChrConfig chrConfig)
    {
        chrConfig.setUpdateTime(DateUtils.getNowDate());
        return chrConfigMapper.updateChrConfig(chrConfig);
    }

    /**
     * 批量删除人物卡模块基础设置
     * 
     * @param ids 需要删除的人物卡模块基础设置主键
     * @return 结果
     */
    @Override
    public int deleteChrConfigByIds(Long[] ids)
    {
        return chrConfigMapper.deleteChrConfigByIds(ids);
    }

    /**
     * 删除人物卡模块基础设置信息
     * 
     * @param id 人物卡模块基础设置主键
     * @return 结果
     */
    @Override
    public int deleteChrConfigById(Long id)
    {
        return chrConfigMapper.deleteChrConfigById(id);
    }
}
