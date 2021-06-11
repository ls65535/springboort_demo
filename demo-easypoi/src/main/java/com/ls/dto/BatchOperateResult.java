package com.ls.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchOperateResult implements Serializable {

    private static final long serialVersionUID = 8910848019173616901L;
    private boolean success;
    private int successNum;
    private int totalNum;
    private List<Long> list;
    private Map<Object, Object> failInfo;
    public Map<String, Object> resultInfo;


    public BatchOperateResult(boolean success, int totalNum, int successNum, Map<Object, Object> failInfo, List<Long> list) {
        this.success = success;
        this.totalNum = totalNum;
        this.successNum = successNum;
        this.failInfo = failInfo;
        this.resultInfo = new HashMap();
        this.list = list;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getSuccessNum() {
        return this.successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Map<Object, Object> getFailInfo() {
        return this.failInfo;
    }

    public void setFailInfo(Map<Object, Object> failInfo) {
        this.failInfo = failInfo;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public Map<String, Object> getResultInfo() {
        this.resultInfo.put("totalNum", this.totalNum);
        this.resultInfo.put("successNum", this.successNum);
        this.resultInfo.put("failInfo", this.failInfo);
        return this.resultInfo;
    }
}
