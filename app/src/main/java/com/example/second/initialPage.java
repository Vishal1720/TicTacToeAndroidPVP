package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class initialPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_page);
    }
    public void gotobvpform(View v)
    {
        Intent i=new Intent(this, botVsPlayerForm.class);
        startActivity(i);
    }
    public void gotopvpform(View v)
    {
        Intent i=new Intent(this, playerVsPlayerForm.class);
        startActivity(i);
    }
}