
package com.zhangqie.pictureoperation.photoview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangqie.pictureoperation.R;

public class LauncherActivity extends AppCompatActivity {

    public static final String[] options = {
            "Simple",
            "ViewPager ",
            "Rotation ",
            "Picasso ",
            "Activity Transition ",
            "Immersive "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter());
    }


    private static class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final ItemViewHolder holder = ItemViewHolder.newInstance(parent);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Class clazz;

                    switch (holder.getAdapterPosition()) {
                        default:
                        case 0:
                            clazz = SimpleSampleActivity.class;
                            break;
                        case 1:
                            clazz = ViewPagerActivity.class;
                            break;
                        case 2:
                            clazz = RotationSampleActivity.class;
                            break;
                        case 3:
                            clazz = PicassoSampleActivity.class;
                            break;
                        case 4:
                            clazz = ActivityTransitionActivity.class;
                            break;
                        case 5:
                            clazz = ImmersiveActivity.class;
                    }

                    Context context = holder.itemView.getContext();
                    context.startActivity(new Intent(context, clazz));
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(final ItemViewHolder holder, int position) {
            holder.bind(options[position]);
        }

        @Override
        public int getItemCount() {
            return options.length;
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        public static ItemViewHolder newInstance(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_sample, parent, false);
            return new ItemViewHolder(view);
        }

        public TextView mTextTitle;

        public ItemViewHolder(View view) {
            super(view);
            mTextTitle = (TextView) view.findViewById(R.id.title);
        }

        private void bind(String title) {
            mTextTitle.setText(title);
        }
    }
}
