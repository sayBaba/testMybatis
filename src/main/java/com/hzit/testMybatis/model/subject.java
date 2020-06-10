package com.hzit.testMybatis.model;


public class subject {
    private Integer subId;

    private String subName;

    private String subType;

    private Integer subTimes;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    public Integer getSubTimes() {
        return subTimes;
    }

    public void setSubTimes(Integer subTimes) {
        this.subTimes = subTimes;
    }
}