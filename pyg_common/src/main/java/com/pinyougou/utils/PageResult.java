package com.pinyougou.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PageResult
 * @author: itXiaoKe
 * @date: 2020/1/21 10:02
 * @Description: 分页的返回结果集
 * @Version: 1.0
 */
public class PageResult<T> implements Serializable {
    private long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
