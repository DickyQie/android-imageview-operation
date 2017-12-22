package com.zhangqie.pictureoperation.photoview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.zhangqie.photoview.PhotoView;
import com.zhangqie.pictureoperation.R;


public class PicassoSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        final PhotoView photoView = (PhotoView) findViewById(R.id.iv_photo);

        Picasso.with(this)
                .load("http://scb.liaidi.com//data//image//photo//2017//12//20171213114649105288.jpg")
                .into(photoView);
    }
}
