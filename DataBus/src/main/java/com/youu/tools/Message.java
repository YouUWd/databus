package com.youu.tools;

public class Message {

    private long timestamp;

    private String method;

    private String msg;

    public Message() {

    }

    public Message(long timestamp, String method, String msg) {
        this.timestamp = timestamp;
        this.method = method;
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message [timestamp=" + timestamp + ", method=" + method + ", msg=" + msg + "]";
    }

}
