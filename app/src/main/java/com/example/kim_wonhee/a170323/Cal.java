package com.example.kim_wonhee.a170323;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Cal extends AppCompatActivity {

    TabHost tabHost;
    FrameLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        setTitle("각종 계산");
        init();
    }

    void init() {

        background = (FrameLayout) findViewById(R.id.bg);
        tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").setIndicator("BMI 계산기").
                setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        return getBmiView();
                    }
                }));

        tabHost.addTab(tabHost.newTabSpec("B").setIndicator("면적 계산기").
                setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        return getLandView();
                    }
                }));

    }

    View getBmiView() {
        View view = View.inflate(Cal.this, R.layout.bmi, null);

        Button button_bmi = (Button) view.findViewById(R.id.button);

        final EditText write_cm = (EditText) view.findViewById(R.id.editText);
        final EditText write_kg = (EditText) view.findViewById(R.id.editText2);
        final TextView result_bmi = (TextView) view.findViewById(R.id.textView4);

        button_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (write_cm.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "키를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else if (write_kg.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "체중을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num_bmi, num_cm, num_kg;
                    String string_bmi;

                    num_cm = Double.parseDouble(write_cm.getText().toString());
                    num_kg = Double.parseDouble(write_kg.getText().toString());
                    num_bmi = num_kg / ((num_cm / 100) * (num_cm / 100));

                    if (num_bmi < 18.5) {
                        string_bmi = "체중부족";
                    } else if (num_bmi <= 22.9) {
                        string_bmi = "정상";
                    } else if (num_bmi <= 24.9) {
                        string_bmi = "과체중";
                    } else {
                        string_bmi="비만";
                    }
                    result_bmi.setText(string_bmi + "입니다!!!");
                    result_bmi.setTextColor(Color.RED);
                }
            }
        });
        return view;
    }

    View getLandView() {
        View view = View.inflate(Cal.this, R.layout.land, null);

        Button button_land1 = (Button) view.findViewById(R.id.button2);
        Button button_land2 = (Button) view.findViewById(R.id.button3);
        final TextView result_land = (TextView) view.findViewById(R.id.textView6);

        final EditText write_land = (EditText) view.findViewById(R.id.editText3);

        button_land1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (write_land.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "평이나 면적을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num, mm;

                    num = Double.parseDouble(write_land.getText().toString());

                    mm = num * 3.305785;

                    result_land.setText(mm + " 제곱미터");
                }
            }
        });

        button_land2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (write_land.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "평이나 면적을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    double num, po;

                    num = Double.parseDouble(write_land.getText().toString());

                    po = num * 0.3025;

                    result_land.setText(po + " 평");
                }
            }
        });

        return view;
    }

}








