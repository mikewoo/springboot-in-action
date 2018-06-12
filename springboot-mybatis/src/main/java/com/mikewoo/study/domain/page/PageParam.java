package com.mikewoo.study.domain.page;

/**
 * 分页查询参数
 *
 * @auther Phantom Gui
 * @date 2018/6/12 16:06
 */
public class PageParam {

    private Integer beginLine; // 起始行位置

    private Integer pageSize = 3; // 每页记录数，默认每页3条记录

    private Integer currentPage = 1; // 当前页,默认为第一页

    public Integer getBeginLine() {
        return pageSize * (currentPage - 1);
    }

    public void setBeginLine(Integer beginLine) {
        this.beginLine = beginLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
