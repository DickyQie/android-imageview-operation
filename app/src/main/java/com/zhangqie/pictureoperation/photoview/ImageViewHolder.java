package com.zhangqie.pictureoperation.photoview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangqie.pictureoperation.R;

/**
 * Image in recyclerview
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {

    public static ImageViewHolder inflate(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    public TextView mTextTitle;

    public ImageViewHolder(View view) {
        super(view);
        mTextTitle = (TextView) view.findViewById(com.zhangqie.photoview.R.id.title);
    }

    private void bind(String title) {
        mTextTitle.setText(title);
    }
}
