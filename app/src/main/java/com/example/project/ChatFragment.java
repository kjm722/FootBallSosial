package com.example.project;

import static android.widget.Toast.makeText;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChatFragment extends Fragment {
    private View view;
    private ListView chatList;
    private String title;
    private String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_chat,container,false);
        chatList=view.findViewById(R.id.chatList1);

        ChatListItem clAdapter=new ChatListItem();
        FloatingActionButton fab2=view.findViewById(R.id.fab2);


        chatList.setAdapter(clAdapter);
        clAdapter.addChatList("맨시티 첼시 4:4 난타전","qoad123");
        clAdapter.addChatList("나이키 축구화 대박 세일","mzkxn753");
        clAdapter.addChatList("매칭 비매너 개쩌네","okc654");
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder dlg=new AlertDialog.Builder(getActivity());

                // Inflate the layout for this fragment
                LayoutInflater inflater = ChatFragment.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.makecomunty, null);

                EditText cet1=dialogView.findViewById(R.id.cet1);
                EditText cet2=dialogView.findViewById(R.id.cet2);
                dlg.setView(dialogView);

                dlg.setNegativeButton("닫기",null);

                dlg.setPositiveButton("생성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        makeText(getActivity().getApplicationContext(),"게시글이 생성되었습니다", Toast.LENGTH_LONG).show();
                        title=cet1.getText().toString();
                        text=cet2.getText().toString();
                        clAdapter.addChatList(title,text);
                        clAdapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
            }
        });
        return view;

    }

}