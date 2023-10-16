package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class botvsplayer extends AppCompatActivity {
    private String c="O";

    private List<TextView> boxes = new ArrayList<>();
    private boolean gameend=false;
    private int  pstat=0;
    private int bstat=0;
    private boolean pwin=false;
    private boolean bwin=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botvsplayer);
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
    public void clicker(View v) {
        TextView turnnwin = findViewById(R.id.turnnwin);
        TextView textView = (TextView) v;
        String currentText = textView.getText().toString();
        if (!gameend) {
            if (currentText.isEmpty()) {
                textView.setText(c);
                checkwinall();
                if(!gameend) allbotself();
                checkwinall();
                if(gameend)//if game has ended then calculating stat
                calcstat();
            }

        }
    }

    public void randomval() {
        Random rand = new Random();
        int i = rand.nextInt(9);
        boolean checkingempty = checkEmpty();
        if (checkingempty) {
            {
                if (boxes.get(i).getText().toString().isEmpty())//checking whether box is empty
                {
                    boxes.get(i).setText("X");
                } else {
                    randomval();//again generating random value
                }
            }
        }
    }

    public boolean botself(TextView t1,TextView t2,TextView t3,String c)//fourth var c for using it for stopping opponent
    {//temporary not implemented yet
        if(t1.getText().toString().equals(c) && t2.getText().toString().equals(c)  && t3.getText().toString().isEmpty())
        {
            t3.setText("X");
            return false;//it means no need to check for next since we got the value
        }
        else if(t2.getText().toString().equals(c) && t3.getText().toString().equals(c)  && t1.getText().toString().isEmpty())
        {
            t1.setText("X");
            return false;
        }
        else if(t1.getText().toString().equals(c) && t3.getText().toString().equals(c)  && t2.getText().toString().isEmpty())
        {
            t2.setText("X");
            return false;
        }
        else return  true;
    }

    public void allbotself()
    {
        boolean a=true;
        if(boxes.get(4).getText().toString().isEmpty()){a=false;
            boxes.get(4).setText("X");}
        if(a)a=botself(boxes.get(0),boxes.get(1),boxes.get(2),"X");
        if(a)a=botself(boxes.get(3),boxes.get(4),boxes.get(5),"X");
        if(a)a=botself(boxes.get(6),boxes.get(7),boxes.get(8),"X");
        if(a)a=botself(boxes.get(0),boxes.get(4),boxes.get(8),"X");
        if(a)a=botself(boxes.get(6),boxes.get(4),boxes.get(2),"X");
        if(a)a=botself(boxes.get(0),boxes.get(3),boxes.get(6),"X");
        if(a)a=botself(boxes.get(1),boxes.get(4),boxes.get(7),"X");
        if(a)a=botself(boxes.get(2),boxes.get(5),boxes.get(8),"X");

        if(a)a=botself(boxes.get(0),boxes.get(1),boxes.get(2),"O");
        if(a)a=botself(boxes.get(3),boxes.get(4),boxes.get(5),"O");
        if(a)a=botself(boxes.get(6),boxes.get(7),boxes.get(8),"O");
        if(a)a=botself(boxes.get(0),boxes.get(4),boxes.get(8),"O");
        if(a)a=botself(boxes.get(6),boxes.get(4),boxes.get(2),"O");
        if(a)a=botself(boxes.get(0),boxes.get(3),boxes.get(6),"O");
        if(a)a=botself(boxes.get(1),boxes.get(4),boxes.get(7),"O");
        if(a)a=botself(boxes.get(2),boxes.get(5),boxes.get(8),"O");


        if(a)randomval();

    }
    public void checkwin (TextView v1, TextView v2, TextView v3)
        {
            TextView turnnwin = findViewById(R.id.turnnwin);
            if (v1.getText().toString().equals("X") && v2.getText().toString().equals("X") && v3.getText().toString().equals("X")) {
                bwin = true;
                turnnwin.setText("BOT WINS");
                gameend = true;
            }
            if (v1.getText().toString().equals("O") && v2.getText().toString().equals("O") && v3.getText().toString().equals("O")) {
                pwin = true;
                turnnwin.setText("Player WINS");
                gameend = true;
            }
        }
        public boolean checkEmpty()
        {
            boolean check=false;
            for (int i = 0; i < 9; i++) {

                if (boxes.get(i).getText().toString().equals(""))//
                {
                    check = true;

                }
            }
            return check;
        }
        public void checkwinall (){

            boolean empty = true;

            checkwin(boxes.get(0), boxes.get(1), boxes.get(2));
            checkwin(boxes.get(3), boxes.get(4), boxes.get(5));
            checkwin(boxes.get(6), boxes.get(7), boxes.get(8));
            checkwin(boxes.get(0), boxes.get(3), boxes.get(6));
            checkwin(boxes.get(1), boxes.get(4), boxes.get(7));
            checkwin(boxes.get(2), boxes.get(5), boxes.get(8));
            checkwin(boxes.get(0), boxes.get(4), boxes.get(8));
            checkwin(boxes.get(6), boxes.get(4), boxes.get(2));


                    empty = checkEmpty();



            TextView turnnwin = findViewById(R.id.turnnwin);
            if (!gameend) {
                if (!empty) {
                    turnnwin.setText("No One Wins");
                    gameend = true;
                }
            }




        }
public void calcstat(){
    TextView p1 = findViewById(R.id.p1stat);
    TextView p2 = findViewById(R.id.p2stat);
    if (pwin == true)
        pstat++;
    else if (bwin == true)
        bstat++;
    p1.setText("P1:" + pstat);
    p2.setText("Bot:" + bstat);
}
    public void retry(View v)
    {
        // Perform operations on each TextView in the "boxes" list
        // For example, you can access and modify properties of each box.
        // Example:
        for (TextView box : boxes) {
            box.setText("");
        }
        bwin=false;
        pwin=false;
        gameend=false;
        TextView turnnwin=findViewById(R.id.turnnwin);
        turnnwin.setText("Player VS BOT");
    }
    public void navpvp(View v)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    }



