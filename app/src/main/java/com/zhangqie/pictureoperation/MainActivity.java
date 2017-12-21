package com.zhangqie.pictureoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhangqie.pictureoperation.photoview.LauncherActivity;
import com.zhangqie.pictureoperation.ui.HdImgActivity;
import com.zhangqie.pictureoperation.ui.TounImageViewActivity;
import com.zhangqie.pictureoperation.ui.ViewPagerImageViewZQUI;
import com.zhangqie.pictureoperation.ui.ZoomImageActivity;

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
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);

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
            case R.id.button3:
                startActivity(new Intent(MainActivity.this,ZoomImageActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this,ViewPagerImageViewZQUI.class));
                break;
            case R.id.button5:
                startActivity(new Intent(MainActivity.this,LauncherActivity.class));
                break;
        }
    }
}
