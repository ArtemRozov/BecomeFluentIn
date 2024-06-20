package com.example.becomefluentin.api;

import com.example.becomefluentin.modules.AuthResponse;
import com.example.becomefluentin.modules.LoginModel;
import com.example.becomefluentin.modules.Module;
import com.example.becomefluentin.modules.RegisterModel;
import com.example.becomefluentin.modules.User;
import com.example.becomefluentin.modules.Word;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("api/Auth/login")
    Call<AuthResponse> login(@Body LoginModel loginModel);

    @GET("api/user/me")
    Call<User> getUserInfo(@Header("Authorization") String token);

    @POST("api/Auth/register")
    Call<Void> register(@Body RegisterModel registerModel);

    @GET("api/module/all/user/{userId}")
    Call<List<Module>> getUserModules(@Path("userId") int userId);

    @GET("api/word/user/{userId}")
    Call<List<Word>> getModuleWords(@Path("userId") int userId);
}
