package com.lee.community.dto;

public class PageListJSON {
    private String code;
    private long total;
    private Object data;

    public PageListJSON() {
    }

    public PageListJSON(String code, long total, Object data) {
        this.code = code;
        this.total = total;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
