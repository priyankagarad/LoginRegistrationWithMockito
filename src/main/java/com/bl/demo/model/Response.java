package com.bl.demo.model;

public class Response {
    public String message;
    public Object data;

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}

