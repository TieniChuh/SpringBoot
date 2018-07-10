package com.mbe.vo;


import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Page<T>  {
    private Integer currentPage;// 当前页
    private Integer index;// 索引
    private Integer pageSize = 10;// 每页显示的数据
    private Integer length = 10;
    private Integer pageCount;// 总页数
    private Integer allCount;// 总记录数
    private List<T> list;// 存储的数据

    //指定每页显示的数据数
    public Page(int currentPage, int allCount, int pageSize) {
        this.currentPage = currentPage;
        this.allCount = allCount;
        this.pageSize = pageSize;
        // 初始化索引
        index = (currentPage - 1) * pageSize;
        // 初始化总页数
        if (allCount % pageSize == 0) {
            pageCount = allCount / pageSize;
        } else {
            pageCount = allCount / pageSize + 1;
        }
    }

    // 没有页面记录数的方法重写
    public Page(int currentPage, int allCount) {
        this.currentPage = currentPage;
        this.allCount = allCount;
        // 初始化索引
        index = (currentPage - 1) * pageSize;
        // 初始化总页数
        if (allCount % pageSize == 0) {
            pageCount = allCount / pageSize;
        } else {
            pageCount = allCount / pageSize + 1;
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }
}
