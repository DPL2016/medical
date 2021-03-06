package com.kaishengit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONResult {
    public static final String DTO_STATE_SUCCESS = "success";
    public static final String DTO_STATE_ERROR = "error";
    private String state;
    private String message;
    private Object data;

    public JSONResult(String state, Object data) {
        this.state = state;
        this.data = data;
    }

    public JSONResult(String message, String state) {
        this.message = message;
        this.state = state;
    }

    public JSONResult(String message) {
        this(DTO_STATE_SUCCESS,message);
    }

    public JSONResult(Object data) {
        this(DTO_STATE_SUCCESS,data);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
