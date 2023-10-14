package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private String c="O";

    private List<TextView> boxes = new ArrayList<>();
    private boolean gameend=false;
    private int  p1stat=0;
    private int p2stat=0;
    private boolean p1win=false;
    private boolean p2win=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxes.add(findViewById(R.id.text0));
        boxes.add(findViewById(R.id.text1));
        boxes.add(findViewById(R.id.text2));
        boxes.add(findViewById(R.id.text3));
        boxes.add(findViewById(R.id.text4));
        boxes.add(findViewById(R.id.text5));
        boxes.add(findViewById(R.id.text6));
        boxes.add(findViewById(R.id.text7));
        boxes.add(findViewById(R.id.text8));
        


    }



    public void clicker(View v)
    {
        TextView turnnwin=findViewById(R.id.turnnwin);
        TextView textView = (TextView) v;
String currentText=textView.getText().toString();

if(!gameend) {
    if (currentText.isEmpty()) {
        textView.setText(c);

        if (c == "O") {
            c = "X";
            turnnwin.setText("Player 2's turn ");
        } else {
            c = "O";
            turnnwin.setText("Player 1's turn ");
        }
        checkwinall();
    }
}
    }
    public void retry(View v)
    {
        // Perform operations on each TextView in the "boxes" list
        // For example, you can access and modify properties of each box.
        // Example:
        for (TextView box : boxes) {
            box.setText("");
        }
        p1win=false;
    p2win=false;
    gameend=false;
    c="O";
        TextView turnnwin=findViewById(R.id.turnnwin);
        turnnwin.setText("Player 1's turn");
    }
    public void checkwin(TextView v1,TextView v2,TextView v3)
    {
        TextView turnnwin=findViewById(R.id.turnnwin);
        if(v1.getText().toString().equals("X")&& v2.getText().toString().equals("X")&& v3.getText().toString().equals("X"))
        {
            p2win=true;
            turnnwin.setText("Player 2 WINS");
            gameend=true;
        }
        if(v1.getText().toString().equals("O")&& v2.getText().toString().equals("O")&& v3.getText().toString().equals("O"))
        {
            p1win=true;
            turnnwin.setText("Player 1 WINS");
            gameend=true;
        }
    }
    public void checkwinall(){
     TextView p1=findViewById(R.id.p1stat);
        TextView p2=findViewById(R.id.p2stat);
        boolean fullbox=true;

        checkwin(boxes.get(0),boxes.get(1),boxes.get(2));
        checkwin(boxes.get(3),boxes.get(4),boxes.get(5));
        checkwin(boxes.get(6),boxes.get(7),boxes.get(8));
        checkwin(boxes.get(0),boxes.get(3),boxes.get(6));
        checkwin(boxes.get(1),boxes.get(4),boxes.get(7));
        checkwin(boxes.get(2),boxes.get(5),boxes.get(8));
        checkwin(boxes.get(0),boxes.get(4),boxes.get(8));
        checkwin(boxes.get(6),boxes.get(4),boxes.get(2));

        for(int i=0;i<9;i++)
        {

            if(boxes.get(i).getText().toString().equals(""))//
            {
               fullbox=false;

            }
        }
        TextView turnnwin=findViewById(R.id.turnnwin);
        if(fullbox == true) {
            turnnwin.setText("No One Wins");
            gameend=true;
        }
        if(p1win==true)
            p1stat++;
        else if (p2win==true)
            p2stat++;
        p1.setText("P1:"+p1stat);
        p2.setText("P2:"+p2stat);
    }



}