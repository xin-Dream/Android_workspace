package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    private TextView tv_back;
    private TextView tv_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        tv_back=(TextView)findViewById(R.id.tv_back);
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);

        tv_main_title.setText("个人信息");
        tv_back.setVisibility(View.VISIBLE);


        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2main();
            }
        });
    }

    private void jump2main(){
        Intent intent=new Intent(this, com.dream.infomanage.MyInfoActivity.class);
        startActivity(intent);
    }
}