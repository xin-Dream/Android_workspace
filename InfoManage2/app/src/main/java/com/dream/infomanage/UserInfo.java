package com.dream.infomanage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {

    //保存账号密码
    public static boolean saveUserInfo(Context context,String username,String password){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();

        edit.putString("username",username);
        edit.putString("password",password);
        edit.commit();

        return true;
    }

    //从data.xml中读取账号密码
    public static Map<String,String> getUserInfo(Context context){

        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String username=sp.getString("username",null);
        String password=sp.getString("password",null);

        Map<String,String>userMap=new HashMap<String, String>();
        userMap.put("username",username);
        userMap.put("password",password);

        return userMap;
    }

    //清除账户密码
    public static boolean clearUserInfo(Context context){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();

        edit.clear();
//        edit.remove("UserName");
//        edit.remove("pwd");
        edit.commit();

        return true;
    }

    // 保存用户状态
    public static boolean saveUserState(Context context,String state){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();

        edit.putString("state",state);

        edit.commit();

        return true;
    }

    //清除用户状态
    public static boolean clearUserState(Context context){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();


        edit.remove("state");
//        edit.remove("pwd");
        edit.commit();

        return true;
    }

    //从data.xml中读取当前用户状态
    public static Map<String,String> getUserState(Context context){

        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String state=sp.getString("state",null);

        Map<String,String>userMap=new HashMap<String, String>();
        userMap.put("state",state);

        return userMap;
    }


}
