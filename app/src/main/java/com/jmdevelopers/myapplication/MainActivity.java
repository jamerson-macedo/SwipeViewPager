package com.jmdevelopers.myapplication;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    ArrayList<Model> lista;
    Integer colors[] = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<>();
        lista.add(new Model(R.drawable.brochure, "Folheto", "odasOASOAsasaOSOASDoasdOASDOasd"));
        lista.add(new Model(R.drawable.sticker, "Adesivo", "odasOASOAsasaOSOASDoasdOASDOasd"));
        lista.add(new Model(R.drawable.poster, "Poster", "odasOASOAsasaOSOASDoasdOASDOasd"));
        lista.add(new Model(R.drawable.namecard, "nome cartão", "odasOASOAsasaOSOASDoasdOASDOasd"));

        adapter = new Adapter(lista, this);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] color_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };
        colors = color_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i < (adapter.getCount() - 1) && i < (colors.length - 1)) {

                    viewPager.setBackgroundColor((Integer)
                            argbEvaluator.evaluate(v, colors[i], colors[i + 1])
                    );
                } else {

                    viewPager.setBackgroundColor(colors[colors.length - 1]);

                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
}
