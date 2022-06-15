package com.yoav.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView sum;
    private RelativeLayout num0;
    private RelativeLayout num1;
    private RelativeLayout num2;
    private RelativeLayout num3;
    private RelativeLayout num4;
    private RelativeLayout num5;
    private RelativeLayout num6;
    private RelativeLayout num7;
    private RelativeLayout num8;
    private RelativeLayout num9;
    private char oper = ' ';
    private double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    public void setPointer(){
        sum = findViewById(R.id.sum);
    }


    @Override
    public void onClick(View view) {
        double myNum = Double.parseDouble(sum.getText().toString());

        switch (view.getId()){
            case R.id.num1:
                myNum = myNum*10+1;
                break;
            case R.id.num2:
                myNum = myNum*10+2;
                break;
            case R.id.num3:
                myNum = myNum*10+3;
                break;
            case R.id.num4:
                myNum = myNum*10+4;
                break;
            case R.id.num5:
                myNum = myNum*10+5;
                break;
            case R.id.num6:
                myNum = myNum*10+6;
                break;
            case R.id.num7:
                myNum = myNum*10+7;
                break;
            case R.id.num8:
                myNum = myNum*10+8;
                break;
            case R.id.num9:
                myNum = myNum*10+9;
                break;
            case R.id.num0:
                myNum = myNum*10;
                break;
            case R.id.clr:
                myNum=0;
                break;
            case R.id.plus:
                total=myNum;
                myNum=0;
                oper = '+';
                break;
            case R.id.min:
                total=myNum;
                myNum=0;
                oper = '-';
                break;
            case R.id.multiply:
                total=myNum;
                myNum=0;
                oper = '*';
                break;
            case R.id.div:
                total=myNum;
                myNum=0;
                oper = '/';
                break;
            case R.id.eql:
                switch (oper){
                    case '+':
                        myNum+=total;
                        oper=' ';
                        total=myNum;
                        break;
                    case '-':
                        myNum-=total;
                        oper=' ';
                        total=myNum;
                        break;
                    case '*':
                        myNum*=total;
                        oper=' ';
                        total=myNum;
                        break;
                    case '/':
                        if (myNum==0){
                            total=0;
                            sum.setText("err");
                            return;
                        }
                        myNum/=total;
                        oper=' ';
                        total=myNum;
                        break;
                    case ' ':
                        myNum=total;
                        break;
                }
                break;
        }
        sum.setText(String.valueOf(myNum));
    }
}