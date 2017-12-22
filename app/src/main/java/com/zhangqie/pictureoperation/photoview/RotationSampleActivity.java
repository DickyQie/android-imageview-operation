
package com.zhangqie.pictureoperation.photoview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zhangqie.photoview.PhotoView;
import com.zhangqie.pictureoperation.R;


public class RotationSampleActivity extends AppCompatActivity {

    private PhotoView photo;
    private final Handler handler = new Handler();
    private boolean rotating = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.rotation);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_rotate_10_right:
                        photo.setRotationBy(10);
                        return true;
                    case R.id.action_rotate_10_left:
                        photo.setRotationBy(-10);
                        return true;
                    case R.id.action_toggle_automatic_rotation:
                        toggleRotation();
                        return true;
                    case R.id.action_reset_to_0:
                        photo.setRotationTo(0);
                        return true;
                    case R.id.action_reset_to_90:
                        photo.setRotationTo(90);
                        return true;
                    case R.id.action_reset_to_180:
                        photo.setRotationTo(180);
                        return true;
                    case R.id.action_reset_to_270:
                        photo.setRotationTo(270);
                        return true;
                }
                return false;
            }
        });
        photo = (PhotoView) findViewById(R.id.iv_photo);
        photo.setImageResource(R.mipmap.wallpaper);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
    }

    private void toggleRotation() {
        if (rotating) {
            handler.removeCallbacksAndMessages(null);
        } else {
            rotateLoop();
        }
        rotating = !rotating;
    }

    private void rotateLoop() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                photo.setRotationBy(1);
                rotateLoop();
            }
        }, 15);
    }
}
