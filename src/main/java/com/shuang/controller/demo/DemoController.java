package com.shuang.controller.demo;

import com.shuang.controller.base.BaseController;
import com.shuang.service.demo.entity.Demo;
import com.shuang.service.page.Page;
import com.shuang.util.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * demo
 *
 */
@RestController
@RequestMapping("/example")
@Api(value = "DEMO API", description = "这是一个示例API")
public class DemoController extends BaseController {

//    @Reference(version = "1.0")
//    private BasicService basicService;

    @PostMapping("/demo1")
    @ApiOperation(value = "我是一个普通请求示例", notes = "创建人[金正斌]-修改人[金正斌]")
    public Demo demo1(Demo demo) {
        return demo;
    }

    @GetMapping("/demo2")
    @ApiOperation(value = "我是一个分页请求示例", notes = "创建人[金正斌]-修改人[金正斌]")
    public RestResult<Page<Demo>> demo2(@RequestHeader("x-access-token") String accessToken,
                                        @ApiParam(value = "articleId", required = true) @RequestParam("articleId") Integer articleId,
                                        @ApiParam(value = "站点id", required = true) @RequestParam(value = "siteId") Integer siteId,
                                        @ApiParam(value = "当前页", required = true) @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                        @ApiParam(value = "页长", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        List<Demo> list = new ArrayList<>();
        Integer count = 100;
        Page<Demo> page = new Page<>(pageNo, pageSize, count, list);
        return RestResult.genSuccessResult(page);
    }

//    @GetMapping("/demo3")
//    @ApiOperation(value = "我比较高级,我是请求dubbo服务的示例", notes = "创建人[金正斌]-修改人[金正斌]")
//    public RestResult<List<Site>> demo3() {
//        return RestResult.genSuccessResult(basicService.queryAllSite().getResult());
//    }

}
