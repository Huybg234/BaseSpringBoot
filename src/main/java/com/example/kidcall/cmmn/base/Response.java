package com.example.kidcall.cmmn.base;

import lombok.Data;

import java.util.List;

//This class defind response return when API return response:
@Data
public class Response {

    private List<?> dataList;

    private Object data;

    private String message;

    public Response setDataList(List<?> dataList) {
        this.dataList = dataList;
        return this;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }
}
