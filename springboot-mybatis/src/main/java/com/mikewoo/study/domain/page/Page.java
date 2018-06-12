package com.mikewoo.study.domain.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据封装
 *
 * @auther Phantom Gui
 * @date 2018/6/12 16:25
 */
public class Page<E> implements Serializable {

    private int currentPage = 1; //当前页数
    private long totalPage;       //总页数
    private long totalNumber;    //总记录数
    private List<E> list;        //数据集

    public static Page NULL = new Page(0, 0, 10, new ArrayList());

    public Page() {
        super();
    }

    /**
     * @param beginLine   当前页数
     * @param totalNumber 总记录数
     * @param pageSize    页大小
     * @param list        页数据
     */
    public Page(int beginLine, long totalNumber, int pageSize, List<E> list) {
        super();
        this.currentPage = beginLine / pageSize + 1;
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageSize == 0 ? totalNumber
                / pageSize : totalNumber / pageSize + 1;
    }

    public Page(PageParam pageParam, long totalNumber, List<E> list){
        super();
        this.currentPage = pageParam.getCurrentPage();
        this.totalNumber = totalNumber;
        this.list = list;
        this.totalPage = totalNumber % pageParam.getPageSize() == 0 ? totalNumber
                / pageParam.getPageSize() : totalNumber / pageParam.getPageSize() + 1;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalNumber=" + totalNumber +
                ", list=" + list +
                '}';
    }
}
