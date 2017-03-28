package com.example.kim_wonhee.a170323;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageShow extends AppCompatActivity {

    FrameLayout frame;
    ImageView image_chicken, image_pasta;
    TextView text_chicken, text_pasta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        setTitle("메뉴를 눌러보세요");

        init();
    }

    void init() {

        frame = (FrameLayout)findViewById(R.id.layout);
        image_chicken = (ImageView)findViewById(R.id.chicken);
        image_pasta = (ImageView)findViewById(R.id.pasta);
        text_chicken = (TextView)findViewById(R.id.text_chicken);
        text_pasta = (TextView)findViewById(R.id.text_pasta);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menubgRed) {
            frame.setBackgroundColor(Color.RED);
            item.setChecked(true);
        }
        else if (item.getItemId() == R.id.menubgBlue) {
            frame.setBackgroundColor(Color.BLUE);
            item.setChecked(true);
        }
        else if (item.getItemId() == R.id.menubgYellow) {
            frame.setBackgroundColor(Color.YELLOW);
            item.setChecked(true);
        }
        else if (item.getItemId() == R.id.menuChicken) {
            image_chicken.setVisibility(View.VISIBLE);
            image_pasta.setVisibility(View.INVISIBLE);
            text_chicken.setVisibility(View.INVISIBLE);
            text_pasta.setVisibility(View.INVISIBLE);
            item.setChecked(true);
        }
        else if (item.getItemId() == R.id.menuPasta) {
            image_chicken.setVisibility(View.INVISIBLE);
            image_pasta.setVisibility(View.VISIBLE);
            text_chicken.setVisibility(View.INVISIBLE);
            text_pasta.setVisibility(View.INVISIBLE);
            item.setChecked(true);
        }
        else if (item.getItemId() == R.id.menushTitle) {
            if (item.isChecked()) {
                if (image_chicken.getVisibility() == View.VISIBLE) {
                    text_chicken.setVisibility(View.INVISIBLE);
                    text_pasta.setVisibility(View.INVISIBLE);
                } else if (image_pasta.getVisibility() == View.VISIBLE) {
                    text_chicken.setVisibility(View.INVISIBLE);
                    text_pasta.setVisibility(View.INVISIBLE);
                }
                item.setChecked(false);
            }
            else {
                if (image_chicken.getVisibility() == View.VISIBLE) {
                    text_chicken.setVisibility(View.VISIBLE);
                    text_pasta.setVisibility(View.INVISIBLE);
                } else if (image_pasta.getVisibility() == View.VISIBLE) {
                    text_chicken.setVisibility(View.INVISIBLE);
                    text_pasta.setVisibility(View.VISIBLE);
                }
                item.setChecked(true);
            }
        }
        else if (item.getItemId() == R.id.menuRotate) {
            if (image_chicken.getVisibility() == View.VISIBLE) {
                image_chicken.setRotation(30);
            }
            else if (image_pasta.getVisibility() == View.VISIBLE) {
                image_pasta.setRotation(30);
            }
        }
        else if (item.getItemId() == R.id.menushLarge) {
            if (item.isChecked()) {
                if (image_chicken.getVisibility() == View.VISIBLE) {
                    image_chicken.setScaleX(1);
                    image_chicken.setScaleY(1);
                } else if (image_pasta.getVisibility() == View.VISIBLE) {
                    image_pasta.setScaleX(1);
                    image_pasta.setScaleY(1);
                }
                item.setChecked(false);
            }
            else {
                if (image_chicken.getVisibility() == View.VISIBLE) {
                    image_chicken.setScaleX(2);
                    image_chicken.setScaleY(2);
                } else if (image_pasta.getVisibility() == View.VISIBLE) {
                    image_pasta.setScaleX(2);
                    image_pasta.setScaleY(2);
                }
                item.setChecked(true);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}





