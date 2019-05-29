package com.renanparis.chat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.renanparis.chat.R;
import com.renanparis.chat.adapter.ChatAdapter;
import com.renanparis.chat.model.Posts;

import java.util.Arrays;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        List<Posts> postsList = Arrays.asList(new Posts("Olá tudo bem", 1), new Posts("tudo bem", 2));

        ListView listView = findViewById(R.id.activity_chat_list);

        ChatAdapter adapter = new ChatAdapter(postsList, this, 2);
        listView.setAdapter(adapter);

    }
}
