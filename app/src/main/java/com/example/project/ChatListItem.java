package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        ChatList cl=chatlist.get(position);
        chatcustom1.setText(cl.getTitle());
        chatcustom2.setText(cl.getWriter());
        return convertView;
    }
    public void addChatList(String title, String writer){
        ChatList cl=new ChatList();

        cl.setTitle(title);
        cl.setWriter(writer);

        chatlist.add(cl);
    }
}
