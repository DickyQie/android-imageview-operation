package com.zhangqie.pictureoperation.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.zhangqie.pictureoperation.R;
import com.zhangqie.pictureoperation.widget.TounChImageView;

/**
 * Created by zhangqie on 2017/6/20.
 */

public class ViewPagerImageViewZQUI extends AppCompatActivity {


    ViewPager viewPager;


    private int[] mImgs = new int[] {
            R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.tour
    };
    ImageView[] mImageViews;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        initView();
    }

    private void initView(){
        mImageViews= new ImageView[mImgs.length];
        viewPager= (ViewPager) findViewById(R.id.img_viewpager);
        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //可以使用其他的ImageView 控件
                TounChImageView tounChImageView=new TounChImageView(ViewPagerImageViewZQUI.this);
                try {
                    Picasso.with(ViewPagerImageViewZQUI.this).load(mImgs[position])
                            .placeholder(R.mipmap.img1)//默认显示的图片
                           // .resize(500,300)//控制图片高度，不添加则自适应
                            .error(R.mipmap.ic_launcher)//加载时出现错误显示的图片
                            .into(tounChImageView);
                } catch (Exception e) {

                }
                //单击返回
                tounChImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                container.addView(tounChImageView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                mImageViews[position] = tounChImageView;
                return tounChImageView;
            }

            @Override
            public int getCount() {
                return mImgs.length;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews[position]);
            }
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
        });
    }
}
