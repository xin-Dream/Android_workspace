package com.dream.infomanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private TextView et_user_name;
    private TextView et_psw;
    private TextView et_psw_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register=(Button)findViewById(R.id.btn_register);
        et_user_name=(TextView)findViewById(R.id.et_user_name);
        et_psw=(TextView)findViewById(R.id.et_psw);
        et_psw_again=(TextView)findViewById(R.id.et_psw_again);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et_user_name.getText().toString().trim();
                String password=et_psw.getText().toString();
                String password_again=et_psw_again.getText().toString();

                if(numberjudge(username,password,password_again)){
                    //保存用户信息
                    boolean isSaveSuccess=SavePWD.saveUserInfo(RegisterActivity.this,username,password);

                    if (isSaveSuccess){
                        Toast.makeText(RegisterActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                        jump2Login();
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"保存失败",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }


    private boolean numberjudge(String username,String password,String password_again){

        if (username==null){
            Toast.makeText(RegisterActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password==null){
            Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password_again==null){
            Toast.makeText(RegisterActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (password!=password_again){
            Toast.makeText(RegisterActivity.this, "密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(password_again)){
            Toast.makeText(RegisterActivity.this, "密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    private void jump2Login(){
        Intent intent=new Intent(this, com.dream.infomanage.LoginActivity.class);
        startActivity(intent);
    }
}