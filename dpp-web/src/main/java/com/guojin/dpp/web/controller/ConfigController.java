package com.guojin.dpp.web.controller;


import com.google.common.base.Preconditions;
import com.guojin.dpp.common.client.ResultCode;
import com.guojin.dpp.common.client.ResultCodeProvider;
import com.guojin.dpp.common.constant.CommonErrCodes;
import com.guojin.dpp.common.constant.ModuleCodeEnum;
import com.guojin.dpp.common.constant.SubModuleCode;
import com.guojin.dpp.web.dto.ConfigInfoDTO;
import com.guojin.dpp.web.service.IConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @describe: 推送配置管理
 * @author: guojin
 * @date: 2018/8/2 11:24
 **/
@Controller
@RequestMapping("/v1/web")
@Api(value = "/v1/web", tags = "config-rest-api", description = "ConfigController")
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    private static ResultCodeProvider rCodeProvider = new ResultCodeProvider(ModuleCodeEnum.DATA_PUSH_PLATFORM, SubModuleCode.WEB);

    @Autowired
    private IConfigService configServiceImpl;

    @RequestMapping(value="/config", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增配置", notes = "新增配置")
    public ResultCode<Boolean> addConfig(@RequestBody ConfigInfoDTO configInfoDTO){
        try {
            Preconditions.checkArgument(null != configInfoDTO, "新增配置信息不能为空");
            boolean success = configServiceImpl.addConfig(configInfoDTO);
            return rCodeProvider.getRCode(success);
        } catch(IllegalArgumentException e) {
            logger.warn("新增配置信息参数检验失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, false, new Object[]{e.getMessage()});
        } catch(Exception e) {
            logger.error("配置信息保存失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, false, new Object[]{e.getMessage()});
        }
    }

}
