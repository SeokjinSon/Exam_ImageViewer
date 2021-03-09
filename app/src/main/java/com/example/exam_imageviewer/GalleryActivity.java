package com.example.exam_imageviewer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GalleryActivity extends AppCompatActivity {
    private Resources                   appRes;
    private GridLayout                  galleryViewLayout;
    private int[]                       imgResIds;
    private Intent                      moveToThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        initApp();
        get_ImageId();
        show_Image();
    }

    public void initApp() {
        appRes              = this.getResources();
        galleryViewLayout   = findViewById(R.id.galleryViewLayout);

        imgResIds           = new int[10];
        moveToThird         = new Intent(GalleryActivity.this, EnlargeActivity.class);
    }

    public void get_ImageId() {
        for(int i=0; i<10; i++) {
            imgResIds[i] =  getResources().getIdentifier("marvel_" + String.valueOf(i), "drawable", getPackageName());
        }

    }

    public void show_Image() {
        for(int i=0; i<10; i++) {
            galleryViewLayout.addView(make_ImageView(i));
        }
    }

    public ImageView make_ImageView(int i) {
        ImageView imgView = new ImageView(this);
        Bitmap bmp = BitmapFactory.decodeResource(appRes, imgResIds[i]);
        bmp = Bitmap.createScaledBitmap(bmp, 360, 340, false);

        imgView.setId(i);
        imgView.setAdjustViewBounds(true);
        imgView.setImageBitmap(bmp);
        //imgView.setImageDrawable(appRes.getDrawable(imgResIds[i]));
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(String.valueOf(v.getId()), "클릭한 이미지 뷰 값");
                moveToThird.putExtra("picture_Number", imgResIds[v.getId()]);
                startActivity(moveToThird);
            }
        });
        return imgView;
    }
}