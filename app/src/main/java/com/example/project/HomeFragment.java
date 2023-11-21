package com.example.project;

import static android.R.layout.*;
import static android.widget.Toast.makeText;

import static com.example.project.R.id.homebtn1;
import static com.example.project.R.id.mTitle;
import static com.example.project.R.layout.makematch;
import static com.example.project.R.layout.match;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private ListView homeList;
    private int selectMonth;
    private int selectDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        homeList=view.findViewById(R.id.homeList1);
        HomeListItem hlAdapter=new HomeListItem();
        homeList.setAdapter(hlAdapter);
        EditText met1=view.findViewById(R.id.met1);
        TimePicker mtp1=view.findViewById(R.id.mtp1);
        DatePicker mdp1=view.findViewById(R.id.mdp1);
        FloatingActionButton fab1=view.findViewById(R.id.fab1);

        hlAdapter.addHomeList("오정대공원","11월 24일","14:00~16:00");
        hlAdapter.addHomeList("인천대공원","11월 25일","07:00~09:00");
        hlAdapter.addHomeList("원적산공원","11월 27일","18:00~20:00");

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"클릭됨",Toast.LENGTH_LONG).show();
                AlertDialog.Builder dlg=new AlertDialog.Builder(getActivity());
                dlg.setTitle("경기 생성");
                dlg.setView(R.layout.makematch);
                dlg.setNegativeButton("닫기",null);
                dlg.setPositiveButton("생성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        makeText(getActivity().getApplicationContext(),"매치가 생성되었습니다",Toast.LENGTH_LONG).show();
                        mdp1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                            @Override
                            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                selectMonth=monthOfYear+1;
                                selectDay=dayOfMonth;
                            }
                        });
                        String day=Integer.toString(selectMonth)+"월"+Integer.toString(selectDay)+"일";
                        String time=Integer.toString(mtp1.getCurrentHour())+"시"+Integer.toString(mtp1.getCurrentMinute())+"분";
                        hlAdapter.addHomeList(met1.getText().toString(),day,time);
                    }
                });
                dlg.show();
            }
        });
        return view;
    }
}