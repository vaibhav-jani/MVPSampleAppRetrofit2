package com.example.vaibhav.testmvp.ws.retrofit;

import com.example.vaibhav.testmvp.ws.entity.SampleResponse;
import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiInterface {

    @GET("jokes/random/10")
    Call<SampleResponse> getSampleEndPointResponse(@Query("firstName") String firstName, @Query("lastName") String lastName);

    @GET("download/peace_problem.ZIP")
    Call<ResponseBody> download();

    /*@GET("download/sample")
    public Call<ResponseBody> download(@Query(value = "accessToken") String accessToken,
                                       @Query(value = "readOnly") boolean readOnly);

    @Multipart
    @POST("upload/sample")
    public Call<String> upload(@Query(value = "name") String fileName,
                                @Query(value = "accessToken") String accessToken,
                                @Part("file") RequestBody file);*/
}