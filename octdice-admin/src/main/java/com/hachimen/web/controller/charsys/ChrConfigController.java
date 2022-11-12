package com.hachimen.web.controller.charsys;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hachimen.common.annotation.Log;
import com.hachimen.common.core.controller.BaseController;
import com.hachimen.common.core.domain.AjaxResult;
import com.hachimen.common.enums.BusinessType;
import com.hachimen.charsys.domain.ChrConfig;
import com.hachimen.charsys.service.IChrConfigService;
import com.hachimen.common.utils.poi.ExcelUtil;
import com.hachimen.common.core.page.TableDataInfo;

/**
 * 人物卡模块基础设置Controller
 * 
 * @author hachimen
 * @date 2022-11-12
 */
@RestController
@RequestMapping("/charsys/config")
public class ChrConfigController extends BaseController
{
    @Autowired
    private IChrConfigService chrConfigService;

    /**
     * 查询人物卡模块基础设置列表
     */
    @PreAuthorize("@ss.hasPermi('charsys:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChrConfig chrConfig)
    {
        startPage();
        List<ChrConfig> list = chrConfigService.selectChrConfigList(chrConfig);
        return getDataTable(list);
    }

    /**
     * 导出人物卡模块基础设置列表
     */
    @PreAuthorize("@ss.hasPermi('charsys:config:export')")
    @Log(title = "人物卡模块基础设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChrConfig chrConfig)
    {
        List<ChrConfig> list = chrConfigService.selectChrConfigList(chrConfig);
        ExcelUtil<ChrConfig> util = new ExcelUtil<ChrConfig>(ChrConfig.class);
        util.exportExcel(response, list, "人物卡模块基础设置数据");
    }

    /**
     * 获取人物卡模块基础设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('charsys:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chrConfigService.selectChrConfigById(id));
    }

    /**
     * 新增人物卡模块基础设置
     */
    @PreAuthorize("@ss.hasPermi('charsys:config:add')")
    @Log(title = "人物卡模块基础设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChrConfig chrConfig)
    {
        return toAjax(chrConfigService.insertChrConfig(chrConfig));
    }

    /**
     * 修改人物卡模块基础设置
     */
    @PreAuthorize("@ss.hasPermi('charsys:config:edit')")
    @Log(title = "人物卡模块基础设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChrConfig chrConfig)
    {
        return toAjax(chrConfigService.updateChrConfig(chrConfig));
    }

    /**
     * 删除人物卡模块基础设置
     */
    @PreAuthorize("@ss.hasPermi('charsys:config:remove')")
    @Log(title = "人物卡模块基础设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chrConfigService.deleteChrConfigByIds(ids));
    }
}
