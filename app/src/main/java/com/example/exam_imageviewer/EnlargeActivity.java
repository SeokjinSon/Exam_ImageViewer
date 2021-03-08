package com.example.exam_imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class EnlargeActivity extends AppCompatActivity {
    private ImageView enlargeImage;
    private Resources appRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);

        initApp();
        setImage();
    }

    public void initApp() {
        appRes              = this.getResources();
        enlargeImage        = findViewById(R.id.imageView);
    }

    public void setImage() {
        int picture_Number = getIntent().getIntExtra("picture_Number", 1);
        Log.i(String.valueOf(picture_Number), " setImage");
        enlargeImage.setImageDrawable(appRes.getDrawable(picture_Number));
    }

    public void clickFunc(View v) {
        Intent backToSecond = new Intent(EnlargeActivity.this, GalleryActivity.class);
        startActivity(backToSecond);
    }
}