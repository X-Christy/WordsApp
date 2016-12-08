package cn.edu.bistu.cs.se.wordsapp;

public interface HttpCallBack {
    void onSuccess(String result);
    void onFailure(String exception);
}
