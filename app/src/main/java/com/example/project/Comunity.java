package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Comunity extends AppCompatActivity {
    ChatFragment chatFragment=new ChatFragment();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comunity);
        Intent intent=getIntent();
        String title=intent.getExtras().get("title").toString();
        String text=intent.getExtras().get("text").toString();
        TextView tv1=(TextView)findViewById(R.id.tv1);
        TextView tv2=(TextView)findViewById(R.id.tv2);
        Button btnBack=(Button)findViewById(R.id.btnBack);
        tv1.setText(title);
        tv2.setText(text);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
