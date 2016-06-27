package com.example.vaibhav.testmvp.ws.retrofit;

public interface ProgressListener {

    void update(long bytesRead, long contentLength, boolean done);
}