package com.cesoc.apps.android.dotaapp.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cesoc.apps.android.dotaapp.R;

import java.util.List;

public class ListAbilityAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Ability> abilities;

    ListAbilityAdapter(Context context, int layout, List<Ability> abilities){
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

            vh=new ViewHolder();

            vh.description=convertView.findViewById(R.id.itemDescription);
            vh.title=convertView.findViewById(R.id.itemTitle);
            vh.image=convertView.findViewById(R.id.itemImage);

            convertView.setTag(vh);

        }else{
            vh=(ViewHolder) convertView.getTag();
        }

        vh.title.setText(abilities.get(position).title);
        vh.description.setText(abilities.get(position).description);

        return convertView;
    }

    public class Ability{
        Ability(String title, String description){
            this.title=title;
            this.description=description;
        }
        String title;
        String description;
    }

    private static class ViewHolder{
        ImageView image;
        TextView title;
        TextView description;
    }
}

