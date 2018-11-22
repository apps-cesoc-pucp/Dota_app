package com.cesoc.apps.android.dotaapp.DotaApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if(convertView==null){
            LayoutInflater layoutInflater= LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(this.layout,null);

            holder=new ViewHolder();

            holder.textView = convertView.findViewById(R.id.textView);
            holder.imageView = convertView.findViewById(R.id.imageHeroGrid);


            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        Heroe heroe = this.heroes.get(position);
//        String nombreActual=this.heroes.get(position).getName() + " ";
        holder.textView.setText(heroe.getName());
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
