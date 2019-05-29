package com.renanparis.chat.callback;

import android.content.Context;
import android.widget.Toast;

import com.renanparis.chat.activity.ChatActivity;
import com.renanparis.chat.model.Message;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiveCallBack implements Callback<Message> {

    private Context context;

    public ReceiveCallBack(Context context) {
        this.context = context;
    }


    @Override
    public void onResponse(Call<Message> call, Response<Message> response) {

        if (response.isSuccessful()){
            Message message = response.body();
            ChatActivity chatActivity = new ChatActivity();
            chatActivity.addPostInChat(message);
        }

    }

    @Override
    public void onFailure(Call<Message> call, Throwable t) {

        Toast.makeText(context,
                "Falha em receber a mensagem", Toast.LENGTH_SHORT).show();

    }
}
