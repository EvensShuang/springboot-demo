package com.rograndec.service.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页接口
 */
@ApiModel(value = "Paginable", description = "分页信息")
public interface Paginable {

    /**
     * 总记录数
     *
     * @return
     */
    @ApiModelProperty(required = false, value = "记录总数")
    public int getTotalCount();

    /**
     * 总页数
     *
     * @return
     */
    @ApiModelProperty(required = false, value = "分页总数")
    public int getTotalPage();

    /**
     * 每页记录数
     *
     * @return
     */
    @ApiModelProperty(required = false, value = "每页记录数")
    public int getPageSize();

    /**
     * 当前页号
     *
     * @return
     */
    @ApiModelProperty(required = true, value = "当前页码")
    public int getPageNo();

    /**
     * 是否第一页
     *
     * @return
     */
    @ApiModelProperty(required = false, value = "是否为第一页")
    public boolean isFirstPage();

    /**
     * 是否最后一页
     *
     * @return
     */
    @ApiModelProperty(required = false, value = "是否为最后一页")
    public boolean isLastPage();

    /**
     * 返回下页的页号
     */
    @ApiModelProperty(required = false, value = "下一页页码")
    public int getNextPage();

    /**
     * 返回上页的页号
     */
    @ApiModelProperty(required = false, value = "上一页页码")
    public int getPrePage();
}