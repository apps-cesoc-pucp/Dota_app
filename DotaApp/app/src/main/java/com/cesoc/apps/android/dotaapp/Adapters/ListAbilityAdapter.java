package com.cesoc.apps.android.dotaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cesoc.apps.android.dotaapp.Models.Ability;
import com.cesoc.apps.android.dotaapp.R;

import java.util.List;

public class ListAbilityAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Ability> abilities;

    public ListAbilityAdapter(Context context, int layout, List<Ability> abilities){
        this.context=context;
        this.layout=layout;
        this.abilities=abilities;
    }

    @Override
    public int getCount() {
        return abilities.size();
    }

    @Override
    public Object getItem(int position) {
        return abilities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;

        if(convertView==null){

            convertView=LayoutInflater.from(context).inflate(layout,null);

            vh=new ViewHolder();

            vh.description=convertView.findViewById(R.id.abilityDescription);
            vh.title=convertView.findViewById(R.id.abilityTitle);
            vh.image=convertView.findViewById(R.id.abilityImage);

            convertView.setTag(vh);

        }else{
            vh=(ViewHolder) convertView.getTag();
        }

        vh.title.setText(abilities.get(position).getNombre());
        vh.description.setText(abilities.get(position).getDescripcion());

        RequestOptions options=new RequestOptions();
        options.fitCenter();
        options.circleCrop();
        Glide.with(this.context).load(abilities.get(position).getUrl_img()).apply(options).into(vh.image);

        return convertView;
    }

    private static class ViewHolder{
        ImageView image;
        TextView title;
        TextView description;
    }
}

