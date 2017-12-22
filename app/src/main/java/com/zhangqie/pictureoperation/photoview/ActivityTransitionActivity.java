package com.zhangqie.pictureoperation.photoview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zhangqie.pictureoperation.R;

public class ActivityTransitionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new GridLayoutManager(this, 2));
        ImageAdapter imageAdapter = new ImageAdapter(new ImageAdapter.Listener() {
            @Override
            public void onImageClicked(View view) {
                transition(view);
            }
        });
        list.setAdapter(imageAdapter);
    }

    private void transition(View view) {
        if (Build.VERSION.SDK_INT < 21) {
            Toast.makeText(ActivityTransitionActivity.this, "21+ only, keep out", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(ActivityTransitionActivity.this, ActivityTransitionToActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(ActivityTransitionActivity.this, view, getString(R.string.transition_test));
            startActivity(intent, options.toBundle());
        }
    }
}
