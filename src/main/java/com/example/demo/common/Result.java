package com.example.demo.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;
    public static Result success(Object data){
        Result result= new Result();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(String msg){
        Result result= new Result();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

}
