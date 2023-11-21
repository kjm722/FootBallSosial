package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ChatFragment extends Fragment {
    private View view;
    private ListView chatList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_chat,container,false);
        chatList=view.findViewById(R.id.chatList1);
        ChatListItem clAdapter=new ChatListItem();
        chatList.setAdapter(clAdapter);
        clAdapter.addChatList("맨시티 첼시 4:4 난타전","qoad123");
        clAdapter.addChatList("나이키 축구화 대박 세일","mzkxn753");
        clAdapter.addChatList("매칭 비매너 개쩌네","okc654");
        return view;
    }
}