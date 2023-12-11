package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class ChatListItem extends BaseAdapter {
    ArrayList<ChatList> chatlist=new ArrayList<>();
    @Override
    public int getCount() {
        return chatlist.size();
    }

    @Override
    public Object getItem(int position) {
        return chatlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context c= parent.getContext();
        if (convertView==null){
            LayoutInflater li= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=li.inflate(R.layout.chatcustom,parent,false);
        }
        TextView chatcustom1=convertView.findViewById(R.id.chatcustom1);
        TextView chatcustom2=convertView.findViewById(R.id.chatcustom2);
        LinearLayout chatcustom=convertView.findViewById(R.id.chatlayout);
        ChatList cl=chatlist.get(position);
        chatcustom1.setText(cl.getTitle());
        chatcustom2.setText(cl.getWriter());
        chatcustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(c,Comunity.class);
                intent.putExtra("title",chatcustom1.getText().toString());
                intent.putExtra("text",chatcustom2.getText().toString());
                c.startActivity(intent);
            }
        });
        return convertView;
    }
    public void addChatList(String title, String writer){
        ChatList cl=new ChatList();

        cl.setTitle(title);
        cl.setWriter(writer);

        chatlist.add(cl);
    }
}
