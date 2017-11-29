package com.aventstack.klov.domain;

public class ExceptionAggregationCount {

    private String name;
    private Long total;
    private Long cnt;
    private String precent;
    private String totalStr;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public String getPrecent() {
        return precent;
    }

    public void setPrecent(String precent) {
        this.precent = precent;
    }

    public String getTotalStr() {
        return totalStr;
    }

    public void setTotalStr(String totalStr) {
        this.totalStr = totalStr;
    }
}
