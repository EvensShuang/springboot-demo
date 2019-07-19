package com.shuang.controller.demo;

import com.shuang.controller.base.BaseController;
import com.shuang.service.demo.DemoService;
import com.shuang.service.demo.entity.Demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-17
 * @Version: 1.0
 */
@RestController
@RequestMapping("/transaction")
@Api(value = "Transaction DEMO API", description = "这是一个事务示例API")
public class TransactionDemoController extends BaseController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/required")
    @ApiOperation(value = "我是一个required事务请求示例A事务回滚B事务回滚", notes = "创建人[张爽]-修改人[张爽]")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demoList", value = "demo数组", required = true, paramType = "body",allowMultiple=true,dataType = "Demo", defaultValue="null"),
    })
    public int required(@RequestBody List<Demo> demoList) {
       return  demoService.addDemoRequired(demoList);
    }

    @PostMapping("/required_new")
    @ApiOperation(value = "我是一个required_new事务请求示例A新建事务(外部事务回滚,内部事务提交不回滚)相对独立", notes = "创建人[张爽]-修改人[张爽]")
    public int required_new() {
        return  demoService.addDemoRequiredNew();
    }

    @PostMapping("/not_supported")
    @ApiOperation(value = "我是一个not_supported事务请求示例B内部事务抛出异常后,导致外部A事务回滚,但是B内部事务提交", notes = "创建人[张爽]-修改人[张爽]")
    public int not_supported() {
        return  demoService.updateDemoNotSupported();
    }

    @PostMapping("/supports")
    @ApiOperation(value = "我是一个supported事务请求示例A方法调B方法如果A有事务那么AB都有事务", notes = "创建人[张爽]-修改人[张爽]")
    public int supports() {
        return  demoService.supports();
    }


    @PostMapping("/mandatory")
    @ApiOperation(value = "我是一个mandatory事务请求示例A事务回滚B事务不回滚", notes = "创建人[张爽]-修改人[张爽]")
    public int mandatory() {
        return  demoService.mandatory();
    }


    @PostMapping("/nested")
    @ApiOperation(value = "我是一个mandatory事务请求示当外部B事务发生异常时,会导致整个内外部事务回滚", notes = "创建人[张爽]-修改人[张爽]")
    public int nested() {
        return  demoService.nested();
    }

    @PostMapping("/never")
    @ApiOperation(value = "我是一个mandatory事务请求示当外部B事务发生异常时,会导致整个内外部事务回滚", notes = "创建人[张爽]-修改人[张爽]")
    public int never() {
        return  demoService.never();
    }

}
