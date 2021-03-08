package com.example.exam_imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void pressClickFunc(View v) {
        Intent moveToSecond = new Intent(MainActivity.this, GalleryActivity.class);
        startActivity(moveToSecond);
    }
}