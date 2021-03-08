package com.example.exam_imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class EnlargeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);
    }

    public void clickFunc() {
        Intent backToSecond = new Intent(EnlargeActivity.this, GalleryActivity.class);
        startActivity(backToSecond);
    }
}