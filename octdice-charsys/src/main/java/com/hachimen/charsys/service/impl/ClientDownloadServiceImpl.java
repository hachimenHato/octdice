package com.hachimen.charsys.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.hachimen.charsys.domain.ChrConfig;
import com.hachimen.charsys.mapper.ClientDownloadMapper;
import com.hachimen.charsys.service.IClientDownloadService;
import com.hachimen.system.domain.SysNotice;
import com.hachimen.system.service.impl.SysNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;

/**
 * 人物卡模块客户端更新下载Service业务层处理
 * 
 * @author hachimen
 * @date 2022-11-12
 */
@Service
public class ClientDownloadServiceImpl implements IClientDownloadService
{
    @Autowired
    private ClientDownloadMapper clientDownloadMapper;

    @Autowired
    private ChrConfigServiceImpl chrConfigService;

    @Autowired
    private SysNoticeServiceImpl sysNoticeService;


    @Override
    public JSONObject getClientDownloadUpdate(String version) {
        ChrConfig chrConfig = new ChrConfig();
        chrConfig.setName("version");
        JSONObject jsonObject = new JSONObject();
        List<ChrConfig> chrConfigs = chrConfigService.selectChrConfigList(chrConfig);
        for (ChrConfig config : chrConfigs) {
            if("version".equals(config.getName())){
                //比对版本号
                if(config.getValue().equals(version)){
                    //版本相同
                    jsonObject.put("no_update","true");
                    return jsonObject;
                }else{
                    //版本不同
                    jsonObject.put("no_update","false");
                    ChrConfig chrConfig_url = new ChrConfig();
                    chrConfig_url.setName("url");
                    List<ChrConfig> chrConfig_urls = chrConfigService.selectChrConfigList(chrConfig_url);
                    for (ChrConfig chrConfigUrl : chrConfig_urls) {
                        if("url".equals(chrConfigUrl.getName())){
                            jsonObject.put("url",chrConfigUrl.getValue());

                        }
                    }
                    ChrConfig chrConfig_notice = new ChrConfig();
                    chrConfig_notice.setName("notice");
                    List<ChrConfig> chrConfig_notices = chrConfigService.selectChrConfigList(chrConfig_notice);
                    for (ChrConfig chrConfig_not : chrConfig_notices) {
                        if("notice".equals(chrConfig_not.getName())){
                            jsonObject.put("notice",chrConfig_not.getValue());

                        }
                    }
                    return jsonObject;
                }

            }
        }
        throw new RuntimeException("异常或无数据");
    }

    @Override
    public JSONObject getResourceDownloadUpdate(String version) {
        ChrConfig chrConfig = new ChrConfig();
        chrConfig.setName("resource_version");
        JSONObject jsonObject = new JSONObject();
        List<ChrConfig> chrConfigs = chrConfigService.selectChrConfigList(chrConfig);
        for (ChrConfig config : chrConfigs) {
            if("resource_version".equals(config.getName())){
                //比对版本号
                if(config.getValue().equals(version)){
                    //版本相同
                    jsonObject.put("no_update","true");
                    return jsonObject;
                }else{
                    //版本不同
                    jsonObject.put("no_update","false");
                    ChrConfig chrConfig_url = new ChrConfig();
                    chrConfig_url.setName("resource_url");
                    List<ChrConfig> chrConfig_urls = chrConfigService.selectChrConfigList(chrConfig_url);
                    for (ChrConfig chrConfigUrl : chrConfig_urls) {
                        if("resource_url".equals(chrConfigUrl.getName())){
                            jsonObject.put("url",chrConfigUrl.getValue());

                        }
                    }
                    ChrConfig chrConfig_notice = new ChrConfig();
                    chrConfig_notice.setName("resource_notice");
                    List<ChrConfig> chrConfig_notices = chrConfigService.selectChrConfigList(chrConfig_notice);
                    for (ChrConfig chrConfig_not : chrConfig_notices) {
                        if("resource_notice".equals(chrConfig_not.getName())){
                            jsonObject.put("notice",chrConfig_not.getValue());

                        }
                    }
                    return jsonObject;
                }

            }
        }
        throw new RuntimeException("异常或无数据");
    }

    @Override
    public JSONObject getCharDownloadUpdate(String version) {
        ChrConfig chrConfig = new ChrConfig();
        chrConfig.setName("chr_version");
        JSONObject jsonObject = new JSONObject();
        List<ChrConfig> chrConfigs = chrConfigService.selectChrConfigList(chrConfig);
        for (ChrConfig config : chrConfigs) {
            if("chr_version".equals(config.getName())){
                //比对版本号
                if(config.getValue().equals(version)){
                    //版本相同
                    jsonObject.put("no_update","true");
                    return jsonObject;
                }else{
                    //版本不同
                    jsonObject.put("no_update","false");
                    ChrConfig chrConfig_url = new ChrConfig();
                    chrConfig_url.setName("chr_url");
                    List<ChrConfig> chrConfig_urls = chrConfigService.selectChrConfigList(chrConfig_url);
                    for (ChrConfig chrConfigUrl : chrConfig_urls) {
                        if("chr_url".equals(chrConfigUrl.getName())){
                            jsonObject.put("url",chrConfigUrl.getValue());

                        }
                    }
                    ChrConfig chrConfig_notice = new ChrConfig();
                    chrConfig_notice.setName("chr_notice");
                    List<ChrConfig> chrConfig_notices = chrConfigService.selectChrConfigList(chrConfig_notice);
                    for (ChrConfig chrConfig_not : chrConfig_notices) {
                        if("chr_notice".equals(chrConfig_not.getName())){
                            jsonObject.put("notice",chrConfig_not.getValue());

                        }
                    }
                    return jsonObject;
                }

            }
        }
        throw new RuntimeException("异常或无数据");
    }

    @Override
    public JSONObject getNoticeDownloadUpdate() {
        JSONObject jsonObject = new JSONObject();

        SysNotice sysNotice = new SysNotice();
        sysNotice.setStatus("0");

        //获取通知
        sysNotice.setNoticeType("1");
        List<SysNotice> sysNotices_message = sysNoticeService.selectNoticeList(sysNotice);
        jsonObject.put("message",sysNotices_message);

        //获取公告
        sysNotice.setNoticeType("2");
        List<SysNotice> sysNotices_notice = sysNoticeService.selectNoticeList(sysNotice);
        jsonObject.put("notice",sysNotices_notice);

        return jsonObject;
    }
}
