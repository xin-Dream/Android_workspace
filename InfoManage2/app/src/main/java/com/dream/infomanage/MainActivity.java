package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_info;
    private TextView tv_main_title;
    private ImageView bottom_bar_image_myinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_info=(ImageView) findViewById(R.id.iv_info);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        bottom_bar_image_myinfo=(ImageView)findViewById(R.id.bottom_bar_image_myinfo);

        tv_main_title.setText("首页");
        iv_info.setVisibility(View.VISIBLE);

        iv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Myinfo();
            }
        });

        bottom_bar_image_myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2Myinfo();
            }
        });
    }

    public void jump2Myinfo(){
        Intent intent=new Intent(this,MyInfoActivity.class);

        startActivity(intent);
    }
}