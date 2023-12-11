package com.example.project;

import static android.widget.Toast.makeText;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;



public class MypageFragment extends Fragment {
    private View view;
    private Button btnLogout, btnPlay;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mypage,container,false);


        btnPlay=view.findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg=new AlertDialog.Builder(getActivity());
                dlg.setTitle("Warning!!");
                dlg.setMessage("현재 개발 중입니다.");

                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });

        btnLogout=view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg=new AlertDialog.Builder(getActivity());
                dlg.setTitle("Logout");
                dlg.setMessage("로그아웃 하시겠습니까?");

                dlg.setNegativeButton("취소",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        makeText(getActivity().getApplicationContext(),"로그아웃 성공", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                });
                dlg.show();
            }
        });
        return view;
    }
}