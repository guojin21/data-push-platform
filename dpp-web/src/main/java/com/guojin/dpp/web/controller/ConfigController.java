package com.guojin.dpp.web.controller;


import com.google.common.base.Preconditions;
import com.guojin.dpp.common.client.ResultCode;
import com.guojin.dpp.common.client.ResultCodeProvider;
import com.guojin.dpp.common.constant.CommonErrCodes;
import com.guojin.dpp.common.constant.ModuleCodeEnum;
import com.guojin.dpp.common.constant.SubModuleCode;
import com.guojin.dpp.common.dto.ConfigDTO;
import com.guojin.dpp.web.model.ConfigPO;
import com.guojin.dpp.web.model.ConfigTransfer;
import com.guojin.dpp.web.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @describe: 推送配置管理
 * @author: guojin
 * @date: 2018/8/2 11:24
 **/
@Controller
@RequestMapping("/v1/config")
@Api(value = "/v1/config", tags = "config-rest-api", description = "ConfigController")
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    private static ResultCodeProvider rCodeProvider = new ResultCodeProvider(ModuleCodeEnum.DATA_PUSH_PLATFORM, SubModuleCode.WEB);

    @Autowired
    private ConfigService configServiceImpl;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增配置接口", notes = "特殊参数说明-adapter:适配器对象,选择")
    public ResultCode<Boolean> addConfig(@RequestBody ConfigDTO configDTO) {
        try {
            Preconditions.checkArgument(null != configDTO, "新增配置信息不能为空");
            boolean success = configServiceImpl.addConfig(configDTO);
            return rCodeProvider.getRCode(success);
        } catch (IllegalArgumentException e) {
            logger.warn("新增配置信息参数检验失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, false, new Object[]{e.getMessage()});
        } catch (Exception e) {
            logger.error("配置信息保存失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, false, new Object[]{e.getMessage()});
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有配置信息", notes = "查询所有配置信息")
    public ResultCode<List<ConfigDTO>> getAllConfigInfo() {
        try {
            List<ConfigPO> configPOS = configServiceImpl.getAllConfigInfo();
            if (CollectionUtils.isEmpty(configPOS)) {
                throw new IllegalArgumentException(String.format("记录为空"));
            }
            List<ConfigDTO> configDTOS = ConfigTransfer.poList2dtoList(configPOS);
            return rCodeProvider.getRCode(configDTOS);
        } catch (Exception e) {
            logger.error("查询所有配置信息失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, null, new Object[]{e.getMessage()});
        }
    }


    @RequestMapping(value = "/info/{configId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id查询对应配置信息", notes = "根据Id查询对应配置信息")
    public ResultCode<ConfigDTO> getConfigInfoById(@PathVariable Long configId) {
        try {
            Preconditions.checkArgument(null != configId, "查询ID不能为空");
            ConfigPO configPO = configServiceImpl.getConfigInfoById(configId);
            if (null == configPO) {
                throw new IllegalArgumentException(String.format("configId:%s,记录为空", configId));
            }
            ConfigDTO configDTO = ConfigTransfer.po2dto(configPO);
            return rCodeProvider.getRCode(configDTO);
        } catch (IllegalArgumentException e) {
            logger.warn("根据Id查询参数检验失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, null, new Object[]{e.getMessage()});
        } catch (Exception e) {
            logger.error("根据Id查询对应配置信息失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, null, new Object[]{e.getMessage()});
        }
    }

    @RequestMapping(value = "/user/{userId}/info", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询用户userId所有配置信息", notes = "查询用户userId所有配置信息")
    public ResultCode<List<ConfigDTO>> getConfigsByUserId(@PathVariable String userId) {
        try {
            Preconditions.checkArgument(null != userId, "查询用户的userId不能为空");
            List<ConfigPO> configPOS = configServiceImpl.getConfigsByUserId(userId);
            if (CollectionUtils.isEmpty(configPOS)) {
                throw new IllegalArgumentException(String.format("userId:%s,结果为空", userId));
            }
            List<ConfigDTO> configDTOS = ConfigTransfer.poList2dtoList(configPOS);
            return rCodeProvider.getRCode(configDTOS);
        } catch (IllegalArgumentException e) {
            logger.warn("查询用户userId参数检验失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, null, new Object[]{e.getMessage()});
        } catch (Exception e) {
            logger.error("查询用户userId所有配置信息失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, null, new Object[]{e.getMessage()});
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "修改配置信息", notes = "修改配置信息")
    public ResultCode<Boolean> updateConfig(@RequestBody ConfigDTO configDTO) {
        try {
            Preconditions.checkArgument(null != configDTO, "更新参数不能为空");
            boolean success = configServiceImpl.updateConfig(configDTO);
            return rCodeProvider.getRCode(success);
        } catch (IllegalArgumentException e) {
            logger.warn("更新的配置参数检验失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, null, new Object[]{e.getMessage()});
        } catch (Exception e) {
            logger.error("配置信息更新失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, null, new Object[]{e.getMessage()});
        }
    }

    @RequestMapping(value = "/delete/{configId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "根据ID删除配置信息", notes = "根据ID删除配置信息")
    public ResultCode<Boolean> deleteConfigById(@PathVariable Long configId) {
        try {
            Preconditions.checkArgument(null != configId, "参数id不能为空");
            boolean success = configServiceImpl.deleteConfig(configId);
            return rCodeProvider.getRCode(success);
        } catch (IllegalArgumentException e) {
            logger.warn("删除配置的参数检验失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, null, new Object[]{e.getMessage()});
        } catch (Exception e) {
            logger.error("配置信息删除失败", e);
            return rCodeProvider.getRCode(CommonErrCodes.INTERNAL_ERROR_FOR, null, new Object[]{e.getMessage()});
        }
    }

}
