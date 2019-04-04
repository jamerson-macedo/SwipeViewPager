package com.jmdevelopers.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends PagerAdapter {
    private ArrayList<Model> models;
    private Context context;
    private LayoutInflater layoutInflater;

    public Adapter(ArrayList<Model> models, Context context) {
        this.models = models;
        this.context = context;

    }

    @Override
    public int getCount() {
        return models.size();

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);

    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item,container,false);
        //
        TextView titulo,descricao;
        ImageView imageView;
        titulo=view.findViewById(R.id.titulo);
        descricao=view.findViewById(R.id.descricao);
        imageView=view.findViewById(R.id.imagemview);

        imageView.setImageResource(models.get(position).getImagem());
        titulo.setText(models.get(position).getTitulo());
        descricao.setText(models.get(position).getDescricao());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
