package com.changzheng.diyadapter;

/**
 * Created by changzheng on 16/3/18.
 * 聊天信息
 */
public class ChatMessage {
//    private int id;
    public int id;  //chatmessage.id直接引用代替 chatmessage.getid 间接应用
    public String message;
    public boolean isSelf;//该信息是否为自己发的
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public boolean isSelf() {
//        return isSelf;
//    }
//
//    public void setIsSelf(boolean isSelf) {
//        this.isSelf = isSelf;
//    }
}
