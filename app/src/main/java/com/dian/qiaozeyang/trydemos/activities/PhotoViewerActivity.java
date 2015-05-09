package com.dian.qiaozeyang.trydemos.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.dian.qiaozeyang.trydemos.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by dianmobile on 15/5/6.
 */
public class PhotoViewerActivity extends Activity{
    ImageView imageView;
    PhotoViewAttacher mAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        imageView = (ImageView)findViewById(R.id.image);
        Drawable bitmap = getResources().getDrawable(R.mipmap.ic_launcher);
        imageView.setImageDrawable(bitmap);
        mAttacher = new PhotoViewAttacher(imageView);

    }
}
