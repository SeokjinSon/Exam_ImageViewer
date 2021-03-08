package com.example.exam_imageviewer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {
    private Resources           appRes;
    private GridLayout          galleryViewLayout;
    private int[]               imgResIds;
    private Intent              moveToThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        initApp();
        getImageId();
        showImage();
    }

    public void initApp() {
        appRes              = this.getResources();
        galleryViewLayout   = findViewById(R.id.galleryViewLayout);
        imgResIds           = new int[10];
        moveToThird         = new Intent(GalleryActivity.this, EnlargeActivity.class);
    }

    public void getImageId() {
        for(int i=0; i<10; i++)
            imgResIds[i] =  getResources().getIdentifier("marvel" + String.valueOf(i), "drawable", getPackageName());
    }

    public void showImage() {
        for(int i=0; i<10; i++) {
            ImageView imgView = new ImageView(this);
            imgView.setImageDrawable(appRes.getDrawable(imgResIds[i]));
            galleryViewLayout.addView(imgView);
        }
    }
}