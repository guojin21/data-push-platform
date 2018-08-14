package com.guojin.dpp.reciever.client;


import com.google.common.base.Preconditions;
import com.guojin.dpp.common.client.ResultCode;
import com.guojin.dpp.common.client.ResultCodeProvider;
import com.guojin.dpp.common.constant.CommonErrCodes;
import com.guojin.dpp.common.constant.ModuleCodeEnum;
import com.guojin.dpp.common.constant.SubModuleCode;
import com.guojin.dpp.common.dto.MessageDTO;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @describe: 数据模拟接收器
 * @author: guojin
 * @date: 2018/8/14 18:10
 **/
@Controller
@RequestMapping("/v1/target")
@Api(value = "/v1/target/api", tags = "test-api", description = "ApiTestController")
public class ApiTestController {

    private static ResultCodeProvider rCodeProvider = new ResultCodeProvider(ModuleCodeEnum.DATA_PUSH_PLATFORM, SubModuleCode.RECIEVER);

    private static final Logger logger = LoggerFactory.getLogger(ApiTestController.class);


    /**
     * @describe: 接收HTTP POST的数据
     * @date: 2018/8/14 18:11
     **/
    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResultCode<Boolean>testPost(@RequestBody MessageDTO param) {
        try{
            Preconditions.checkArgument(null != param, "数据接收端取到数据为null");
            logger.info("数据接收端取到数据:" + param);
            return rCodeProvider.getRCode(true);
        }catch (IllegalArgumentException e){
            return rCodeProvider.getRCode(CommonErrCodes.INVALID_PARAM_FOR, false, new Object[]{e.getMessage()});
        }
    }
}
