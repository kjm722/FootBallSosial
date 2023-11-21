package com.example.project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.crypto.Mac;
public class HomeListItem extends BaseAdapter {
    
    ArrayList<HomeList> homelist=new ArrayList<>();
    @Override
    public int getCount() {
        return homelist.size();
    }

    @Override
    public Object getItem(int position) {
        return homelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context c= parent.getContext();
        View dialogView=View.inflate(c,R.layout.match,null);
        AlertDialog.Builder dlg=new AlertDialog.Builder(c);
        dlg.setTitle("매치 참가 확인");
        dlg.setView(dialogView);
        dlg.setNegativeButton("닫기",null);
        dlg.setPositiveButton("확정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(c.getApplicationContext(),"매치 참가 확정되었습니다",Toast.LENGTH_LONG).show();
            }
        });
        if (convertView==null){
            LayoutInflater li= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=li.inflate(R.layout.homecutom,parent,false);
        }
        Button homebtn1=(Button)convertView.findViewById(R.id.homebtn1);
        TextView homecustom1=convertView.findViewById(R.id.homecustom1);
        TextView homecustom2=convertView.findViewById(R.id.homecustom2);
        TextView homecustom3=convertView.findViewById(R.id.homecustom3);
        HomeList hl=homelist.get(position);
        homecustom3.setText(hl.getDay());
        homecustom1.setText(hl.getName());
        homecustom2.setText(hl.getTime());
        homecustom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.show();
            }
        });
        homecustom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.show();
            }
        });
        homebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.show();
            }
        });
        return convertView;
    }
    public void addHomeList(String name, String day,String time){
        HomeList hl=new HomeList();

        hl.setName(name);
        hl.setDay(day);
        hl.setTime(time);

        homelist.add(hl);
    }
}
