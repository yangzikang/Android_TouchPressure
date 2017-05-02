package com.atom.toucher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_main);

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch(action){
                    case (MotionEvent.ACTION_DOWN):
                        display("ACTION_DOWN",event);
                        break;
                    case (MotionEvent.ACTION_UP):
                        display("ACTION_UP",event);
                        break;
                    case (MotionEvent.ACTION_MOVE):
                        display("ACTION_MOVE",event);
                        break;
                }
                return true;
            }
        });

    }

    private void display(String eventType ,MotionEvent event){
        int x = (int)event.getX();
        int y = (int)event.getY();
        float presure = event.getPressure();
        TextView touchMessage = (TextView)findViewById(R.id.touchMessage);
        touchMessage.setText(eventType+"\n"+String.valueOf(x)+"\n"+String.valueOf(y)+"\n"+String.valueOf(presure));
    }
}
