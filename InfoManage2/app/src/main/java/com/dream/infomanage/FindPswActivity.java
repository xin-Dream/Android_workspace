package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FindPswActivity extends AppCompatActivity {

    private TextView tv_back;
    private TextView tv_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_psw);

        tv_back=(TextView)findViewById(R.id.tv_back);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);

        tv_back.setVisibility(View.VISIBLE);

        Intent intent=getIntent();
        int exvalue=intent.getIntExtra("form",3);
        if (exvalue==0){
            tv_main_title.setText("设置密保");
        }

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2setting();
            }
        });
    }

    public void jump2setting(){
        Intent intent=new Intent(this,SettingActivity.class);
        startActivity(intent);
    }

}