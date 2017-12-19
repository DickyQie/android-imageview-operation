package com.zhangqie.pictureoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhangqie.pictureoperation.ui.HdImgActivity;
import com.zhangqie.pictureoperation.ui.TounImageViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:
                startActivity(new Intent(MainActivity.this, HdImgActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, TounImageViewActivity.class));
                break;
        }
    }
}
