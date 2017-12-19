package com.zhangqie.pictureoperation.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.pictureoperation.R;
import com.zhangqie.pictureoperation.widget.TounChImageView;

/**
 * Created by zhangqie on 2017/6/19.
 */

public class TounImageViewActivity extends AppCompatActivity {

    TounChImageView tounChImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toun_layout);
        initView();
    }

    public void initView(){
        tounChImageView= (TounChImageView) findViewById(R.id.toun_image);

    }
}
