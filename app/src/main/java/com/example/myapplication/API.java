package com.example.myapplication;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("signup")
    Call<ResponseBody> createUser (
            @Body RegistrationForm form
    );

    @POST("signin")
    Call<ResponseBody> checkUser (
            @Body LoginForm form
    );
}
