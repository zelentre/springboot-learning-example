package com.molice.web.controller.limit;

import com.crossoverjie.distributed.annotation.CommonLimit;
import com.molice.annotation.DataPack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author molice
 * @date 2019/3/29
 **/
@RestController
@RequestMapping("limit")
@Api(tags = "限流")
public class TestLimitController {
    private static Logger logger = LoggerFactory.getLogger(TestLimitController.class);

    @GetMapping("test")
    @CommonLimit
    @DataPack
    @ApiOperation("测试")
    public Object testLimit() throws InterruptedException {
        logger.info("并发测试");
        Thread.sleep(100);

        return new Date();
    }
}
