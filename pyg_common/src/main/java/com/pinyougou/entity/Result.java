package com.pinyougou.entity;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @author: itXiaoKe
 * @date: 2020/1/21 13:39
 * @Description: 返回结果集
 * @Version: 1.0
 */
public class Result implements Serializable {
    private boolean success;
    private String message;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
