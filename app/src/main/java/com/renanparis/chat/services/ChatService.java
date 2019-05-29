package com.renanparis.chat.services;

import com.renanparis.chat.model.Message;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ChatService {

    @POST("polling")
    Call<Void> sendMessage(@Body Message posts);

    @GET("polling")
    Call<Message> receiveMessage();


}
