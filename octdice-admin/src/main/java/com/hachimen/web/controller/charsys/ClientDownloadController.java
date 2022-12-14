package com.hachimen.web.controller.charsys;

import com.alibaba.fastjson2.JSONObject;
import com.hachimen.charsys.domain.ChrConfig;
import com.hachimen.charsys.service.IChrConfigService;
import com.hachimen.charsys.service.IClientDownloadService;
import com.hachimen.common.annotation.Anonymous;
import com.hachimen.common.annotation.Log;
import com.hachimen.common.core.controller.BaseController;
import com.hachimen.common.core.domain.AjaxResult;
import com.hachimen.common.core.page.TableDataInfo;
import com.hachimen.common.enums.BusinessType;
import com.hachimen.common.utils.poi.ExcelUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 人物卡模块客户端更新下载Controller
 * 
 * @author hachimen
 * @date 2022-11-12
 */
@Api("客户端更新检测")
@RestController
@RequestMapping("/charsys")
public class ClientDownloadController extends BaseController
{
    @Autowired
    private IClientDownloadService clientDownloadService;

    /**
     * 查询客户端更新下载信息
     */
    @ApiOperation("查询服务器最新版本")
    @ApiResponses({ @ApiResponse(code = 200, message = "获取成功,无需更新返回true,需要更新返回下载url") , @ApiResponse(code = 500, message = "获取失败，无有效数据或服务器异常") })
    @Anonymous
    @GetMapping("/client_update/{version}")
    public AjaxResult ClientDownloadUpdate (@ApiParam(value = "客户端当前版本号", required = true) @PathVariable String version)
    {
        JSONObject result = null;
        try {
            result = clientDownloadService.getClientDownloadUpdate(version);
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success(result);
    }

    /**
     * 查询序列库更新下载信息
     */
    @ApiOperation("查询序列库最新版本")
    @ApiResponses({ @ApiResponse(code = 200, message = "获取成功,无需更新返回true,需要更新返回下载url") , @ApiResponse(code = 500, message = "获取失败，无有效数据或服务器异常") })
    @Anonymous
    @GetMapping("/resource_update/{version}")
    public AjaxResult ResourceDownloadUpdate (@ApiParam(value = "序列库当前版本号", required = true) @PathVariable String version)
    {
        JSONObject result = null;
        try {
            result = clientDownloadService.getResourceDownloadUpdate(version);
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success(result);
    }

    /**
     * 查询人物卡模板更新下载信息
     */
    @ApiOperation("查询人物卡模板最新版本")
    @ApiResponses({ @ApiResponse(code = 200, message = "获取成功,无需更新返回true,需要更新返回下载url") , @ApiResponse(code = 500, message = "获取失败，无有效数据或服务器异常") })
    @Anonymous
    @GetMapping("/char_update/{version}")
    public AjaxResult CharDownloadUpdate (@ApiParam(value = "人物卡模板当前版本号", required = true) @PathVariable String version)
    {
        JSONObject result = null;
        try {
            result = clientDownloadService.getCharDownloadUpdate(version);
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success(result);
    }

    /**
     * 查询公告信息
     */
    @ApiOperation("查询公告")
    @ApiResponses({ @ApiResponse(code = 200, message = "获取成功") , @ApiResponse(code = 500, message = "获取失败，无有效数据或服务器异常") })
    @Anonymous
    @GetMapping("/notice")
    public AjaxResult NoticeDownloadUpdate ()
    {
        JSONObject result = null;
        try {
            result = clientDownloadService.getNoticeDownloadUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success(result);
    }


}
