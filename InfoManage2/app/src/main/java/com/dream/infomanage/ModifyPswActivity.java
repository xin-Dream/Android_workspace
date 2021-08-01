package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ModifyPswActivity extends AppCompatActivity {

    private TextView tv_back;
    private TextView tv_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_psw);

        tv_back=(TextView)findViewById(R.id.tv_back);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);

        tv_back.setVisibility(View.VISIBLE);
        tv_main_title.setText("修改密码");

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