package com.example.vaibhav.testmvp.ws;

import com.example.vaibhav.testmvp.BaseApp;
import com.example.vaibhav.testmvp.utils.FileUtils;
import com.example.vaibhav.testmvp.utils.Logger;
import com.example.vaibhav.testmvp.ws.entity.SampleRequest;
import com.example.vaibhav.testmvp.ws.entity.SampleResponse;
import com.example.vaibhav.testmvp.ws.retrofit.ApiInterface;
import com.example.vaibhav.testmvp.ws.retrofit.ProgressListener;
import com.example.vaibhav.testmvp.ws.retrofit.RestClient;
import com.squareup.okhttp.ResponseBody;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;

import retrofit.Call;
import retrofit.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by vaibhav on 30/5/16.
 */
public class AppWs {

    public static Observable<SampleResponse> getSampleEndPointResponse(final SampleRequest request) {

        Observable<SampleResponse> observable = Observable.create(new Observable.OnSubscribe<SampleResponse>() {

            @Override
            public void call(final Subscriber<? super SampleResponse> subscriber) {

                String firstName = request.getFirstName();

                String lastName = request.getLastName();

                Call<SampleResponse> call = RestClient.get().getSampleEndPointResponse(firstName, lastName);

                try {

                    Response<SampleResponse> execute = call.execute();

                    SampleResponse baseResponse = execute.body();

                    if(baseResponse != null) {

                        subscriber.onNext(baseResponse);

                    } else {

                        subscriber.onError(new NullPointerException("Retrofit response is null"));
                    }

                } catch (Exception e) {

                    subscriber.onError(e);

                    Logger.e(e);
                }

            }
        });

        return observable;
    }

    public static Observable<String> download() {

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(final Subscriber<? super String> subscriber) {

                String baseUrl = "http://www.colorado.edu/conflict/peace/";

                try {

                    ApiInterface restClient = RestClient.getProgressiveClient(baseUrl, new ProgressListener() {
                        @Override
                        public void update(long bytesRead, long contentLength, boolean done) {

                            if(contentLength > 0) {

                                subscriber.onNext(String.valueOf((int)((Float.valueOf(bytesRead)/contentLength)*100)));
                            }
                        }
                    });

                    Call<ResponseBody> call = restClient.download();
                    Response<ResponseBody> response = call.execute();

                    String fileName = "sample_download_zip_file";

                    BaseApp baseApp = BaseApp.getInstance();
                    File path = FileUtils.getDataDir(baseApp);

                    //File path = Environment.getExternalStorageDirectory();
                    File file = new File(path, fileName);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    IOUtils.write(response.body().bytes(), fileOutputStream);

                    subscriber.onNext(String.valueOf(100));

                } catch (Exception e) {

                    subscriber.onError(e);

                    Logger.e(e);
                }

            }
        });

        return observable;
    }
}
