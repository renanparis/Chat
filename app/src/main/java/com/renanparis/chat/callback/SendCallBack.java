package com.renanparis.chat.callback;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendCallBack implements Callback<Void> {

    private Context context;

    public SendCallBack(Context context) {
        this.context = context;
    }


    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {

    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {

        Toast.makeText(context, "Não foi possível enviar Mensagem",
                Toast.LENGTH_LONG).show();


    }
}
