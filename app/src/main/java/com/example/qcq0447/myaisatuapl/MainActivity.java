package com.example.qcq0447.myaisatuapl;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt3 = (Button)findViewById(R.id.button3);
        bt3.setOnClickListener(this);

        tv01 = (TextView)findViewById(R.id.tv_no1);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button3){
            Log.d("UITEST","ボタン3押されましたよ");
            showTimePickerDialog();
        }

    };

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UITEST", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        int in1 = (int)hourOfDay;
                        int in2 = (int)minute;
                        if(in1 >=  2 && in1 < 10){
                            tv01.setText("おはよう");
                        } else if (in1 >= 10 && in1 < 18 ){
                            tv01.setText("こんにちは");
                        } else {
                            tv01.setText("こんばんわ");
                        }

                                                    }


                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
