package com.fruitsalesplatform.entity;

/**
 * 分页类，包含三个属性
 * 开始页面、起始数据位置、每页要取的数据
 */
public class PageEntity {

    //当前页
    private Integer currentPage;
    //起始页
    private Integer startPage;
    //页面的数据大小
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getStartPage() {
        if (startPage==null){
            startPage=0;
        }
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        if (pageSize==null){
            pageSize=10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
