package com.cesoc.apps.android.dotaapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.cesoc.apps.android.dotaapp.Models.Heroe;
import com.cesoc.apps.android.dotaapp.R;

import java.util.List;

public class GridHeroeAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Heroe> heroes;

    public GridHeroeAdapter(Context context, int layout, List<Heroe> heroes){
        this.context=context;
        this.layout=layout;
        this.heroes=heroes;
    }

    @Override
    public int getCount() {
        return this.heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        final Heroe heroe = this.heroes.get(position);

        if(convertView==null){
            LayoutInflater layoutInflater= LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(this.layout,null);

            holder=new ViewHolder();

            holder.textView = convertView.findViewById(R.id.textHeroGrid);
            holder.imageView = convertView.findViewById(R.id.imageHeroGrid);

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        String nombreActual=heroe.getName() + " ";
        holder.textView.setText(nombreActual);

        //Cambio de color de acuerdo a primery attribute de cada heroe
        if(heroe.getPrimary_attr().compareTo("agi")==0)
            holder.textView.setBackgroundColor(context.getResources().getColor(R.color.agilidad));
        else if(heroe.getPrimary_attr().compareTo("str")==0)
            holder.textView.setBackgroundColor(context.getResources().getColor(R.color.fuerza));
        else if(heroe.getPrimary_attr().compareTo("int")==0)
            holder.textView.setBackgroundColor(context.getResources().getColor(R.color.inteligencia));

        holder.textView.getBackground().setAlpha(150);

        RequestOptions options=new RequestOptions();
        options.fitCenter();
        Glide.with(this.context).load(heroe.getImg_URL()).apply(options).into(holder.imageView);
        return convertView;

    }

    private static class ViewHolder{
        private TextView textView;
        private ImageView imageView;
    }
}
