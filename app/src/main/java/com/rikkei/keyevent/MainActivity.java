package com.rikkei.keyevent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btnQ)
    Button btnQ;
    @BindView(R.id.btnW)
    Button btnW;
    @BindView(R.id.btnE)
    Button btnE;
    @BindView(R.id.btnR)
    Button btnR;
    @BindView(R.id.btnT)
    Button btnT;
    @BindView(R.id.btnY)
    Button btnY;
    @BindView(R.id.btnU)
    Button btnU;
    @BindView(R.id.btnI)
    Button btnI;
    @BindView(R.id.btnO)
    Button btnO;
    @BindView(R.id.btnP)
    Button btnP;
    @BindView(R.id.btnA)
    Button btnA;
    @BindView(R.id.btnS)
    Button btnS;
    @BindView(R.id.btnD)
    Button btnD;
    @BindView(R.id.btnF)
    Button btnF;
    @BindView(R.id.btnG)
    Button btnG;
    @BindView(R.id.btnH)
    Button btnH;
    @BindView(R.id.btnJ)
    Button btnJ;
    @BindView(R.id.btnK)
    Button btnK;
    @BindView(R.id.btnL)
    Button btnL;
    @BindView(R.id.btnZ)
    Button btnZ;
    @BindView(R.id.btnX)
    Button btnX;
    @BindView(R.id.btnC)
    Button btnC;
    @BindView(R.id.btnV)
    Button btnV;
    @BindView(R.id.btnB)
    Button btnB;
    @BindView(R.id.btnN)
    Button btnN;
    @BindView(R.id.btnM)
    Button btnM;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.btnDown)
    Button btnDown;
    @BindView(R.id.btnLeft)
    Button btnLeft;
    @BindView(R.id.btnRight)
    Button btnRight;
    @BindView(R.id.btnEnter)
    Button btnEnter;


    private List<Button> buttons = new ArrayList<>();
    private List<Button> controls = new ArrayList<>();
    private String text = "";
    private String dpad ="DPAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();


    }

    private void init() {
        buttons.add(btn0);
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);
        buttons.add(btnQ);
        buttons.add(btnW);
        buttons.add(btnE);
        buttons.add(btnR);
        buttons.add(btnT);
        buttons.add(btnY);
        buttons.add(btnU);
        buttons.add(btnI);
        buttons.add(btnO);
        buttons.add(btnP);
        buttons.add(btnA);
        buttons.add(btnS);
        buttons.add(btnD);
        buttons.add(btnF);
        buttons.add(btnG);
        buttons.add(btnH);
        buttons.add(btnJ);
        buttons.add(btnK);
        buttons.add(btnL);
        buttons.add(btnZ);
        buttons.add(btnX);
        buttons.add(btnC);
        buttons.add(btnV);
        buttons.add(btnB);
        buttons.add(btnN);
        buttons.add(btnM);

        controls.add( btnUp);
        controls.add(btnDown);
        controls.add(btnLeft);
        controls.add(btnRight);
        controls.add(btnEnter);

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        String[] key = KeyEvent.keyCodeToString(event.getKeyCode()).split("_", 3);

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            for (int i = 0; i < buttons.size(); i++) {
                if (key[1].equals(buttons.get(i).getText().toString().trim())) {
                    buttons.get(i).setBackgroundColor(Color.BLUE);

                }
            }
            for(int i = 0 ; i <controls.size() ; i ++){
                if(key[1].equals(dpad)){
                    if(key[2].equals(controls.get(i).getText().toString().trim())){
                        controls.get(i).setBackgroundColor(Color.BLUE);

                    }else if(key[2].equals("CENTER")){
                        controls.get(controls.size()-1).setBackgroundColor(Color.BLUE);
                    }
                }
            }

        } else if (event.getAction() == KeyEvent.ACTION_UP) {
            for (int i = 0; i < buttons.size(); i++) {
                if (key[1].equals(buttons.get(i).getText().toString().trim())) {
                    buttons.get(i).setBackgroundResource(R.color.btnColor);
                    text = text.concat(key[1]);
                    tvData.setText(text.trim());
                    return true;

                }

            }
            for(int i = 0 ; i <controls.size(); i ++){
                if(key[1].equals(dpad)){
                    if(key[2].equals(controls.get(i).getText().toString().trim())){
                        controls.get(i).setBackgroundResource(R.color.btnColor);
                        return true;
                    }else if(key[2].equals("CENTER")){
                        controls.get(controls.size()-1).setBackgroundResource(R.color.btnColor);
                        return true;
                    }
                }
            }

        }
        return super.dispatchKeyEvent(event);

    }

}
