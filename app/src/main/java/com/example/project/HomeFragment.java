package com.example.project;

import static android.R.layout.*;
import static android.widget.Toast.makeText;

import static com.example.project.R.id.homebtn1;
import static com.example.project.R.layout.makematch;


import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private View view;
    private ListView homeList;
    private String selName;
    private int selectMonth;
    private int selectDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_home,container,false);
        homeList=view.findViewById(R.id.homeList1);
        HomeListItem hlAdapter=new HomeListItem();
        homeList.setAdapter(hlAdapter);
        FloatingActionButton fab1=view.findViewById(R.id.fab1);

        hlAdapter.addHomeList("오정대공원","11월 24일","14:00~16:00");
        hlAdapter.addHomeList("인천대공원","11월 25일","07:00~09:00");
        hlAdapter.addHomeList("원적산공원","11월 27일","18:00~20:00");

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg=new AlertDialog.Builder(getActivity());
                dlg.setTitle("경기 생성");

                // Inflate the layout for this fragment
                LayoutInflater inflater = HomeFragment.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.makematch, null);

                DatePicker mdp1 = dialogView.findViewById(R.id.mdp1);
                TimePicker mtp1 = dialogView.findViewById(R.id.mtp1);
                EditText met1 = dialogView.findViewById(R.id.met1);

                dlg.setView(dialogView);

                dlg.setNegativeButton("닫기",null);

                mdp1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectMonth=mdp1.getMonth()+1;
                        selectDay=mdp1.getDayOfMonth();
                    }
                });

                dlg.setPositiveButton("생성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        makeText(getActivity().getApplicationContext(),"매치가 생성되었습니다",Toast.LENGTH_LONG).show();
                        selName=met1.getText().toString();
                        String day=Integer.toString(selectMonth)+"월"+Integer.toString(selectDay)+"일";
                        String time=Integer.toString(mtp1.getCurrentHour())+"시"+Integer.toString(mtp1.getCurrentMinute())+"분";
                        hlAdapter.addHomeList(selName,day,time);
                        hlAdapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
            }
        });
        return view;
    }
}