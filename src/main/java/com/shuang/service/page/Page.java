package com.shuang.service.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 列表分页。包含list属性。
 */
@ApiModel(value = "Page")
public class Page<T> extends com.shuang.service.page.SimplePage implements java.io.Serializable, com.shuang.service.page.Paginable {

    private static final long serialVersionUID = 3684754322692323329L;

    public Page() {
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     */
    public Page(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     * @param list       分页内容
     */
    public Page(int pageNo, int pageSize, int totalCount, List<T> list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    /**
     * 第一条数据位置
     *
     * @return
     */
    @ApiModelProperty(required = false, value = "第一条数据位置", hidden = true)
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 当前页的数据
     */
    @ApiModelProperty(required = false, value = "当前页的数据")
    private List<T> list;

    /**
     * 获得分页内容
     *
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置分页内容
     *
     * @param list
     */
    @SuppressWarnings("unchecked")
    public void setList(List<T> list) {
        this.list = list;
    }
}