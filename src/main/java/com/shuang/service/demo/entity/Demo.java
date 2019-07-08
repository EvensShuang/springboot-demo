package com.rograndec.service.demo.entity;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Demo", description = "Demo")
public class Demo implements Serializable {
    private static final long serialVersionUID = 5215922643962455903L;
    @ApiModelProperty(value = "文章的id主键")
    private Integer           aid;
    @ApiModelProperty(value = "文章标题")
    private String            title;
    @ApiModelProperty(value = "文章作者")
    private String            author;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
