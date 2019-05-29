package com.renanparis.chat.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.renanparis.chat.R;
import com.renanparis.chat.model.Message;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    private List<Message> posts;
    private Context context;
    private int idClient;

    public ChatAdapter(List<Message> posts, Context context, int idClient) {
        this.posts = posts;
        this.context = context;
        this.idClient = idClient;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Message getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return posts.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_chat, parent, false);

        TextView fieldPost = view.findViewById(R.id.item_chat_text);
        Message message = getItem(position);
        if (idClient != message.getId()){

            view.setBackgroundColor(Color.CYAN);
        }

        fieldPost.setText(message.getText());

        return view;
    }
}
