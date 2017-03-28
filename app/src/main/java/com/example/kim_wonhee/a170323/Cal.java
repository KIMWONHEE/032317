package com.example.kim_wonhee.a170323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;

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

        background = (FrameLayout)findViewById(R.id.bg);
        tabHost = (TabHost)findViewById(R.id.tabHost);

        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").setIndicator("BMI 계산기").
                setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view = View.inflate(Cal.this, R.layout.bmi, null);
                return view;
            }
        }));

        tabHost.addTab(tabHost.newTabSpec("B").setIndicator("면적 계산기").
                setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        View view = View.inflate(Cal.this, R.layout.land, null);
                        return view;
                    }
                }));


    }
}
