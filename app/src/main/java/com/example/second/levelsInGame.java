package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levelsInGame extends AppCompatActivity {
private String pname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_in_game);
        pname=getIntent().getStringExtra("key");
    }
    public void nextpage(View v)
    {
        Button b1=(Button) v;
        String mode="easy";
        String value=b1.getText().toString();
        mode=value;
        Intent i=new Intent(this,botvsplayer.class);
        i.putExtra("mode",mode);
        i.putExtra("key",pname);
        startActivity(i);

    }
}