package com.hachimen.charsys.service.impl;

import com.hachimen.charsys.domain.ChrConfig;
import com.hachimen.charsys.mapper.ClientDownloadMapper;
import com.hachimen.charsys.service.IClientDownloadService;
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


    @Override
    public String getClientDownloadUpdate(String version) {
        ChrConfig chrConfig = new ChrConfig();
        chrConfig.setName("version");
        List<ChrConfig> chrConfigs = chrConfigService.selectChrConfigList(chrConfig);
        for (ChrConfig config : chrConfigs) {
            if("version".equals(config.getName())){
                //比对版本号
                if(config.getValue().equals(version)){
                    //版本相同
                    return "true";
                }else{
                    //版本不同
                    ChrConfig chrConfig_url = new ChrConfig();
                    chrConfig_url.setName("url");
                    List<ChrConfig> chrConfig_urls = chrConfigService.selectChrConfigList(chrConfig_url);
                    for (ChrConfig chrConfigUrl : chrConfig_urls) {
                        if("url".equals(chrConfigUrl.getName())){
                            return chrConfigUrl.getValue();
                        }
                    }
                }

            }
        }
        throw new RuntimeException("异常或无数据");
    }
}
