package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class botVsPlayerForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot_vs_player_form);
    }
    public void submitfun(View v)
    {
        String text;
        EditText t1;
        t1=findViewById(R.id.player1txtbox);
        text=t1.getText().toString();
        if(t1.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter your name ", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent j = new Intent(this, levelsInGame.class);
            j.putExtra("key", text);//key used to access it on next page
            startActivity(j);
        }
    }
}