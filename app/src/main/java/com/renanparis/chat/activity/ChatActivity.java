package com.renanparis.chat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.renanparis.chat.R;
import com.renanparis.chat.adapter.ChatAdapter;
import com.renanparis.chat.callback.ReceiveCallBack;
import com.renanparis.chat.callback.SendCallBack;
import com.renanparis.chat.model.Message;
import com.renanparis.chat.retrofit.RetrofitPosts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ChatActivity extends AppCompatActivity {

    private List<Message> postsList= new ArrayList<>();
    private ListView listView;
    private ChatAdapter adapter;
    private int idClient = 2;
    private EditText fieldMessage;
    private RetrofitPosts retrofitPosts;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listView = findViewById(R.id.activity_chat_list);
        retrofitPosts = new RetrofitPosts();

        sendButton = findViewById(R.id.activity_btn_chat_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
                receiveMessage();
            }
        });


    }


    public void addPostInChat(Message message){

        postsList.add(message);
        adapter = new ChatAdapter(postsList, this, idClient);
        listView.setAdapter(adapter);

        receiveMessage();

    }

    public void sendMessage(){

        fieldMessage = findViewById(R.id.activity_chat_message);
        String textMessage = fieldMessage.getText().toString();
        Call<Void> call = retrofitPosts.getChatService()
                .sendMessage(new Message(textMessage, idClient));
        call.enqueue(new SendCallBack(this));

    }

    public void receiveMessage(){
        Call<Message> call = new RetrofitPosts().getChatService().receiveMessage();
        call.enqueue(new ReceiveCallBack(this));
    }
}
