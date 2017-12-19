package com.zhangqie.pictureoperation.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.pictureoperation.R;

import xyz.zpayh.hdimage.HDImageView;

/**
 * Created by zhangqie on 2017/6/19.
 */

public class HdImgActivity extends AppCompatActivity {

    HDImageView hdImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hdimageview);
        initView();
    }

    private void initView(){
        hdImageView= (HDImageView) findViewById(R.id.img_hdimageview);
        hdImageView.setImageURI("http://scb.liaidi.com//data//image//photo//2017//12//20171213114649105288.jpg");
    }


}
