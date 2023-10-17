package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class playerVsPlayerForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vs_player_form);
    }
    public void submitpvp(View v)
    {
        EditText p1,p2;
        p1=findViewById(R.id.player1txtbox);
        p2=findViewById(R.id.player2txtbox);

        if(p1.getText().toString().isEmpty() && p2.getText().toString().isEmpty()) Toast.makeText(this,"Enter player 1 and player 2 name",Toast.LENGTH_SHORT).show();
        else if(p1.getText().toString().isEmpty())Toast.makeText(this,"Enter player 1's name",Toast.LENGTH_SHORT).show();
        else if(p2.getText().toString().isEmpty())Toast.makeText(this,"Enter player 2's name",Toast.LENGTH_SHORT).show();
        else {
            Intent i=new Intent(this, MainActivity.class);
            i.putExtra("p1",p1.getText().toString());
            i.putExtra("p2",p2.getText().toString());
            startActivity(i);
        }
    }
}